package at.mic.cust.export.create;

import org.eclipse.persistence.config.TargetServer;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceUnitTransactionType;
import java.util.HashMap;
import java.util.Map;

import static org.eclipse.persistence.config.PersistenceUnitProperties.*;

public class InvoiceServiceImplTest {

    private static final String PU_NAME = "at.mic.cust.export.PU";
    EntityManager em;

    @Before
    public void setUp() throws Exception {
        Map properties = new HashMap();

        // Ensure RESOURCE_LOCAL transactions is used.
        properties.put(TRANSACTION_TYPE,
                PersistenceUnitTransactionType.RESOURCE_LOCAL.name());

        // Configure the internal EclipseLink connection pool
        properties.put(JDBC_DRIVER, "oracle.jdbc.OracleDriver");
        properties.put(JDBC_URL, "jdbc:oracle:thin:@localhost:1521:ORCL");
        properties.put(JDBC_USER, "scott");
        properties.put(JDBC_PASSWORD, "tiger");

        // Configure logging. FINE ensures all SQL is shown
        properties.put(LOGGING_LEVEL, "FINE");
        properties.put(LOGGING_TIMESTAMP, "false");
        properties.put(LOGGING_THREAD, "false");
        properties.put(LOGGING_SESSION, "false");

        // Ensure that no server-platform is configured
        properties.put(TARGET_SERVER, TargetServer.None);

        //Now the EntityManagerFactory can be instantiated for testing using:

        Persistence.createEntityManagerFactory(PU_NAME, properties);
    }

    @Test
    public void findPositionIds() {
    }
}