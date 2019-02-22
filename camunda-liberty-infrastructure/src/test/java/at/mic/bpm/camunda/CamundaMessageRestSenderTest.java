package at.mic.bpm.camunda;

import org.junit.Test;

import static org.junit.Assert.*;

public class CamundaMessageRestSenderTest {

    //@Test
    public void sendMessage() {
        new CamundaMessageRestSender().sendMessage("http://localhost:9080/engine-rest/", "MyMessage", null, null, null);
    }

    @Test
    public void testCodeChecking() {
        assertFalse(204 / 100 != 2);
    }
}