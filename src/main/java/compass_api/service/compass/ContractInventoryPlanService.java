package compass_api.service.compass;

import compass_api.model.ContractInventoryPlan;
import compass_api.service.HelperEntityService;
import compass_api.service.ServiceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@EnableConfigurationProperties(ServiceProperties.class)
public class ContractInventoryPlanService {

    private final ServiceProperties serviceProperties;
    private RestTemplate restTemplate;
    private HelperEntityService helperEntityService;

    public ContractInventoryPlanService(ServiceProperties serviceProperties,
                                        RestTemplate restTemplate,
                                        HelperEntityService helperEntityService) {
        this.serviceProperties = serviceProperties;
        this.restTemplate = restTemplate;
        this.helperEntityService = helperEntityService;
    }

    public ContractInventoryPlan getContractsInventoryPlans(
            Map<String, String> headerMap,
            Integer contractId
    ){
        HttpEntity<String> entity = helperEntityService.httpEntity(headerMap);

        ResponseEntity<ContractInventoryPlan> contractInventoryPlanResponseEntity =
                restTemplate.exchange(
                        serviceProperties.getUrl() +
                                "/contracts/" + contractId + "/default-inventory-plans",
                        HttpMethod.GET, entity, ContractInventoryPlan.class
                );
        return contractInventoryPlanResponseEntity.getBody();
    }
}
