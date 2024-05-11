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
public class DirectoryModel {

    private String name;
    private String charge;
    private String email;
    private Integer faculty;
    private List<Integer> campus;

}
