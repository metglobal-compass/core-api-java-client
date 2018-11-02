package compass_api.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LoggingRequestInterceptor implements ClientHttpRequestInterceptor{

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {

        ClientHttpResponse response = execution.execute(request, body);

        this.addLog(request, body, response);

        return response;
    }

    private void addLog(HttpRequest request, byte[] body, ClientHttpResponse response) {
        String requestContent = new String(body).replace("\n", "");
        String logPayload = "Uri: " + request.getURI() + " Request: " + requestContent;

        // Bind all headers to log payload
        HttpHeaders headers = request.getHeaders();

        logPayload += " Headers: (" + headers.entrySet().size() + ")";
        for (Map.Entry<String, List<String>> header: headers.entrySet()) {
            logPayload += " " + header.getKey() + ":" +header.getValue().toString();
        }

        String responseContent = "";
        String responseStatus = "";
        Scanner s;
        try {
            s = new Scanner(response.getBody()).useDelimiter("\\A");
            responseContent = s.hasNext() ? s.next() : "";
            responseContent = responseContent.replace("\n", "");

            responseStatus = response.getStatusText();

        } catch (IOException ex) {
            // Skip trying to add response body or status
        }

        logPayload += " ResponseContent: " + responseContent;
        logPayload += " ResponseStatus: " + responseStatus;

        System.out.println(logPayload);
    }
}
