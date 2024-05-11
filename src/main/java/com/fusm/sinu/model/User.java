package com.fusm.sinu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String email;
    private String password;
    private String name;
    private Integer faculty;
    private List<Integer> campus;
    private Integer role;
    private Integer[] programId;
    private List<String> subjects;
    private List<Group> groups;
    private String charge;
    private String gender;
    private List<SubjectData> currentSubject;
    private List<SubjectData> historySubject;
    private String code;

}