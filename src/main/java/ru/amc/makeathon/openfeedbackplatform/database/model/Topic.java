package ru.amc.makeathon.openfeedbackplatform.database.model;

import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Topic {

    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String uuid;

    @PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    private String name;

    private String description;

    @PrimaryKeyColumn(name = "quality_level_name", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String qualityLevelName;

    @Column("quality_level_grade")
    private int qualityLevelGrade;

    @Column("quality_level_description")
    private String qualityLevelDescription;

    @Column("created_by")
    private String createdBy;
}
