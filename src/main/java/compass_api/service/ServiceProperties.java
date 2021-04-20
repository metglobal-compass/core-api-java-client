package compass_api.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "compass")
public class ServiceProperties {

    private String url;
    private boolean requestLogging;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isRequestLogging() {
        return requestLogging;
    }

    public void setRequestLogging(boolean requestLogging) {
        this.requestLogging = requestLogging;
    }
}
