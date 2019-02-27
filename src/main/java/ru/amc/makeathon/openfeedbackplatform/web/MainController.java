package ru.amc.makeathon.openfeedbackplatform.web;

import org.springframework.web.bind.annotation.*;
import ru.amc.makeathon.openfeedbackplatform.web.dto.Feedback;
import ru.amc.makeathon.openfeedbackplatform.web.dto.HealthcheckStatus;
import ru.amc.makeathon.openfeedbackplatform.web.dto.Topic;

import javax.validation.Valid;
import java.util.Collection;
import java.util.UUID;

import static ru.amc.makeathon.openfeedbackplatform.web.Stubs.*;

@RestController
@RequestMapping("api")
public class MainController {

    @GetMapping("health")
    public HealthcheckStatus healthCheck() {
        return new HealthcheckStatus("OK");
    }

    @PostMapping("topic")
    public Topic addNewTopic(@RequestBody @Valid Topic newTopic) {
        newTopic.setUuid(UUID.randomUUID().toString());
        return newTopic;
    }

    @PostMapping("feedback")
    public void addNewFeedback(@RequestBody @Valid Feedback feedback) {
    }

    @GetMapping("topic")
    public Collection<Topic> getAllTopics() {
        return STUB_TOPICS;
    }
}
