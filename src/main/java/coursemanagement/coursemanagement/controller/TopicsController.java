package coursemanagement.coursemanagement.controller;

import coursemanagement.coursemanagement.entities.Topics;
import coursemanagement.coursemanagement.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topic")
public class TopicsController {

  private final TopicService topicService;

  public TopicsController(TopicService topicService) {
      this.topicService = topicService;
  }

    @PostMapping
    public ResponseEntity<Topics> createTopic(@RequestBody Topics topic) {
        Topics createdTopic = topicService.createTopic(topic);
        return ResponseEntity.ok(createdTopic);
    }

    @GetMapping
    public ResponseEntity<List<Topics>> getAllTopics() {
        List<Topics> topics = topicService.getAllTopics();
        return ResponseEntity.ok(topics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topics> getTopicById(@PathVariable int id) {
        Topics topic = topicService.getTopicById(id);
        if (topic != null) {
            return ResponseEntity.ok(topic);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopicById(@PathVariable int id) {
        topicService.deleteTopicById(id);
        return ResponseEntity.noContent().build();
    }
}
