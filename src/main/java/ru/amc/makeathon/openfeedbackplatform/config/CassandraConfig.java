package ru.amc.makeathon.openfeedbackplatform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CassandraCqlClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraCqlSessionFactoryBean;

import static java.util.Objects.requireNonNull;

@Configuration
public class CassandraConfig {

    @Value("${ofp.cassandra.host}") String cassandraHost;

    @Value("${ofp.cassandra.keyspace}") String keyspace;

    /*
     * Factory bean that creates the com.datastax.driver.core.Session instance
     */
    @Bean
    public CassandraCqlClusterFactoryBean cluster() {

        CassandraCqlClusterFactoryBean cluster = new CassandraCqlClusterFactoryBean();
        cluster.setContactPoints(cassandraHost);
        cluster.setJmxReportingEnabled(false);
        return cluster;
    }

    /*
     * Factory bean that creates the com.datastax.driver.core.Session instance
     */
    @Bean
    public CassandraCqlSessionFactoryBean session() {

        CassandraCqlSessionFactoryBean session = new CassandraCqlSessionFactoryBean();
        session.setCluster(requireNonNull(cluster().getObject()));
        session.setKeyspaceName(keyspace);

        return session;
    }
}

