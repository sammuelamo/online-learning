package coursemanagement.coursemanagement.service;

import coursemanagement.coursemanagement.dto.CourseDTO;
import coursemanagement.coursemanagement.entities.Course;
import coursemanagement.coursemanagement.entities.Module;
import coursemanagement.coursemanagement.repository.ModuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    private final ModuleRepository moduleRepository;
    private final CourseService courseService;

    public ModuleService(ModuleRepository syllabusRepository, CourseService courseService) {
        this.moduleRepository = syllabusRepository;
        this.courseService = courseService;
    }

    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    public Optional<Module> getModuleById(Long id) {
        return moduleRepository.findById(id);
    }

    public Module saveModule(Module module) {
        if (module.getCourse() == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }
        CourseDTO courseDTO = courseService.getCourseById(module.getCourse().getId());
        Course course = convertToEntity(courseDTO);
        module.setCourse(course);
        return moduleRepository.save(module);
    }

    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }

    private Course convertToEntity(CourseDTO courseDTO) {
        return new Course(courseDTO.getId(), courseDTO.getTitle(), courseDTO.getDescription(),
                courseDTO.getSyllabus(), courseDTO.getSchedule(), courseDTO.getModules());
    }


}

