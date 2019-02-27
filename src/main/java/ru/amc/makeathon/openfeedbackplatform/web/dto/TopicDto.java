package ru.amc.makeathon.openfeedbackplatform.web.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TopicDto {

    private String uuid;

    @NotNull
    private String name;

    private String description;

    @NotEmpty
    private Collection<QualityLevel> qualityLevels;

    private String createdBy;
}
