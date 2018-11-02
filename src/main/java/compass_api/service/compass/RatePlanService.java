package compass_api.service.compass;

import compass_api.model.RatePlan;
import compass_api.service.HelperEntityService;
import compass_api.service.ServiceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@EnableConfigurationProperties(ServiceProperties.class)
public class RatePlanService {

    private final ServiceProperties serviceProperties;
    private RestTemplate restTemplate;
    private HelperEntityService helperEntityService;

    public RatePlanService(ServiceProperties serviceProperties,
                           RestTemplate restTemplate, HelperEntityService helperEntityService) {
        this.serviceProperties = serviceProperties;
        this.restTemplate = restTemplate;
        this.helperEntityService = helperEntityService;
    }

    public RatePlan getRatePlans(
            Map<String, String> headerMap,
            Integer ratePlanCode,
            String query
    ) {

        HttpEntity<String> entity = helperEntityService.httpEntity(headerMap);

        ResponseEntity<RatePlan> ratePlanResponseEntity = restTemplate.exchange(
                serviceProperties.getUrl() + "/rate-plans/" + ratePlanCode + query,
                HttpMethod.GET, entity, RatePlan.class);

        return ratePlanResponseEntity.getBody();
    }
}
