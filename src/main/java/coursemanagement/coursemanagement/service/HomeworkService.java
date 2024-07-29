package coursemanagement.coursemanagement.service;

import coursemanagement.coursemanagement.entities.HomeWork;
import coursemanagement.coursemanagement.repository.HomeWorkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeworkService {

    private final HomeWorkRepository homeWorkRepository;

    public HomeworkService(HomeWorkRepository homeWorkRepository) {
        this.homeWorkRepository = homeWorkRepository;
    }

    public List<HomeWork> getAllHomework() {
        return homeWorkRepository.findAll();
    }

    public Optional<HomeWork> getHomeworkById(Long id) {
        return homeWorkRepository.findById(id);
    }

    public HomeWork addHomework(HomeWork homework) {
        return homeWorkRepository.save(homework);
    }

    public HomeWork updateHomework(Long id, HomeWork homeworkDetails) {
        HomeWork homework = homeWorkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Homework not found with id " + id));

        homework.setQuestions(homeworkDetails.getQuestions());
        homework.setTopic(homeworkDetails.getTopic());

        return homeWorkRepository.save(homework);
    }

    public void deleteHomework(Long id) {
        HomeWork homework = homeWorkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Homework not found with id " + id));

        homeWorkRepository.delete(homework);
    }
}
