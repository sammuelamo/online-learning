package coursemanagement.coursemanagement.service;

import coursemanagement.coursemanagement.entities.Topics;
import coursemanagement.coursemanagement.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Topics createTopic(Topics topic) {
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
