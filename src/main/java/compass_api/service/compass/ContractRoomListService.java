package compass_api.service.compass;

import java.util.List;
import java.util.Map;

import compass_api.model.ContractRoom;
import compass_api.service.HelperEntityService;
import compass_api.service.ServiceProperties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@EnableConfigurationProperties(ServiceProperties.class)
public class ContractRoomListService {

    private final ServiceProperties serviceProperties;
    private RestTemplate restTemplate;
    private HelperEntityService helperEntityService;

    public ContractRoomListService(ServiceProperties serviceProperties,
                                   RestTemplate restTemplate,
                                   HelperEntityService helperEntityService) {

        this.serviceProperties = serviceProperties;
        this.restTemplate = restTemplate;
        this.helperEntityService = helperEntityService;
    }

    public List<ContractRoom> getContractsRoomsList(
            Map<String, String> headerMap,
            Integer contractId,
            String query
    ) {

        HttpEntity<String> entity = helperEntityService.httpEntity(headerMap);

        ResponseEntity<List<ContractRoom>> roomResponseEntity = restTemplate.exchange(
                this.serviceProperties.getUrl() + "/contracts/" + contractId + "/rooms" + query,
                HttpMethod.GET, entity, new ParameterizedTypeReference<List<ContractRoom>>() {
                });

        return roomResponseEntity.getBody();
    }
}
