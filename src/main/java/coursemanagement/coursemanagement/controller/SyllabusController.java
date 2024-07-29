package coursemanagement.coursemanagement.controller;

import coursemanagement.coursemanagement.entities.Syllabus;
import coursemanagement.coursemanagement.service.SyllabusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/syllabi")
public class SyllabusController {

    private final SyllabusService syllabusService;


    public SyllabusController(SyllabusService syllabusService) {
        this.syllabusService = syllabusService;
    }

    @GetMapping
    public List<Syllabus> getAllSyllabus() {
        return syllabusService.getAllSyllabus();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Syllabus> getSyllabusById(@PathVariable Long id) {
        Optional<Syllabus> syllabus = syllabusService.getSyllabusById(id);
        return syllabus.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Syllabus createSyllabus(@RequestBody Syllabus syllabus) {
        Syllabus syllabus1 = syllabusService.saveSyllabus(syllabus);
        return syllabus1;
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Syllabus> updateSyllabus(@PathVariable Long id, @RequestBody Syllabus updatedSyllabus) {
//        try {
//            Syllabus syllabus = syllabusService.updateSyllabus(id, updatedSyllabus);
//            return ResponseEntity.ok(syllabus);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSyllabus(@PathVariable Long id) {
        syllabusService.deleteSyllabus(id);
        return ResponseEntity.noContent().build();
    }
}