package coursemanagement.coursemanagement.service;

import coursemanagement.coursemanagement.dto.CourseDTO;
import coursemanagement.coursemanagement.dto.ModuleDTO;
import coursemanagement.coursemanagement.entities.Course;
import coursemanagement.coursemanagement.entities.Module;
import coursemanagement.coursemanagement.repository.ModuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModuleService {

    private final ModuleRepository moduleRepository;
    private final CourseService courseService;

    public ModuleService(ModuleRepository syllabusRepository, CourseService courseService) {
        this.moduleRepository = syllabusRepository;
        this.courseService = courseService;
    }

    public List<ModuleDTO> getAllModules() {
        return moduleRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ModuleDTO getModuleById(Long id) {
        return convertToDTO(moduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Module not found with ID: ")));
    }

    public ModuleDTO saveModule(ModuleDTO moduleDTO) {
        if (moduleDTO.getCourse() == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }
        CourseDTO courseDTO = courseService.getCourseById(moduleDTO.getCourse().getId());
        Course course = convertToEntity(courseDTO);
        Module module = convertToEntity(moduleDTO);
        module.setCourse(course);
        Module savedModule = moduleRepository.save(module);
        return convertToDTO(savedModule);
    }

    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }

    private ModuleDTO convertToDTO(Module module) {
        return new ModuleDTO(module.getId(), module.getTitle(), module.getDescription(),
                module.getCourse(), module.getTopic());
    }

    public Module convertToEntity(ModuleDTO moduleDTO) {
        return new Module(moduleDTO.getId(), moduleDTO.getTitle(), moduleDTO.getDescription(),
                moduleDTO.getCourse(), moduleDTO.getTopic());
    }

    private Course convertToEntity(CourseDTO courseDTO) {
        return new Course(courseDTO.getId(), courseDTO.getTitle(), courseDTO.getDescription(),
                courseDTO.getSyllabus(), courseDTO.getSchedule(), courseDTO.getModules());
    }


}

