package coursemanagement.coursemanagement.dto;
import coursemanagement.coursemanagement.entities.Course;
import coursemanagement.coursemanagement.entities.Topics;

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
