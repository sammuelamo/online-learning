package com.groupthree.lms.dto;

import com.groupthree.lms.entities.Topics;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDTO {
    private Long id;
    private String quiz;
    private Topics topic;
}
