package com.example.backpacientes;

import com.datastax.oss.driver.api.core.CqlSession;
import com.example.backpacientes.config.CassandraConfig;
import com.example.backpacientes.config.CassandraTestConfig;
import com.example.backpacientes.config.RabbitMqTestConfig;
import org.cassandraunit.CQLDataLoader;
import org.cassandraunit.dataset.cql.ClassPathCQLDataSet;
import org.cassandraunit.spring.CassandraUnit;
import org.cassandraunit.spring.CassandraUnitTestExecutionListener;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.context.TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration


//@SpringBootTest(classes = {CassandraTestConfig.class, RabbitMqTestConfig.class})
@TestExecutionListeners(
        listeners = CassandraUnitTestExecutionListener.class,
        mergeMode = MERGE_WITH_DEFAULTS
)
@CassandraUnit
class BackPacientesApplicationTests {
    @Test
    void contextLoads() {
        System.out.println("this is a test");
        System.out.println("This is another test");
        assertEquals(1,1);
    }

}
