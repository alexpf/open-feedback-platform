package ru.amc.makeathon.openfeedbackplatform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CassandraCqlClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.SimpleUserTypeResolver;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import static java.util.Objects.requireNonNull;

@Configuration
@EnableCassandraRepositories(basePackages = {"ru.amc.makeathon.openfeedbackplatform.database.repository"})
public class CassandraConfig {

    @Value("${ofp.cassandra.host}") String cassandraHost;

    @Value("${ofp.cassandra.keyspace}") String keyspace;

    @Bean
    public CassandraCqlClusterFactoryBean cluster() {
        CassandraCqlClusterFactoryBean cluster = new CassandraCqlClusterFactoryBean();
        cluster.setContactPoints(cassandraHost);
        cluster.setJmxReportingEnabled(false);
        return cluster;
    }

    @Bean
    public CassandraMappingContext mappingContext() {
        CassandraMappingContext mappingContext = new CassandraMappingContext();
        mappingContext.setUserTypeResolver(new SimpleUserTypeResolver(cluster().getObject(), keyspace));
        return mappingContext;
    }

    @Bean
    public CassandraConverter converter() {
        return new MappingCassandraConverter(mappingContext());
    }

    @Bean
    public CassandraSessionFactoryBean session() {
        CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
        session.setCluster(requireNonNull(cluster().getObject()));
        session.setKeyspaceName(keyspace);
        session.setConverter(converter());
        session.setSchemaAction(SchemaAction.NONE);
        return session;
    }
}

