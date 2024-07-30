package com.groupthree.lms.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.groupthree.lms.entities.Module;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private Long id;
    private String title;
    private String description;
    private String syllabus;
    private String schedule;

    @JsonManagedReference
    private List<Module> modules;
}
