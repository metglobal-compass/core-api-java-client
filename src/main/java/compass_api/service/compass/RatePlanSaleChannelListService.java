package compass_api.service.compass;

import compass_api.model.RatePlanSaleChannel;
import compass_api.service.HelperEntityService;
import compass_api.service.ServiceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@EnableConfigurationProperties(ServiceProperties.class)
public class RatePlanSaleChannelListService {

    private final ServiceProperties serviceProperties;
    private RestTemplate restTemplate;
    private HelperEntityService helperEntityService;

    public RatePlanSaleChannelListService(ServiceProperties serviceProperties,
                                   RestTemplate restTemplate,
                                   HelperEntityService helperEntityService) {
        this.serviceProperties = serviceProperties;
        this.restTemplate = restTemplate;
        this.helperEntityService = helperEntityService;
    }

    public List<RatePlanSaleChannel> getRatePlansSaleChannelsList(Map<String, String> headerMap, Integer ratePlanId) {
        HttpEntity<String> entity = helperEntityService.httpEntity(headerMap);
        ResponseEntity<List<RatePlanSaleChannel>> responseEntity = restTemplate.exchange(
                serviceProperties.getUrl() + "/rate-plans/" + ratePlanId + "/sale-channels", HttpMethod.GET,
                entity, new ParameterizedTypeReference<List<RatePlanSaleChannel>>() {
                }
        );
        return responseEntity.getBody();
    }
}
