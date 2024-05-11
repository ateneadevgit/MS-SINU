package com.fusm.sinu.controller;

import com.fusm.sinu.model.*;
import com.fusm.sinu.service.ISinuService;
import com.fusm.sinu.util.AppRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase que expone los servicios consumidos de SINU
 * ITSense Inc - Andrea Gómez
 */

@RestController
@RequestMapping(value = AppRoutes.SINU_ROUTE)
public class SinuController {

    @Autowired
    private ISinuService sinuService;


    /**
     * Obtiene los usuarios según un rol
     * @param roleId ID del rol
     * @return lista de usuarios
     */
    @GetMapping("/user/by-role/{id}")
    private ResponseEntity<List<UserByRoleModel>> getUserByRole(
            @PathVariable("id") Integer roleId
    ) {
        return ResponseEntity.ok(sinuService.getUserByRole(roleId));
    }

    /**
     * Obtiene los usuarios segun varios roles
     * @param roles Lista de roles
     * @return lista de usuarios
     */
    @PostMapping("/user/by-role")
    private ResponseEntity<List<UserByRoleModel>> getUserByRoles(
            @RequestBody SearchRoles roles
    ) {
        return ResponseEntity.ok(sinuService.getUserByRolesIds(roles));
    }

    /**
     * Obtiene una lista de asignaturas segun el usuario
     * @param userId ID del usuario
     * @return lista de códigos de asignaturas
     */
    @PostMapping("/subject/by-user")
    private ResponseEntity<CodeModel> getSubjectsCodeByUserId(
            @RequestBody String userId
    ) {
        return ResponseEntity.ok(sinuService.getSubjectsCodeByUserId(userId));
    }

    /**
     * Obtiene los códigos de asignatura que dicta un docente según el ID del docente
     * @param subjectCode Código de la asginatura
     * @return lista de códigos
     */
    @PostMapping("/user/subject-code")
    private ResponseEntity<CodeModel> getTeacherIdBySubjectCode(
            @RequestBody String subjectCode
    ) {
        return ResponseEntity.ok(sinuService.getTeacherIdBySubjectCode(subjectCode));
    }

    /**
     * Obtiene una lista de los docentes de un profesor según un estudiante
     * @param userGroup Modelo que permite realizar la consulta
     * @return lista de codigos
     */
    @PostMapping("/user/student/subject-code")
    private ResponseEntity<CodeModel> getTeacherOfStudentBYSubjectCode(
            @RequestBody UserGroup userGroup
    ) {
        return ResponseEntity.ok(sinuService.getTeacherOfStudentBYSubjectCode(userGroup));
    }

    /**
     * Obtiene una lista de todos los usuarios registrados en la aplicación
     * @param searchDirectory Modelo que permite realizar la búsqueda y aplicar filtros
     * @return lista de usuarios
     */
    @PostMapping("/directory")
    private ResponseEntity<List<DirectoryModel>> getDirectory(
            @RequestBody SearchDirectory searchDirectory) {
        return ResponseEntity.ok(sinuService.getDirectory(searchDirectory));
    }

    /**
     * Obtiene la lista de usuarios con rol estudiante por facultad
     * @param facultyId ID de la facultad
     * @return lista de estudiantes
     */
    @GetMapping("/user/by-faculty/{facultyId}")
    private ResponseEntity<Integer> getUsersByFaculty(
            @PathVariable("facultyId") Integer facultyId
    ) {
        return ResponseEntity.ok(sinuService.getStudentsByFaculty(facultyId));
    }

    /**
     * Obtiene la cantidad de mujeres y hombres registrados en la aplicación
     * @return lista de usuarios
     */
    @GetMapping("/user/by-gender")
    private ResponseEntity<UserGender> getUserGender() {
        return ResponseEntity.ok(sinuService.getUserGender());
    }

    /**
     * Obtiene la lista de asignaturas que esta cursando actualmente un usuario
     * @param userId ID del usuario
     * @return lista de asignaturas
     */
    @GetMapping("/current-subject/user/{userId}")
    private ResponseEntity<List<SubjectData>> getCurrentSubject(
            @PathVariable("userId") String userId
    ) {
        return ResponseEntity.ok(sinuService.getCurrentSubject(userId));
    }

    /**
     * Obtiene la lista de asignaturas cursadas por un usuario
     * @param userId ID del usuario
     * @return lista de asignaturas
     */
    @GetMapping("/history-subject/user/{userId}")
    private ResponseEntity<List<SubjectData>> getHistorySubject(
            @PathVariable("userId") String userId
    ) {
        return ResponseEntity.ok(sinuService.getHistorySubject(userId));
    }

    /**
     * Obntiene la información de un usuario
     * @param userId ID del usuario
     * @return información del usuairo
     */
    @GetMapping("/user/{userId}/data")
    private ResponseEntity<UserData> getUserData(
            @PathVariable("userId") String userId
    ) {
        return ResponseEntity.ok(sinuService.getUserData(userId));
    }

}
