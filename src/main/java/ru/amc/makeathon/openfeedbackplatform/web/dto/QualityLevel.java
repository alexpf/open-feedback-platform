package ru.amc.makeathon.openfeedbackplatform.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QualityLevel {

    @NotNull
    private String qualityLevelName;

    private String qualityLevelDescription;

    @NotNull
    @Max(10)
    @Min(1)
    private int qualityLevelGrade;
}
