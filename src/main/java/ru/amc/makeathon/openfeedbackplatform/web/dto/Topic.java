package ru.amc.makeathon.openfeedbackplatform.web.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;

// TODO: created by?

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topic {

    private String uuid;

    @NotNull
    private String name;

    private String description;

    @NotEmpty
    private Collection<QualityLevel> qualityLevels;
}
