package com.fusm.sinu.service.impl;

import com.fusm.sinu.model.Group;
import com.fusm.sinu.model.SubjectData;
import com.fusm.sinu.model.User;
import com.fusm.sinu.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Override
    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(
                User.builder()
                        .email("decano.atenea@gmail.com")
                        .password("123456")
                        .name("Decano 1 user")
                        .faculty(11)
                        .role(5)
                        .charge("Decano")
                        .campus(Arrays.asList(new Integer[]{16, 17}))
                        .build()
        );
        userList.add(
                User.builder()
                        .email("decano2.atenea@fusm.edu.co")
                        .password("123456")
                        .name("Decano 2 user")
                        .faculty(13)
                        .role(5)
                        .campus(Arrays.asList(new Integer[]{16, 17}))
                        .charge("Decano")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("vicerrector.atenea@gmail.com")
                        .password("123456")
                        .name("Vicer rector user")
                        .role(2)
                        .campus(Arrays.asList(new Integer[]{16}))
                        .charge("Vicerrector")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("estudiante@fusm.edu.co")
                        .password("123456")
                        .name("Estudiante user")
                        .faculty(11)
                        .programId(new Integer[]{1})
                        .role(4)
                        .groups(getGroup())
                        .campus(Arrays.asList(new Integer[]{16, 17}))
                        .charge("Estudiante")
                        .gender("M")
                        .currentSubject(getCurrentCourse())
                        .historySubject(getHistoryCourse())
                        .code("ABC123")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("director.fs.atenea@gmail.com")
                        .password("123456")
                        .name("director user")
                        .faculty(11)
                        .role(1)
                        .campus(Arrays.asList(new Integer[]{17}))
                        .charge("Director / Docente")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("director2.fs.atenea@gmail.com")
                        .password("123456")
                        .name("director 2 user")
                        .faculty(11)
                        .role(1)
                        .campus(Arrays.asList(new Integer[]{16, 17}))
                        .charge("Director / Docente")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("root.fs.atenea@gmail.com")
                        .password("123456")
                        .name("administrador user")
                        .role(3)
                        .campus(Arrays.asList(new Integer[]{17}))
                        .build()
        );
        userList.add(
                User.builder()
                        .email("calidad.fs.atenea@gmail.com")
                        .password("123456")
                        .name("calidad user")
                        .role(6)
                        .campus(Arrays.asList(new Integer[]{16, 17}))
                        .charge("Aseguramiento de calidad")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("robimar.vera@itsense.com.co")
                        .password("123456")
                        .name("Decano Robimar")
                        .faculty(11)
                        .role(5)
                        .campus(Arrays.asList(new Integer[]{16, 17}))
                        .charge("Decano")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("luisa.monsalve@itsense.com.co")
                        .password("123456")
                        .name("Decano Luisa")
                        .faculty(11)
                        .role(5)
                        .campus(Arrays.asList(new Integer[]{16}))
                        .charge("Decano")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("cristian.gomez@itsense.com.co")
                        .password("123456")
                        .name("Vicerrector cristian")
                        .role(2)
                        .campus(Arrays.asList(new Integer[]{16, 17}))
                        .charge("Vicerrector")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("brayan.guardo@itsense.com.co")
                        .password("123456")
                        .name("Vicerrector Brayan")
                        .role(2)
                        .campus(Arrays.asList(new Integer[]{16, 17}))
                        .charge("Vicerrector")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("laura.sanchez@itsense.com.co")
                        .password("123456")
                        .name("Director Valentina")
                        .faculty(11)
                        .role(1)
                        .campus(Arrays.asList(new Integer[]{16, 17}))
                        .charge("Director / Docente")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("andrea.gomez@itsense.com.co")
                        .password("123456")
                        .name("Calidad Andrea")
                        .role(6)
                        .campus(Arrays.asList(new Integer[]{16, 17}))
                        .charge("Aseguramiento de calidad")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("sergio.galvis@itsense.com.co")
                        .password("123456")
                        .name("Calidad Sergio")
                        .role(6)
                        .campus(Arrays.asList(new Integer[]{16, 17}))
                        .charge("Aseguramiento de calidad")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("docente@gmail.com")
                        .password("123456")
                        .name("Docente coordinador")
                        .role(7)
                        .faculty(11)
                        .programId(new Integer[]{1})
                        .campus(Arrays.asList(new Integer[]{16, 17}))
                        .charge("Docente")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("docente.andrea@gmail.com")
                        .password("123456")
                        .name("Docente coordinador andrea")
                        .role(7)
                        .faculty(11)
                        .programId(new Integer[]{1})
                        .campus(Arrays.asList(new Integer[]{16, 17}))
                        .charge("Docente")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("damon.salvatore@gmail.com")
                        .password("123456")
                        .name("Damon Salvatore profe")
                        .role(9)
                        .faculty(11)
                        .programId(new Integer[]{1})
                        .subjects(Arrays.asList(new String[]{"S1A2023", "S2A2013", "S1B2024", "S1C20211"}))
                        .campus(Arrays.asList(new Integer[]{16, 17}))
                        .charge("Docente")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("pepito.perez@gmail.com")
                        .password("123456")
                        .name("Pepito Perez basico profe")
                        .role(9)
                        .faculty(11)
                        .programId(new Integer[]{1})
                        .subjects(Arrays.asList(new String[]{"S1A2023", "S2A2013", "S1B2024", "S1C20211", "FS2031", "ALM2023", "BFD2723", "ESC20241", "CALC20241", "NIK20241"}))
                        .campus(Arrays.asList(new Integer[]{16, 17}))
                        .charge("Docente")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("monkey.d.luffy@gmail.co")
                        .password("123456")
                        .name("Monkey D Luffy Rey basico profe")
                        .role(9)
                        .faculty(11)
                        .programId(new Integer[]{1})
                        .subjects(Arrays.asList(new String[]{"S1A2023", "S6A2001", "S1C20211"}))
                        .campus(Arrays.asList(new Integer[]{16, 17}))
                        .charge("Docente")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("luis.camilo@gmail.com")
                        .password("123456")
                        .name("Luis camilo Estudiante")
                        .role(4)
                        .faculty(11)
                        .programId(new Integer[]{1})
                        .groups(getGroup())
                        .campus(Arrays.asList(new Integer[]{16, 17}))
                        .charge("Estudiante")
                        .gender("M")
                        .currentSubject(getCurrentCourse())
                        .historySubject(getHistoryCourse())
                        .code("ABC123")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("sharpay.ryan@gmail.com")
                        .password("123456")
                        .name("Sharpay Ryan estudiante")
                        .role(4)
                        .faculty(11)
                        .programId(new Integer[]{1})
                        .groups(getGroup())
                        .campus(Arrays.asList(new Integer[]{16, 17}))
                        .charge("Estudiante")
                        .gender("F")
                        .currentSubject(getCurrentCourse())
                        .historySubject(getHistoryCourse())
                        .code("ABC123")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("juan.gabriel@itsense.com.co")
                        .password("123456")
                        .name("Juan Gabriel Estudiante")
                        .role(4)
                        .faculty(11)
                        .programId(new Integer[]{1})
                        .groups(getGroup())
                        .campus(Arrays.asList(new Integer[]{16, 17}))
                        .charge("Estudiante")
                        .gender("M")
                        .currentSubject(getCurrentCourse())
                        .historySubject(getHistoryCourse())
                        .code("ABC123")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("elena.martinez@itsense.com.co")
                        .password("123456")
                        .name("Elena martinez Estudiante")
                        .role(10)
                        .faculty(11)
                        .programId(new Integer[]{28})
                        .campus(Arrays.asList(new Integer[]{16, 17}))
                        .charge("Estudiante")
                        .gender("F")
                        .currentSubject(getCurrentCourse())
                        .historySubject(getHistoryCourse())
                        .build()
        );
        userList.add(
                User.builder()
                        .email("alejandro.lopez@itsense.com.co")
                        .password("123456")
                        .name("Alejandro Lopez Estudiante")
                        .role(10)
                        .faculty(11)
                        .programId(new Integer[]{28})
                        .campus(Arrays.asList(new Integer[]{16, 17}))
                        .charge("Estudiante")
                        .gender("M")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("maria.rodriguez@itsense.com.co")
                        .password("123456")
                        .name("Maria Rodriguez Estudiante")
                        .role(10)
                        .faculty(11)
                        .programId(new Integer[]{28})
                        .campus(Arrays.asList(new Integer[]{16, 17}))
                        .charge("Estudiante")
                        .gender("F")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("juan.garcia@itsense.com.co")
                        .password("123456")
                        .name("Juan Garcia Estudiante")
                        .role(10)
                        .faculty(11)
                        .programId(new Integer[]{28})
                        .campus(Arrays.asList(new Integer[]{16, 17}))
                        .charge("Estudiante")
                        .gender("M")
                        .build()
        );
        userList.add(
                User.builder()
                        .email("fernando.vigolla@gmail.com")
                        .password("123456")
                        .name("Fernando Vigolla Marchena")
                        .role(11)
                        .faculty(11)
                        .programId(new Integer[]{28})
                        .build()
        );

        return userList;
    }

    private List<Group> getGroup() {
        List<Group> groups = new ArrayList<>();
        groups.add(
                Group.builder()
                        .group("1")
                        .teacher("damon.salvatore@gmail.com")
                        .subjectCode("S1A2023")
                        .build()
        );
        groups.add(
                Group.builder()
                        .group("1")
                        .teacher("damon.salvatore@gmail.com")
                        .subjectCode("S2A2013")
                        .build()
        );
        groups.add(
                Group.builder()
                        .group("1")
                        .teacher("damon.salvatore@gmail.com")
                        .subjectCode("S1B2024")
                        .build()
        );
        groups.add(
                Group.builder()
                        .group("1")
                        .teacher("monkey.d.luffy@gmail.co")
                        .subjectCode("S6A2001")
                        .build()
        );
        groups.add(
                Group.builder()
                        .group("1")
                        .teacher("pepito.perez@gmail.com")
                        .subjectCode("S1C20211")
                        .build()
        );
        groups.add(
                Group.builder()
                        .group("1")
                        .teacher("pepito.perez@gmail.com")
                        .subjectCode("BFD2723")
                        .build()
        );
        groups.add(
                Group.builder()
                        .group("1")
                        .teacher("pepito.perez@gmail.com")
                        .subjectCode("ALM2023")
                        .build()
        );
        groups.add(
                Group.builder()
                        .group("1")
                        .teacher("pepito.perez@gmail.com")
                        .subjectCode("FS2031")
                        .build()
        );
        return groups;
    }

    private List<SubjectData> getHistoryCourse() {
        List<SubjectData> subjectData = new ArrayList<>();
        subjectData.add(
                SubjectData.builder()
                        .code("S1A2023")
                        .period("2023-II")
                        .qalification(4.3)
                        .build()
        );
        subjectData.add(
                SubjectData.builder()
                        .code("S1B2024")
                        .period("2023-II")
                        .qalification(4.6)
                        .build()
        );
        return subjectData;
    }

    private List<SubjectData> getCurrentCourse() {
        List<SubjectData> subjectData = new ArrayList<>();
        subjectData.add(
                SubjectData.builder()
                        .code("S2A2013")
                        .period("2024-I")
                        .qalification(4.3)
                        .build()
        );
        subjectData.add(
                SubjectData.builder()
                        .code("S6A2001")
                        .period("2024-I")
                        .qalification(4.6)
                        .build()
        );
        return subjectData;
    }

}
