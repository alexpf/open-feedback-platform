CREATE KEYSPACE feedback WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

USE feedback;

CREATE TABLE topic (
  uuid text,
  name text,
  description text,
  quality_level_name text,
  quality_level_description text,
  quality_level_grade int,
  created_by text,
  PRIMARY KEY ((uuid, quality_level_name), name)
);

CREATE TABLE feedback (
  uuid text,
  topic_uuid text,
  quality_level_grade int,
  entity_name text,
  comment text,
  latitude double,
  longitude double,
  PRIMARY KEY ((uuid), topic_uuid)
);