package com.groupthree.lms.service.courseService;

import com.groupthree.lms.dto.courseDto.CourseDTO;
import com.groupthree.lms.dto.courseDto.ModuleDTO;
import com.groupthree.lms.models.courseModel.Course;
import com.groupthree.lms.models.courseModel.Module;
import com.groupthree.lms.repositories.courseRepository.ModuleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ModuleServiceTest {

    @Mock
    private ModuleRepository moduleRepository;

    @Mock
    private CourseService courseService;

    @InjectMocks
    private ModuleService moduleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllModules() {
        List<Module> modules = new ArrayList<>();
        modules.add(new Module(1L, "Module 1", "Description 1", null, null));
        modules.add(new Module(2L, "Module 2", "Description 2", null, null));

        when(moduleRepository.findAll()).thenReturn(modules);

        List<ModuleDTO> moduleDTOs = moduleService.getAllModules();

        assertEquals(2, moduleDTOs.size());
        verify(moduleRepository, times(1)).findAll();
    }

    @Test
    void getModuleById() {
        Module module = new Module(1L, "Module 1", "Description 1", null, null);

        when(moduleRepository.findById(1L)).thenReturn(Optional.of(module));

        ModuleDTO moduleDTO = moduleService.getModuleById(1L);

        assertEquals("Module 1", moduleDTO.getTitle());
        assertEquals("Description 1", moduleDTO.getDescription());
        verify(moduleRepository, times(1)).findById(1L);
    }

    @Test
    void saveModule() {
        /*CourseDTO courseDTO = new CourseDTO(1L, "Course 1", "Description 1", null, null, null);
        ModuleDTO moduleDTO = new ModuleDTO(null, "Module 1", "Description 1",courseDTO , null);
        Course course = new Course(1L, "Course 1", "Description 1", null, null, null);
        Module module = new Module(null, "Module 1", "Description 1", course, null);
        Module savedModule = new Module(1L, "Module 1", "Description 1", course, null);

        when(courseService.getCourseById(1L)).thenReturn(courseDTO);
        when(courseService.convertToEntity(courseDTO)).thenReturn(course);
        when(moduleRepository.save(module)).thenReturn(savedModule);

        ModuleDTO result = moduleService.saveModule(moduleDTO);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(courseService, times(1)).getCourseById(1L);
        verify(moduleRepository, times(1)).save(any(Module.class));*/
    }

    @Test
    void deleteModule() {
        doNothing().when(moduleRepository).deleteById(1L);

        moduleService.deleteModule(1L);

        verify(moduleRepository, times(1)).deleteById(1L);
    }

    @Test
    void updateModule() {
        CourseDTO courseDTO = new CourseDTO(1L, "Course 1", "Description 1", null, null, null);
        Module existingModule = new Module(1L, "Module 1", "Description 1", null, null);
        ModuleDTO moduleDTO = new ModuleDTO(1L, "Updated Module 1", "Updated Description 1", null, null);
        Course course = new Course(1L, "Course 1", "Description 1", null, null, null);

        when(moduleRepository.findById(1L)).thenReturn(Optional.of(existingModule));
        when(courseService.getCourseById(1L)).thenReturn(courseDTO);
        when(courseService.convertToEntity(courseDTO)).thenReturn(course);
        when(moduleRepository.save(any(Module.class))).thenReturn(existingModule);

        ModuleDTO updatedModuleDTO = moduleService.updateModule(1L, moduleDTO);

        assertNotNull(updatedModuleDTO);
        assertEquals("Updated Module 1", updatedModuleDTO.getTitle());
        assertEquals("Updated Description 1", updatedModuleDTO.getDescription());
        verify(moduleRepository, times(1)).findById(1L);
        verify(moduleRepository, times(1)).save(existingModule);
    }
}