package ru.amc.makeathon.openfeedbackplatform.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topic {

    private String uuid;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private Collection<QualityLevel> qualityLevels;
}
