package ru.amc.makeathon.openfeedbackplatform.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class FeedbackDto {

    @NotNull
    private String topicUuid;

    @Min(1)
    @Max(10)
    private int qualityLevelGrade;

    private String entityName;

    private String comment;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;
}
