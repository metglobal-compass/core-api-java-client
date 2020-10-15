package compass_api.service.compass;

import compass_api.service.HeaderService;
import compass_api.service.HelperEntityService;
import compass_api.service.ServiceProperties;
import compass_api.model.AllotmentPlanRoom;
import compass_api.model.AllotmentPlanRoomUpdate;
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
public class AllotmentPlanRoomService {

    private final ServiceProperties serviceProperties;
    private RestTemplate restTemplate;
    private HeaderService headerService;
    private HelperEntityService helperEntityService;

    public AllotmentPlanRoomService(ServiceProperties serviceProperties,
                                    RestTemplate restTemplate,
                                    HeaderService headerService,
                                    HelperEntityService helperEntityService) {
        this.serviceProperties = serviceProperties;
        this.restTemplate = restTemplate;
        this.headerService = headerService;
        this.helperEntityService = helperEntityService;
    }

    public List<AllotmentPlanRoom> getAllotmentPlansRoomsList(
            Map<String, String> headerMap,
            Integer allotmentPlanId,
            String query
            ){

        HttpEntity<String> entity = helperEntityService.httpEntity(headerMap);

        ResponseEntity<List<AllotmentPlanRoom>> allotmentPlanResponseEntity = restTemplate.exchange(
                serviceProperties.getUrl() + "/allotment-plans/" + allotmentPlanId +
                        "/rooms" + query,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<AllotmentPlanRoom>>() {
                });

        return allotmentPlanResponseEntity.getBody();
    }

    public void changeAllotmentPlansRooms(
        Map<String, String> headerMap,
        Integer allotmentPlanId,
        AllotmentPlanRoomUpdate allotmentPlanRoomUpdate,
        HttpMethod requestType
    ){
        HttpHeaders headers = headerService.httpHeaderService(headerMap);

        HttpEntity<AllotmentPlanRoomUpdate> allotmentPlanRoomUpdateHttpEntity = new HttpEntity<>(
            allotmentPlanRoomUpdate,
            headers
        );

        restTemplate.exchange(
            serviceProperties.getUrl() + "/allotment-plans/" + allotmentPlanId + "/rooms",
            requestType,
            allotmentPlanRoomUpdateHttpEntity,
            AllotmentPlanRoomUpdate.class
        );
    }
}
