package compass_api.service.compass;

import compass_api.model.RatePlanCancelPolicy;
import compass_api.model.RatePlanCancelPolicyUpdate;
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
public class RatePlanCancelPolicyService {

    private HeaderService headerService;
    private HelperEntityService helperEntityService;
    private RestTemplate restTemplate;
    private ServiceProperties serviceProperties;

    public RatePlanCancelPolicyService(ServiceProperties serviceProperties, RestTemplate restTemplate,
                                       HelperEntityService helperEntityService, HeaderService headerService) {

        this.helperEntityService = helperEntityService;
        this.restTemplate = restTemplate;
        this.serviceProperties = serviceProperties;
        this.headerService = headerService;
    }

    public List<RatePlanCancelPolicy> getRatePlansCancelPolicies(Map<String, String> headersMap, Integer ratePlanId, String query) {
        HttpEntity<String> entity = helperEntityService.httpEntity(headersMap);
        ResponseEntity<List<RatePlanCancelPolicy>> cancelPoliciesEntity = restTemplate.exchange(
                serviceProperties.getUrl() + "/rate-plans/" + ratePlanId + "/cancel-policies" + query, HttpMethod.GET,
                entity, new ParameterizedTypeReference<List<RatePlanCancelPolicy>>() {
                });

        return cancelPoliciesEntity.getBody();
    }

    public void createRatePlansCancelPolicies(Map<String, String> headersMap, Integer ratePlanId, RatePlanCancelPolicyUpdate params) {
        HttpHeaders headers = headerService.httpHeaderService(headersMap);
        HttpEntity<RatePlanCancelPolicyUpdate> entity = new HttpEntity<>(params, headers);
        restTemplate.exchange(serviceProperties.getUrl() + "/rate-plans/" + ratePlanId + "/cancel-policies",
                HttpMethod.POST, entity, RatePlanCancelPolicyUpdate.class);
    }

    public List<RatePlanCancelPolicy> getRatePlansCancelPoliciesMultiRooms(Map<String, String> headersMap,
                                                                           Integer ratePlanId, String query,
                                                                           List<Integer> contractRoomIds) {

        StringBuilder queryBuilder = new StringBuilder(query);
        contractRoomIds.forEach(roomId -> queryBuilder.append("&contractRoomId[]=").append(roomId));
        query = queryBuilder.toString();

        HttpEntity<String> entity = helperEntityService.httpEntity(headersMap);
        ResponseEntity<List<RatePlanCancelPolicy>> cancelPoliciesEntity = restTemplate.exchange(
                serviceProperties.getUrl() + "/rate-plans/" + ratePlanId + "/cancel-policies" + query, HttpMethod.GET,
                entity, new ParameterizedTypeReference<List<RatePlanCancelPolicy>>() {
                });

        return cancelPoliciesEntity.getBody();
    }
}
