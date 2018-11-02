package compass_api.service.compass;

import compass_api.service.HeaderService;
import compass_api.service.HelperEntityService;
import compass_api.service.ServiceProperties;
import compass_api.model.AllotmentPlanRestriction;
import compass_api.model.AllotmentPlanRestrictionUpdate;
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
public class AllotmentPlanRestrictionService {

    private final ServiceProperties serviceProperties;
    private RestTemplate restTemplate;
    private  HelperEntityService helperEntityService;
    private HeaderService headerService;

    public AllotmentPlanRestrictionService(ServiceProperties serviceProperties,
                                           RestTemplate restTemplate,
                                           HelperEntityService helperEntityService,
                                           HeaderService headerService) {

        this.serviceProperties = serviceProperties;
        this.restTemplate = restTemplate;
        this.helperEntityService = helperEntityService;
        this.headerService = headerService;
    }


    public List<AllotmentPlanRestriction> getAllotmentPlansRestrictionsList(
            Map<String, String>  headerMap,
            Integer allotmentPlanId,
            String query
    ){

        HttpEntity<String> entity = helperEntityService.httpEntity(headerMap);
        ResponseEntity<List<AllotmentPlanRestriction>> allotmentPlanRestrictionResponseEntity = restTemplate.exchange(
                serviceProperties.getUrl() + "/allotment-plans/" + allotmentPlanId +
                        "/restrictions" + query,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<AllotmentPlanRestriction>>() {
                });

        return allotmentPlanRestrictionResponseEntity.getBody();
    }


    public void createAllotmentPlansRestrictions(
            Map<String, String> mapHeader,
            Integer allotmentPlanId,
            AllotmentPlanRestrictionUpdate allotmentPlanRestrictionUpdate){

        HttpHeaders headers = headerService.httpHeaderService(mapHeader);

        HttpEntity<AllotmentPlanRestrictionUpdate> allotmentPlanRoomUpdateHttpEntity = new HttpEntity<>(
                allotmentPlanRestrictionUpdate,
                headers
        );

        restTemplate.exchange(
                serviceProperties.getUrl() +  "/allotment-plans/" + allotmentPlanId +
                        "/restrictions",
                HttpMethod.POST,
                allotmentPlanRoomUpdateHttpEntity,
                AllotmentPlanRestrictionUpdate.class
        );
    }

    public void deletellotmentPlansRestrictions(
            Map<String, String> headerMap,
            Integer allotmentPlanId,
            AllotmentPlanRestrictionUpdate allotmentPlanRestrictionUpdate
    ) {

        HttpHeaders headers = headerService.httpHeaderService(headerMap);

        HttpEntity<AllotmentPlanRestrictionUpdate> allotmentPlanRoomUpdateHttpEntity = new HttpEntity<>(
                allotmentPlanRestrictionUpdate,
                headers
        );

        restTemplate.exchange(
                serviceProperties.getUrl() +  "/allotment-plans/" + allotmentPlanId +
                        "/restrictions",
                HttpMethod.DELETE,
                allotmentPlanRoomUpdateHttpEntity,
                AllotmentPlanRestrictionUpdate.class
        );
    }

    public List<AllotmentPlanRestriction> getAllotmentPlansRestrictionsMultiRooms(Map<String, String> headerMap,
                                                                                  Integer allotmentPlanId,
                                                                                  String query,
                                                                                  List<Integer> contractRoomIds) {

        StringBuilder queryBuilder = new StringBuilder(query);
        contractRoomIds.forEach(roomId -> queryBuilder.append("&contractRoomId[]=").append(roomId));
        query = queryBuilder.toString();

        return this.getAllotmentPlansRestrictionsList(headerMap, allotmentPlanId, query);
    }
}
