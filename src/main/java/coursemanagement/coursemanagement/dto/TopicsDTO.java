package coursemanagement.coursemanagement.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import coursemanagement.coursemanagement.entities.Module;
import coursemanagement.coursemanagement.entities.Quiz;

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
