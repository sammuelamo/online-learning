package coursemanagement.coursemanagement.controller;

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
    public List<Module> getAllModule() {
        return moduleService.getAllModules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Module> getModuleById(@PathVariable Long id) {
        Optional<Module> syllabus = moduleService.getModuleById(id);
        return syllabus.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Module createSyllabus(@RequestBody Module module) {
        return moduleService.saveModule(module);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long id) {
        moduleService.deleteModule(id);
        return ResponseEntity.noContent().build();
    }
}