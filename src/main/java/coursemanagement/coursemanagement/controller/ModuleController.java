package coursemanagement.coursemanagement.controller;

import coursemanagement.coursemanagement.dto.ModuleDTO;
import coursemanagement.coursemanagement.entities.Module;
import coursemanagement.coursemanagement.service.ModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/module")
public class ModuleController {

    private final ModuleService moduleService;


    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping
    public List<ModuleDTO> getAllModules() {
        return moduleService.getAllModules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuleDTO> getModuleById(@PathVariable Long id) {
        ModuleDTO moduleDTO = moduleService.getModuleById(id);
        return ResponseEntity.ok(moduleDTO);
    }

    @PostMapping
    public ModuleDTO createModule(@RequestBody ModuleDTO moduleDTO) {
        return moduleService.saveModule(moduleDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long id) {
        moduleService.deleteModule(id);
        return ResponseEntity.noContent().build();
    }
}