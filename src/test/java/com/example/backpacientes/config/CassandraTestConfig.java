package com.example.backpacientes.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;


@Configuration
@EnableCassandraRepositories(basePackages = {"com.example.backpacientes.repository"})
public class CassandraTestConfig {
    //@Bean
    //public CqlSession session()  throws Exception {
    //    EmbeddedCassandraServerHelper.startEmbeddedCassandra(EmbeddedCassandraServerHelper.CASSANDRA_RNDPORT_YML_FILE);
    //    return EmbeddedCassandraServerHelper.getSession();
    //}
}
