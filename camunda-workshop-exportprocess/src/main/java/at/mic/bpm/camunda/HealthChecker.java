package at.mic.bpm.camunda;

import javax.inject.Named;

@Named
public class HealthChecker {
    boolean emergency;

    public boolean isEmergency() {
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }
}
