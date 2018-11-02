package compass_api.service.compass;

import compass_api.model.ContractRoom;
import compass_api.service.HelperEntityService;
import compass_api.service.ServiceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@EnableConfigurationProperties(ServiceProperties.class)
public class ContractRoomService {

    private final ServiceProperties serviceProperties;
    private RestTemplate restTemplate;
    private HelperEntityService helperEntityService;

    public ContractRoomService(ServiceProperties serviceProperties,
                               RestTemplate restTemplate,
                               HelperEntityService helperEntityService) {
        this.serviceProperties = serviceProperties;
        this.restTemplate = restTemplate;
        this.helperEntityService = helperEntityService;
    }

    public ContractRoom getContractsRooms(
            Map<String, String> headerMap,
            Integer contractId,
            Integer roomCode
    ) {

        HttpEntity<String> entity = helperEntityService.httpEntity(headerMap);

        ResponseEntity<ContractRoom> contractRoomResponseEntity = restTemplate.exchange(
                serviceProperties.getUrl() +
                        "/contracts/" + contractId + "/rooms/" + roomCode,
                HttpMethod.GET, entity, ContractRoom.class);

        return contractRoomResponseEntity.getBody();
    }
}
