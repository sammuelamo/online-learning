package coursemanagement.coursemanagement.dto;

import coursemanagement.coursemanagement.entities.Quiz;
import coursemanagement.coursemanagement.entities.Topics;
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

