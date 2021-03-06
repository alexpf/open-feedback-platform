package ru.amc.makeathon.openfeedbackplatform.web;

import ru.amc.makeathon.openfeedbackplatform.web.dto.QualityLevel;
import ru.amc.makeathon.openfeedbackplatform.web.dto.TopicDto;

import java.util.Collection;
import java.util.UUID;

import static java.util.Arrays.asList;

public final class Stubs {

    public static final Collection<TopicDto> STUB_TOPICS = asList(
            new TopicDto(uuid(),
                    name("Уличное освещение"),
                    description(""),
                    asList(
                            new QualityLevel(name("Очень темно"), description(""), grade(1)),
                            new QualityLevel(name("Освещается, но слабо"), description(""), grade(2)),
                            new QualityLevel(name("На улице светло"), description(""), grade(3))
                    ),
                    createdBy(null)),
            new TopicDto(uuid(),
                    name("Уборка снега"),
                    description(""),
                    asList(
                            new QualityLevel(name("Ни проехать, ни пройти"), description(""), grade(1)),
                            new QualityLevel(name("Убирают минимально"), description(""), grade(2)),
                            new QualityLevel(name("Все чисто"), description(""), grade(3))
                    ),
                    createdBy(null))
    );

    private static String uuid() { return UUID.randomUUID().toString(); }
    private static String name(String n) { return n; }
    private static String description(String d) { return d; }
    private static int grade(int g) { return g; }
    private static String createdBy(String c) { return c; }
}
