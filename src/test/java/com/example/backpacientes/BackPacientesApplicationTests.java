package com.example.backpacientes;

import com.datastax.oss.driver.api.core.CqlSession;
import org.cassandraunit.CQLDataLoader;
import org.cassandraunit.dataset.cql.ClassPathCQLDataSet;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;
@SpringBootTest
class BackPacientesApplicationTests {
    private CqlSession session;
    private static final String QUEUE_NAME = UUID.randomUUID().toString();
    private static final String EXCHANGE_NAME = UUID.randomUUID().toString();
    @Before
    public void setUp() throws Exception {
        EmbeddedCassandraServerHelper.startEmbeddedCassandra();
        session = EmbeddedCassandraServerHelper.getSession();
        new CQLDataLoader(session).load(new ClassPathCQLDataSet("pacientes.cql", "pacientes"));
    }
    @Test
    void contextLoads() {
        System.out.println("GA");
    }

}
