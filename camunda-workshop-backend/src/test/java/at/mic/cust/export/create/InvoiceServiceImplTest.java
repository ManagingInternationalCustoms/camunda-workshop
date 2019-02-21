package at.mic.cust.export.create;

import at.mic.cust.export.model.ExportInvoice;
import at.mic.cust.export.model.ExportPosition;
import org.eclipse.persistence.config.TargetServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceUnitTransactionType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.eclipse.persistence.config.PersistenceUnitProperties.*;
import static org.junit.Assert.assertTrue;

public class InvoiceServiceImplTest {

    private static final String PU_NAME = "at.mic.cust.export.PU";
    EntityManager em;

    private long invoiceSid;

    @Before
    public void setUp() throws Exception {
        Map properties = new HashMap();

        // Ensure RESOURCE_LOCAL transactions is used.
        properties.put(TRANSACTION_TYPE,
                PersistenceUnitTransactionType.RESOURCE_LOCAL.name());

        properties.put(JTA_DATASOURCE, "");

        // Configure the internal EclipseLink connection pool

        // Test with Oracle-Local-DB
//        properties.put(JDBC_DRIVER, "oracle.jdbc.OracleDriver");
//        properties.put(JDBC_URL, "jdbc:oracle:thin:@192.168.56.10:1521/devdb_trunk");
//        properties.put(JDBC_USER, "build");
//        properties.put(JDBC_PASSWORD, "BUILD");

        // Test With h2 DB
        properties.put(JDBC_DRIVER, "org.h2.jdbcx.JdbcDataSource");
        properties.put(JDBC_URL, "jdbc:h2:./export-test-db;DB_CLOSE_DELAY=-1;MVCC=TRUE;DB_CLOSE_ON_EXIT=TRUE");
        properties.put(JDBC_USER, "sa");
        properties.put(JDBC_PASSWORD, "sa");
        properties.put("eclipselink.ddl-generation", "create-or-extend-tables");

        // Configure logging. FINE ensures all SQL is shown
        properties.put(LOGGING_LEVEL, "FINE");
        properties.put(LOGGING_TIMESTAMP, "false");
        properties.put(LOGGING_THREAD, "false");
        properties.put(LOGGING_SESSION, "false");

        // Ensure that no server-platform is configured
        properties.put(TARGET_SERVER, TargetServer.None);

        //Now the EntityManagerFactory can be instantiated for testing using:


        em = Persistence.createEntityManagerFactory(PU_NAME, properties).createEntityManager();
        em.getTransaction().begin();
        ExportInvoice invoice = new ExportInvoice();
        invoice.setCompany("01");
        invoice.setPlant("01");
        invoice.setInvoiceNumber("INV1");

        ExportPosition pos = new ExportPosition();
        pos.setInvoiceLineNumber(1L);
        pos.setShipmentLineNumber(1L);
        pos.setInvoice(invoice);
        invoice.getPositions().add(pos);

        em.persist(invoice);
        em.flush();
        invoiceSid = invoice.getSid();
    }

    @After
    public void tearDown() {
        em.getTransaction().rollback();
    }

    @Test
    public void findExistingPositionIds() {
        InvoiceService service = new InvoiceServiceImpl(em);
        List<String> lineIds = service.findPositionIds(String.valueOf(invoiceSid));
        assertTrue(lineIds != null && lineIds.size() == 2);
    }

    @Test
    public void findNewPositionIds() {
        InvoiceService service = new InvoiceServiceImpl(em);
        List<String> lineIds = service.findPositionIds(String.valueOf(-999));
        assertTrue(lineIds != null && lineIds.size() == 1);
    }



}