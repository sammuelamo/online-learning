package coursemanagement.coursemanagement.service;

import coursemanagement.coursemanagement.entities.Course;
import coursemanagement.coursemanagement.entities.Syllabus;
import coursemanagement.coursemanagement.repository.CourseRepository;
import coursemanagement.coursemanagement.repository.SyllabusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SyllabusService {

    private final SyllabusRepository syllabusRepository;
    private final CourseService courseService;

    public SyllabusService(SyllabusRepository syllabusRepository, CourseService courseService) {
        this.syllabusRepository = syllabusRepository;
        this.courseService = courseService;
    }

    public List<Syllabus> getAllSyllabus() {
        return syllabusRepository.findAll();
    }

    public Optional<Syllabus> getSyllabusById(Long id) {
        return syllabusRepository.findById(id);
    }

    public Syllabus saveSyllabus(Syllabus syllabus) {
        if (syllabus.getCourse() == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }
        Course course = courseService.getCourseById(syllabus.getCourse().getId());
        syllabus.setCourse(course);
        return syllabusRepository.save(syllabus);
    }

    public void deleteSyllabus(Long id) {
        syllabusRepository.deleteById(id);
    }

//    public Syllabus updateSyllabus(Long id, Syllabus updatedSyllabus) {
//        Optional<Syllabus> optionalSyllabus = syllabusRepository.findById(id);
//        if (optionalSyllabus.isPresent()) {
//            Syllabus syllabus = optionalSyllabus.get();
//            syllabus.setTitle(updatedSyllabus.getTitle());
//            syllabus.setDescription(updatedSyllabus.getDescription());
//            syllabus.setCourse(updatedSyllabus.getCourse());
//            syllabus.setTopic(updatedSyllabus.getTopic());
//            return syllabusRepository.save(syllabus);
//        } else {
//            throw new RuntimeException("Syllabus not found with id " + id);
//        }
//    }
}

