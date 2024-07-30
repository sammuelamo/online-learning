package com.groupthree.lms.service.courseService;

import com.groupthree.lms.dto.courseDto.CourseDTO;
import com.groupthree.lms.models.courseModel.Course;
import com.groupthree.lms.repositories.courseRepository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseService courseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllCourses() {
        Course course = new Course(1L, "Test Title", "Test Description", "Test Syllabus", "Test Schedule", Collections.emptyList());
        when(courseRepository.findAll()).thenReturn(List.of(course));

        List<CourseDTO> courses = courseService.getAllCourses();
        assertFalse(courses.isEmpty());
        assertEquals(1, courses.size());
        assertEquals("Test Title", courses.get(0).getTitle());
    }

    @Test
    void getCourseById() {
        Course course = new Course(1L, "Test Title", "Test Description", "Test Syllabus", "Test Schedule", Collections.emptyList());
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));

        CourseDTO courseDTO = courseService.getCourseById(1L);
        assertNotNull(courseDTO);
        assertEquals("Test Title", courseDTO.getTitle());
    }

    @Test
    void addCourse() {
        CourseDTO courseDTO = new CourseDTO(null, "Test Title", "Test Description", "Test Syllabus", "Test Schedule", Collections.emptyList());
        Course course = new Course(1L, "Test Title", "Test Description", "Test Syllabus", "Test Schedule", Collections.emptyList());

        when(courseRepository.save(any(Course.class))).thenReturn(course);

        CourseDTO savedCourse = courseService.addCourse(courseDTO);
        assertNotNull(savedCourse);
        assertEquals("Test Title", savedCourse.getTitle());
    }

    @Test
    void updateCourse() {
        Course existingCourse = new Course(1L, "Old Title", "Old Description", "Old Syllabus", "Old Schedule", Collections.emptyList());
        Course updatedCourse = new Course(1L, "New Title", "New Description", "New Syllabus", "New Schedule", Collections.emptyList());
        CourseDTO courseDTO = new CourseDTO(1L, "New Title", "New Description", "New Syllabus", "New Schedule", Collections.emptyList());

        when(courseRepository.findById(1L)).thenReturn(Optional.of(existingCourse));
        when(courseRepository.save(any(Course.class))).thenReturn(updatedCourse);

        CourseDTO result = courseService.updateCourse(1L, courseDTO);
        assertNotNull(result);
        assertEquals("New Title", result.getTitle());
    }

    @Test
    void deleteCourse() {
        Course course = new Course(1L, "Test Title", "Test Description", "Test Syllabus", "Test Schedule", Collections.emptyList());
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));

        courseService.deleteCourse(1L);

        verify(courseRepository, times(1)).delete(course);
    }
}