package compass_api.service.compass;

import java.util.Map;

import compass_api.model.RatePlanRoomDelete;
import compass_api.service.HeaderService;
import compass_api.service.HelperEntityService;
import compass_api.service.ServiceProperties;
import compass_api.model.RatePlanRoomUpdate;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@EnableConfigurationProperties(ServiceProperties.class)
public class RatePlanRoomService {

    private final ServiceProperties serviceProperties;
    private RestTemplate restTemplate;
    private HeaderService headerService;
    private HelperEntityService helperEntityService;

    public RatePlanRoomService(ServiceProperties serviceProperties,
                               RestTemplate restTemplate,
                               HeaderService headerService,
                               HelperEntityService helperEntityService) {
        this.serviceProperties = serviceProperties;
        this.restTemplate = restTemplate;
        this.headerService = headerService;
        this.helperEntityService = helperEntityService;
    }

    public void createRatePlansRooms(
            Map<String, String> headerMap,
            Integer ratePlanId,
            Integer roomId,
            RatePlanRoomUpdate ratePlanRoomUpdate
    ){
        HttpHeaders headers = headerService.httpHeaderService(headerMap);

        HttpEntity<RatePlanRoomUpdate> ratePlanRoomUpdateHttpEntity =
                new HttpEntity<>(ratePlanRoomUpdate, headers);

        restTemplate.exchange(serviceProperties.getUrl() + "/rate-plans/" +
                        ratePlanId
                        + "/rooms/" + roomId,
                HttpMethod.POST,
                ratePlanRoomUpdateHttpEntity,
                RatePlanRoomUpdate.class
        );
    }

    public void deleteRatePlansRooms(
        Map<String, String> headerMap, Integer ratePlanId, Integer roomId, RatePlanRoomDelete ratePlanRoomDelete
    ) {
        restTemplate.exchange(
            serviceProperties.getUrl() + "/rate-plans/" + ratePlanId + "/rooms/" + roomId,
            HttpMethod.DELETE,
            new HttpEntity<>(ratePlanRoomDelete, headerService.httpHeaderService(headerMap)),
            RatePlanRoomDelete.class
        );
    }
}
