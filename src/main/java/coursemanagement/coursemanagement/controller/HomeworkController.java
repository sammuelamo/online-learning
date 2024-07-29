package coursemanagement.coursemanagement.controller;

import coursemanagement.coursemanagement.entities.HomeWork;
import coursemanagement.coursemanagement.service.HomeworkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/homework")
public class HomeworkController {
    private final HomeworkService homeworkService;


    public HomeworkController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @GetMapping
    public List<HomeWork> getAllHomework() {
        return homeworkService.getAllHomework();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HomeWork> getHomeworkById(@PathVariable Long id) {
        return homeworkService.getHomeworkById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public HomeWork createHomework(@RequestBody HomeWork homework) {
        return homeworkService.addHomework(homework);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HomeWork> updateHomework(@PathVariable Long id, @RequestBody HomeWork homeworkDetails) {
        return ResponseEntity.ok(homeworkService.updateHomework(id, homeworkDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHomework(@PathVariable Long id) {
        homeworkService.deleteHomework(id);
        return ResponseEntity.noContent().build();
    }
}
