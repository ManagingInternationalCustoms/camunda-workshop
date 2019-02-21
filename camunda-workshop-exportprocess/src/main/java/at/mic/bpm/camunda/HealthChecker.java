package at.mic.bpm.camunda;

import javax.inject.Named;

@Named
public class HealthChecker {

    public boolean isEmergency() {
        return Math.random() > 0.5;
    }

}
