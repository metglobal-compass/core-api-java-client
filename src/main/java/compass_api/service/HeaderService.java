package compass_api.service;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.Map;

public class HeaderService {

    public HttpHeaders httpHeaderService(Map<String, String> headerMap) {

        HttpHeaders headers = new HttpHeaders();

        for (Map.Entry<String, String> mapItem: headerMap.entrySet()){
            headers.set(mapItem.getKey(),mapItem.getValue());
        }
        headers.set("Content-type","application/json");

        return headers;
    }
}
