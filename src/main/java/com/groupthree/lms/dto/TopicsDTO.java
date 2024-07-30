package com.groupthree.lms.dto;

import com.groupthree.lms.entities.Module;
import com.groupthree.lms.entities.Quiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicsDTO {

    private Long id;
    private String name;
    private String content;
    private String conclusion;
    private Module module;
    private List<Quiz> quizzes;
}
