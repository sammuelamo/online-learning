package coursemanagement.coursemanagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String schedule;


    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Syllabus> syllabus;
}
