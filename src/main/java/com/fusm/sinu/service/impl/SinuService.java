package com.fusm.sinu.service.impl;

import com.fusm.sinu.model.*;
import com.fusm.sinu.service.ISinuService;
import com.fusm.sinu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SinuService implements ISinuService {

    @Autowired
    private IUserService userService;


    @Override
    public List<UserByRoleModel> getUserByRole(Integer roleId) {
        List<UserByRoleModel> sinuList = new ArrayList<>();
        sinuList = userService.getUsers().stream()
                .filter(user -> user.getRole().equals(roleId))
                .map(user -> UserByRoleModel.builder()
                        .userId(user.getEmail())
                        .userEmail(user.getEmail())
                        .roleId(user.getRole())
                        .build())
                .collect(Collectors.toList());
        return sinuList;
    }

    @Override
    public List<UserByRoleModel> getUserByRolesIds(SearchRoles roles) {
        List<UserByRoleModel> sinuList = new ArrayList<>();
        sinuList = userService.getUsers().stream()
                .filter(user -> user.getRole() != null && roles.getRoles().contains(user.getRole()))
                .map(user -> UserByRoleModel.builder()
                        .userId(user.getEmail())
                        .userEmail(user.getEmail())
                        .roleId(user.getRole())
                        .build())
                .collect(Collectors.toList());
        return sinuList;
    }

    @Override
    public CodeModel getSubjectsCodeByUserId(String userId) {
        List<User> userResult = userService.getUsers().stream()
                .filter(user -> user.getEmail().equals(userId))
                .toList();
        return CodeModel.builder()
                .code((!userResult.isEmpty()) ?
                        userResult.get(0).getSubjects() : new ArrayList<>())
                .build();
    }

    @Override
    public CodeModel getTeacherIdBySubjectCode(String subjectCode) {
        List<String> userResult = userService.getUsers().stream()
                .filter(user -> user.getSubjects() != null && user.getSubjects().contains(subjectCode))
                .map(User::getEmail)
                .toList();
        return CodeModel.builder()
                .code(userResult)
                .build();
    }

    @Override
    public CodeModel getTeacherOfStudentBYSubjectCode(UserGroup userGroup) {
        return CodeModel.builder()
                .code(userService.getUsers().stream()
                        .filter(user -> user.getRole() != null && user.getRole() == 4 && user.getEmail().equals(userGroup.getCreatedBy()))
                        .flatMap(user -> user.getGroups().stream()
                                .filter(group -> group.getSubjectCode() != null && group.getSubjectCode().equals(userGroup.getSubjectCode()))
                                .map(Group::getTeacher))
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public List<DirectoryModel> getDirectory(SearchDirectory searchDirectory) {
        List<User> users = userService.getUsers();
        users = users.stream().filter(user -> user.getRole() != 3).collect(Collectors.toList());
        if (searchDirectory.getName() != null) users = users.stream().filter(user ->
                user.getName().toLowerCase().contains(searchDirectory.getName().toLowerCase())).toList();
        if (!searchDirectory.getFacultyId().isEmpty()) users = users.stream().filter(
                user -> user.getFaculty() != null && searchDirectory.getFacultyId().contains(user.getFaculty())).toList();
        if (!searchDirectory.getCampusId().isEmpty()) users = users.stream().filter(
                user -> hasCommonItems(user.getCampus(), searchDirectory.getCampusId())).toList();
        return buildUserDirectory(users);
    }

    @Override
    public UserGender getUserGender() {
        List<User> users = userService.getUsers();
        users = users.stream().filter(user -> (user.getRole().equals(4) || user.getRole().equals(10))).toList();
        int masc = users.stream().filter(
                        user ->  user.getGender().equals("M"))
                .toList().size();
        int fem = users.stream().filter(
                        user ->  user.getGender().equals("F"))
                .toList().size();
        return UserGender.builder()
                .masc((double) ((masc * 100) / users.size()))
                .fem((double) ((fem * 100) / users.size()))
                .build();
    }

    @Override
    public Integer getStudentsByFaculty(Integer facultyId) {
        List<User> users = userService.getUsers();
        users = users.stream().filter(user ->
                (user.getRole().equals(4) || user.getRole().equals(10))
                && user.getFaculty().equals(facultyId)
        ).toList();
        return users.size();
    }

    @Override
    public List<SubjectData> getCurrentSubject(String userId) {
        List<User> userList = userService.getUsers().stream().filter(
                user -> user.getEmail().equalsIgnoreCase(userId)
        ).toList();
        return (!userList.isEmpty()) ?
                userList.get(0).getCurrentSubject() : new ArrayList<>();
    }

    @Override
    public List<SubjectData> getHistorySubject(String userId) {
        List<User> userList = userService.getUsers().stream().filter(
                user -> user.getEmail().equalsIgnoreCase(userId)
        ).toList();
        return (!userList.isEmpty()) ?
                userList.get(0).getHistorySubject() : new ArrayList<>();
    }

    @Override
    public UserData getUserData(String userId) {
        List<User> userList = userService.getUsers().stream().filter(
                user -> user.getEmail().equalsIgnoreCase(userId)
        ).toList();
        return (!userList.isEmpty()) ?
                UserData.builder()
                        .email(userList.get(0).getEmail())
                        .code(userList.get(0).getCode())
                        .build()
                : new UserData();
    }

    private boolean hasCommonItems(List<Integer> campus, List<Integer> campusFilter) {
        return campus.stream().anyMatch(campusFilter::contains);
    }

    private List<DirectoryModel> buildUserDirectory(List<User> users) {
        return users.stream().map(
                user -> DirectoryModel.builder()
                        .name(user.getName())
                        .charge(user.getCharge())
                        .email(user.getEmail())
                        .faculty(user.getFaculty())
                        .campus(user.getCampus())
                        .build()
        ).toList();
    }

}
