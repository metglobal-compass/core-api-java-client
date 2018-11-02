package compass_api.service.compass;

import compass_api.model.RatePlanRoom;
import compass_api.model.RateUpdate;
import compass_api.service.HeaderService;
import compass_api.service.HelperEntityService;
import compass_api.service.ServiceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@EnableConfigurationProperties(ServiceProperties.class)
public class RatePlanRoomListService {

    private final ServiceProperties serviceProperties;
    private RestTemplate restTemplate;
    private HeaderService headerService;
    private HelperEntityService helperEntityService;

    public RatePlanRoomListService(ServiceProperties serviceProperties, RestTemplate restTemplate,
                           HeaderService headerService, HelperEntityService helperEntityService) {
        this.serviceProperties = serviceProperties;
        this.restTemplate = restTemplate;
        this.headerService = headerService;
        this.helperEntityService = helperEntityService;
    }

    public List<RatePlanRoom> getRatePlansRoomsListWithQuery(Map<String, String> headerMap,
            Integer ratePlanId, String query) {
        HttpEntity<String> entity = helperEntityService.httpEntity(headerMap);
        ResponseEntity<List<RatePlanRoom>> responseEntity = restTemplate.exchange(
                serviceProperties.getUrl() + "/rate-plans/" + ratePlanId + "/rooms" + query, HttpMethod.GET,
                entity, new ParameterizedTypeReference<List<RatePlanRoom>>() {
                });
        return responseEntity.getBody();
    }

    public void createRatePlansRoomsList(Map<String, String> headerMap, Integer ratePlanId, RateUpdate params) {
        HttpHeaders httpHeaders = headerService.httpHeaderService(headerMap);
        HttpEntity<RateUpdate> entity = new HttpEntity<>(params, httpHeaders);
        restTemplate.exchange(serviceProperties.getUrl() + "/rate-plans/" + ratePlanId + "/rooms",
                HttpMethod.POST, entity, RateUpdate.class);
    }

    public void deleteRatePlansRooms(Map<String, String> headersMap, Integer ratePlanId, RateUpdate params) {
        HttpHeaders httpHeaders = headerService.httpHeaderService(headersMap);
        HttpEntity<RateUpdate> entity = new HttpEntity<>(params, httpHeaders);
        restTemplate.exchange(
                serviceProperties.getUrl() + "/rate-plans/" + ratePlanId + "/rooms",
                HttpMethod.DELETE, entity, RateUpdate.class);
    }
}
