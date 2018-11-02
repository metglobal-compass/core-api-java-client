package compass_api.service;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HelperEntityService {

    public HttpEntity<String> httpEntity(Map<String, String> headerMap) {

        HeaderService headerService = new HeaderService();

        HttpHeaders headers = headerService.httpHeaderService(headerMap);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        return entity;
    }
}
