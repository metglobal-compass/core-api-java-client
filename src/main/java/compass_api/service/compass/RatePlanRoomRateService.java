package compass_api.service.compass;

import compass_api.service.HelperEntityService;
import compass_api.service.ServiceProperties;
import compass_api.model.RatePlanRoomRate;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EnableConfigurationProperties(ServiceProperties.class)
public class RatePlanRoomRateService {

    private final ServiceProperties serviceProperties;
    private RestTemplate restTemplate;
    private HelperEntityService helperEntityService;

    public RatePlanRoomRateService(ServiceProperties serviceProperties,
                                   RestTemplate restTemplate,
                                   HelperEntityService helperEntityService) {
        this.serviceProperties = serviceProperties;
        this.restTemplate = restTemplate;
        this.helperEntityService = helperEntityService;
    }


    public List<RatePlanRoomRate> getRatePlansRoomRatesList(
            Map<String, String> headerMap,
            Integer ratePlanId,
            String query
    ){

        HttpEntity<String> entity = helperEntityService.httpEntity(headerMap);

        ResponseEntity<List<RatePlanRoomRate>> ratePlanRoomRateResponseEntity =
                restTemplate.exchange(
                        serviceProperties.getUrl() + "/rate-plans/" +
                                ratePlanId + "/rooms/rates" + query,
                        HttpMethod.GET, entity, new ParameterizedTypeReference<List<RatePlanRoomRate>>() {
                        });

        return ratePlanRoomRateResponseEntity.getBody();
    }
}
