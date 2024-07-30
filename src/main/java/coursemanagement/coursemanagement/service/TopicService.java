package coursemanagement.coursemanagement.service;

import coursemanagement.coursemanagement.entities.Module;
import coursemanagement.coursemanagement.entities.Topics;
import coursemanagement.coursemanagement.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    private final TopicRepository topicRepository;
    private final ModuleService moduleService;

    public TopicService(TopicRepository topicRepository, ModuleService moduleService) {
        this.topicRepository = topicRepository;
        this.moduleService = moduleService;
    }

    public Topics createTopic(Topics topic) {
        Long moduleId = topic.getModule().getId();
        if (moduleId == null) {
            throw new IllegalArgumentException("Syllabus ID cannot be null");
        }

        Module module = moduleService.getModuleById(moduleId)
                .orElseThrow(() -> new IllegalArgumentException("Syllabus not found with ID: " + moduleId));

        topic.setModule(module);
        return topicRepository.save(topic);
    }

    public List<Topics> getAllTopics() {
        return topicRepository.findAll();
    }
    public Topics getTopicById(int id) {
        return topicRepository.findById(id).orElse(null);
    }
    public void deleteTopicById(int id) {
        topicRepository.deleteById(id);
    }
}
