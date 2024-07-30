package coursemanagement.coursemanagement.service;

import coursemanagement.coursemanagement.entities.Quiz;
import coursemanagement.coursemanagement.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public List<Quiz> getAllQuiz() {
        return quizRepository.findAll();
    }

    public Optional<Quiz> getQuizById(Long id) {
        return quizRepository.findById(id);
    }

    public Quiz addQuiz(Quiz homework) {
        return quizRepository.save(homework);
    }

    public void deleteQuizById(Long id) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Homework not found with id " + id));

        quizRepository.delete(quiz);
    }
}
