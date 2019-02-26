package ru.amc.makeathon.openfeedbackplatform.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.amc.makeathon.openfeedbackplatform.model.Topic;

import java.util.Collection;
import java.util.UUID;

import static ru.amc.makeathon.openfeedbackplatform.web.Stubs.*;

@RestController("api")
public class MainController {

    @GetMapping("health")
    public void getHealthcheckStatus() {
    }

    @PostMapping("topic")
    public Topic addNewTopic(@RequestBody Topic newTopic) {
        newTopic.setUuid(UUID.randomUUID().toString());
        return newTopic;
    }

    @GetMapping("topic")
    public Collection<Topic> getAllTopics() {
        return STUB_TOPICS;
    }
}
