package coursemanagement.coursemanagement.controller;

import coursemanagement.coursemanagement.dto.QuizDTO;
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
    public List<QuizDTO> getAllQuiz() {
        return quizService.getAllQuiz();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizDTO> getQuizById(@PathVariable Long id) {
        return ResponseEntity.ok(quizService.getQuizById(id));
    }

    @PostMapping
    public ResponseEntity<QuizDTO> createQuiz(@RequestBody QuizDTO quizDTO) {
        QuizDTO createdQuiz = quizService.addQuiz(quizDTO);
        return ResponseEntity.ok(createdQuiz);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuizById(id);
        return ResponseEntity.noContent().build();
    }
}
