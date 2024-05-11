package com.fusm.sinu.service;

import com.fusm.sinu.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISinuService {

    List<UserByRoleModel> getUserByRole(Integer roleId);
    List<UserByRoleModel> getUserByRolesIds(SearchRoles roles);
    CodeModel getSubjectsCodeByUserId(String userId);
    CodeModel getTeacherIdBySubjectCode(String subjectCode);
    CodeModel getTeacherOfStudentBYSubjectCode(UserGroup userGroup);
    List<DirectoryModel> getDirectory(SearchDirectory searchDirectory);
    UserGender getUserGender();
    Integer getStudentsByFaculty(Integer facultyId);
    List<SubjectData> getCurrentSubject(String userId);
    List<SubjectData> getHistorySubject(String userId);
    UserData getUserData(String userId);

}
