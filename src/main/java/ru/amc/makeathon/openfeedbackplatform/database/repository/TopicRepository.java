package ru.amc.makeathon.openfeedbackplatform.database.repository;

import org.springframework.data.cassandra.core.mapping.MapId;
import org.springframework.data.cassandra.repository.CassandraRepository;
import ru.amc.makeathon.openfeedbackplatform.database.model.Topic;

public interface TopicRepository extends CassandraRepository<Topic, MapId> {
}
