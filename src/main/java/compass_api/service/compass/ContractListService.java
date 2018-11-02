package compass_api.service.compass;

import compass_api.model.ContractList;
import compass_api.service.HelperEntityService;
import compass_api.service.ServiceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@EnableConfigurationProperties(ServiceProperties.class)
public class ContractListService {

    private final ServiceProperties serviceProperties;
    private RestTemplate restTemplate;
    private HelperEntityService helperEntityService;

    public ContractListService(ServiceProperties serviceProperties,
                               RestTemplate restTemplate,
                               HelperEntityService helperEntityService) {
        this.serviceProperties = serviceProperties;
        this.restTemplate = restTemplate;
        this.helperEntityService = helperEntityService;
    }

    public ContractList getContractsList(Map<String, String> headerMap){

        HttpEntity<String> entity = helperEntityService.httpEntity(headerMap);

        ResponseEntity<ContractList> contractListResponseEntity = restTemplate.exchange(
                serviceProperties.getUrl() + "/contracts",
                HttpMethod.GET, entity, ContractList.class);

        return contractListResponseEntity.getBody();
    }
}
