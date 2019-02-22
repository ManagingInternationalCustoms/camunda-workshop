package at.mic.bpm.camunda;

import org.camunda.bpm.engine.impl.util.json.JSONObject;
import org.camunda.spin.Spin;
import org.camunda.spin.json.SpinJsonNode;

import javax.inject.Named;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

@Named
public class CamundaMessageRestSender {

    public void sendMessage(String baseUrl, String messageName, String businessKey, Map<String,Object> variableEquals, Map<String,Object> payload) {

        // build request body
        JSONObject requestJson = new JSONObject();
        requestJson.put("messageName", messageName);
        if (businessKey != null) {
            requestJson.put("businessKey", businessKey);
        }
        if (variableEquals != null && ! variableEquals.isEmpty()) {
            JSONObject correlationKeys = new JSONObject();
            variableEquals.forEach((key, value) -> {
                JSONObject valueJson = new JSONObject();
                // this is type agnostic, which is not production ready
                valueJson.put("value", value);
                correlationKeys.put(key, valueJson);
            });
            requestJson.put("correlationKeys", correlationKeys);
        }
        if (payload != null && !payload.isEmpty()) {
            JSONObject processVariables = new JSONObject();
            payload.forEach((key, value) -> {
                JSONObject valueJson = new JSONObject();
                // this is type agnostic, which is not production ready
                valueJson.put("value", value);
                processVariables.put(key, valueJson);
            });
            requestJson.put("processVariables", processVariables);
        }

        URL url = null;
        HttpURLConnection conn;
        try {
            url = new URL(baseUrl + "/message");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty( "Content-type", "application/json");
            conn.setDoOutput(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
            requestJson.write(writer);
            writer.close();

            int responseCode = conn.getResponseCode();
            conn.disconnect();

            if (responseCode / 100 != 2) {
                throw new RuntimeException("Got: " + responseCode);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
