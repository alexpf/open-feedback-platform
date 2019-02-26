package ru.amc.makeathon.openfeedbackplatform.web;

import org.springframework.web.bind.annotation.*;
import ru.amc.makeathon.openfeedbackplatform.model.HealthcheckStatus;
import ru.amc.makeathon.openfeedbackplatform.model.Topic;

import java.util.Collection;
import java.util.UUID;

import static ru.amc.makeathon.openfeedbackplatform.web.Stubs.*;

@RestController
@RequestMapping("api")
public class MainController {

    @GetMapping("health")
    public Object healthCheck() {
        return new HealthcheckStatus("OK");
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
