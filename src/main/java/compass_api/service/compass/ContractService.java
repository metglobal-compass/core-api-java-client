package compass_api.service.compass;

import compass_api.model.Contract;
import compass_api.service.HelperEntityService;
import compass_api.service.ServiceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@EnableConfigurationProperties(ServiceProperties.class)
public class ContractService {

    private final ServiceProperties serviceProperties;
    private RestTemplate restTemplate;
    private HelperEntityService helperEntityService;

    public ContractService(ServiceProperties serviceProperties,
                           RestTemplate restTemplate,
                           HelperEntityService helperEntityService) {
        this.serviceProperties = serviceProperties;
        this.restTemplate = restTemplate;
        this.helperEntityService = helperEntityService;
    }

    public Contract getContracts(Map<String, String> headerMap, Integer contractId, String query) {
        HttpEntity<String> entity = helperEntityService.httpEntity(headerMap);
        ResponseEntity<Contract> contractResponseEntity = restTemplate.exchange(
                serviceProperties.getUrl() + "/contracts/" + contractId + query, HttpMethod.GET, entity, Contract.class);
        return contractResponseEntity.getBody();
    }
}
