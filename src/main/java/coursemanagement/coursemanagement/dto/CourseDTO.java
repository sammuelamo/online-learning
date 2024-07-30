package coursemanagement.coursemanagement.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import coursemanagement.coursemanagement.entities.Module;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
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
