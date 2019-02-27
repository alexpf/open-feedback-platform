package ru.amc.makeathon.openfeedbackplatform.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Feedback {

    private String topicUuid;

    private int qualityLevelGrade;

    private double latitude;

    private double longitude;
}
