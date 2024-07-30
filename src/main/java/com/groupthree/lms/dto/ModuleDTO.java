package com.groupthree.lms.dto;
import com.groupthree.lms.entities.Course;
import com.groupthree.lms.entities.Topics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModuleDTO {

    private Long id;
    private String title;
    private String description;
    private Course course;
    private List<Topics> topic;
}
