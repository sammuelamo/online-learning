package coursemanagement.coursemanagement.controller;

import coursemanagement.coursemanagement.entities.Quiz;
import coursemanagement.coursemanagement.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    private final QuizService quizService;


    public QuizController(QuizService homeworkService) {
        this.quizService = homeworkService;
    }

    @GetMapping
    public List<Quiz> getAllQuiz() {
        return quizService.getAllQuiz();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getHomeQuizById(@PathVariable Long id) {
        return quizService.getQuizById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz homework) {
        return quizService.addQuiz(homework);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuizById(id);
        return ResponseEntity.noContent().build();
    }
}
