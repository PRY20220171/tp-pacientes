package com.example.backpacientes.config;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.ProtocolVersion;
import com.datastax.oss.driver.api.core.config.DefaultDriverOption;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;
import com.datastax.oss.driver.internal.core.ssl.DefaultSslEngineFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.convert.DurationStyle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.CassandraContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


@Configuration
@Profile("test")
@EnableCassandraRepositories(basePackages = {"com.example.backpacientes.repository"})
@Testcontainers
public class CassandraTestConfig {
    @Container
    public static final CassandraContainer cassandra
            = (CassandraContainer) new CassandraContainer("cassandra:3.11").withExposedPorts(9042);
    @Autowired
    private Environment env;
    @Bean
    @ConditionalOnProperty(value="${spring.data.cassandra.ssl}", havingValue="true")
    public CqlSession session() {
        System.setProperty("spring.data.cassandra.contact-points", cassandra.getContainerIpAddress());
        System.setProperty("spring.data.cassandra.port", String.valueOf(cassandra.getMappedPort(9042)));
        //variables obligatorias:
        Duration reqtimeout = DurationStyle.detectAndParse(Objects.requireNonNull(env.getProperty("spring.data.cassandra.request.timeout")));
        Duration conntimeout = DurationStyle.detectAndParse(Objects.requireNonNull(env.getProperty("spring.data.cassandra.connection.connect-timeout")));
        Duration initqrytimeout = DurationStyle.detectAndParse(Objects.requireNonNull(env.getProperty("spring.data.cassandra.connection.init-query-timeout")));
        String username = Objects.requireNonNull(env.getProperty("spring.data.cassandra.username"));
        String passPhrase = Objects.requireNonNull(env.getProperty("spring.data.cassandra.password"));
        String keyspace = Objects.requireNonNull(env.getProperty("spring.data.cassandra.keyspace-name"));
        String datacenter = Objects.requireNonNull(env.getProperty("spring.data.cassandra.local-datacenter"));
        List<String> contactPoints = Collections.singletonList(Objects.requireNonNull(env.getProperty("spring.data.cassandra.contact-points")));
        System.out.println(contactPoints);
        DriverConfigLoader loader;
        loader = DriverConfigLoader.programmaticBuilder()
                .withStringList(DefaultDriverOption.CONTACT_POINTS, contactPoints)
                .withDuration(DefaultDriverOption.REQUEST_TIMEOUT, reqtimeout)
                .withDuration(DefaultDriverOption.CONNECTION_CONNECT_TIMEOUT, conntimeout)
                .withDuration(DefaultDriverOption.CONNECTION_INIT_QUERY_TIMEOUT, initqrytimeout)
                .withClass(DefaultDriverOption.PROTOCOL_VERSION, ProtocolVersion.V4.getClass())
                .build();
        return CqlSession.builder()
                .withAuthCredentials(username,passPhrase)
                .withLocalDatacenter(datacenter)
                .withConfigLoader(loader)
                .withKeyspace(keyspace)
                .build();
    }
}
