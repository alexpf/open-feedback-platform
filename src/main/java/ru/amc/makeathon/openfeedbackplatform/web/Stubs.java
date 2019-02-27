package ru.amc.makeathon.openfeedbackplatform.web;

import ru.amc.makeathon.openfeedbackplatform.web.dto.QualityLevel;
import ru.amc.makeathon.openfeedbackplatform.web.dto.Topic;

import java.util.Collection;
import java.util.UUID;

import static java.util.Arrays.asList;

public final class Stubs {

    public static final Collection<Topic> STUB_TOPICS = asList(
            new Topic(uuid(),
                    name("Скорость обслуживания"),
                    description(""),
                    asList(
                            new QualityLevel(name("Медленно"), description(""), grade(1)),
                            new QualityLevel(name("Средне"), description(""), grade(2)),
                            new QualityLevel(name("Норм"), description(""), grade(3))
                    )),
            new Topic(uuid(),
                    name("Свежесть продуктов"),
                    description(""),
                    asList(
                            new QualityLevel(name("Тухляк"), description(""), grade(1)),
                            new QualityLevel(name("Обычная"), description(""), grade(2)),
                            new QualityLevel(name("Как от бабок"), description(""), grade(3))
                    ))
    );

    private static String uuid() { return UUID.randomUUID().toString(); }
    private static String name(String n) { return n; }
    private static String description(String d) { return d; }
    private static int grade(int g) { return g; }
}
