package ru.amc.makeathon.openfeedbackplatform.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.amc.makeathon.openfeedbackplatform.database.model.Topic;
import ru.amc.makeathon.openfeedbackplatform.database.repository.TopicRepository;
import ru.amc.makeathon.openfeedbackplatform.web.dto.FeedbackDto;
import ru.amc.makeathon.openfeedbackplatform.web.dto.HealthcheckStatus;
import ru.amc.makeathon.openfeedbackplatform.web.dto.TopicDto;

import javax.validation.Valid;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

import static ru.amc.makeathon.openfeedbackplatform.web.Stubs.*;

@RestController
@RequestMapping("api")
public class MainController {

    private final TopicRepository topicRepository;

    @Autowired
    public MainController(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @GetMapping("health")
    public HealthcheckStatus healthCheck() {
        return new HealthcheckStatus("OK");
    }

    @PostMapping("topic")
    public TopicDto addNewTopic(@RequestBody @Valid TopicDto newTopic) {
        newTopic.setUuid(UUID.randomUUID().toString());

        Collection<Topic> topicRecords = newTopic.getQualityLevels().stream()
                .map(level -> Topic.builder()
                                .uuid(newTopic.getUuid())
                                .name(newTopic.getName())
                                .description(newTopic.getDescription())
                                .qualityLevelName(level.getQualityLevelName())
                                .qualityLevelDescription(level.getQualityLevelDescription())
                                .qualityLevelGrade(level.getQualityLevelGrade())
                                .build())
                .collect(Collectors.toList());
        topicRepository.saveAll(topicRecords);

        return newTopic;
    }

    @PostMapping("feedback")
    public void addNewFeedback(@RequestBody @Valid FeedbackDto newFeedback) {
    }

    @GetMapping("topic")
    public Collection<TopicDto> getAllTopics() {
        return STUB_TOPICS;
    }
}
