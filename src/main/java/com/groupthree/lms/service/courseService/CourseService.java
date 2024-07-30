package com.groupthree.lms.service.courseService;

import com.groupthree.lms.dto.courseDto.CourseDTO;
import com.groupthree.lms.models.courseModel.Course;
import com.groupthree.lms.repositories.courseRepository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepository;


    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CourseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return convertToDTO(course);
    }

    public CourseDTO addCourse(CourseDTO courseDTO) {
        Course course = convertToEntity(courseDTO);
        Course savedCourse = courseRepository.save(course);
        return convertToDTO(savedCourse);
    }

    public CourseDTO updateCourse(Long id, CourseDTO courseDetails) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + id));

        course.setTitle(courseDetails.getTitle());
        course.setDescription(courseDetails.getDescription());
        course.setSchedule(courseDetails.getSchedule());
        course.setSyllabus(courseDetails.getSyllabus());
        course.setModules(courseDetails.getModules()); // Update modules if needed

        Course updatedCourse = courseRepository.save(course);
        return convertToDTO(updatedCourse);
    }

    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + id));

        courseRepository.delete(course);
    }

    public CourseDTO convertToDTO(Course course) {
        return new CourseDTO(course.getId(), course.getTitle(), course.getDescription(),
                course.getSyllabus(), course.getSchedule(), course.getModules());
    }

    public Course convertToEntity(CourseDTO courseDTO) {
        return new Course(courseDTO.getId(), courseDTO.getTitle(), courseDTO.getDescription(),
                courseDTO.getSyllabus(), courseDTO.getSchedule(), courseDTO.getModules());
    }

}