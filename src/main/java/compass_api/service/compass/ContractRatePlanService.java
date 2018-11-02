package compass_api.service.compass;

import compass_api.service.HelperEntityService;
import compass_api.service.ServiceProperties;
import compass_api.model.ContractRatePlanList;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@EnableConfigurationProperties(ServiceProperties.class)
public class ContractRatePlanService {

    private  ServiceProperties serviceProperties;
    private RestTemplate restTemplate;
    private HelperEntityService helperEntityService;

    public ContractRatePlanService(ServiceProperties serviceProperties,
                                   RestTemplate restTemplate,
                                   HelperEntityService helperEntityService) {

        this.serviceProperties = serviceProperties;
        this.restTemplate = restTemplate;
        this.helperEntityService = helperEntityService;
    }

    public ContractRatePlanList getContractsRatePlans(
            Map<String, String> headerMap,
            Integer contractId,
            String query
    ) {
        HttpEntity<String> entity = helperEntityService.httpEntity(headerMap);

        ResponseEntity<ContractRatePlanList> ratePlanListResponseEntity;

        ratePlanListResponseEntity = restTemplate.exchange(
                serviceProperties.getUrl() + "/contracts/" + contractId + "/rate-plans" + query,
                HttpMethod.GET, entity, new ParameterizedTypeReference<ContractRatePlanList>() {
                });

        return ratePlanListResponseEntity.getBody();
    }
}
