package compass_api.service.compass;

import compass_api.model.AllotmentPlanRestriction;
import compass_api.model.AllotmentPlanRoom;
import compass_api.service.HeaderService;
import compass_api.service.HelperEntityService;
import compass_api.service.ServiceProperties;
import compass_api.service.compass.AllotmentPlanRoomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class AllotmentPlanRoomServiceUnitTest {

    @Test
    public void getAllotmentPlansRooms(){

        ServiceProperties serviceProperties = Mockito.mock(ServiceProperties.class);
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        HelperEntityService helperEntityService = Mockito.mock(HelperEntityService.class);
        HeaderService headerService = Mockito.mock(HeaderService.class);

        AllotmentPlanRoomService allotmentPlanRoomService = new AllotmentPlanRoomService(
                serviceProperties, restTemplate, headerService, helperEntityService
        );

        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("x-consumer-key","1");
        headerMap.put("x-contract-id", "1");

        List<AllotmentPlanRoom> allotmentPlanRooms = new ArrayList<>();
        AllotmentPlanRoom allotmentPlanRoom = new AllotmentPlanRoom();
        allotmentPlanRooms.add(allotmentPlanRoom);

        ResponseEntity<List<AllotmentPlanRoom>> allotmentPlanRoomResponseEntity =
                new ResponseEntity<>(allotmentPlanRooms ,HttpStatus.OK);

        when(restTemplate.exchange(
                Matchers.anyString(),
                Matchers.any(HttpMethod.class),
                Matchers.<HttpEntity<?>> any(),
                Matchers.<ParameterizedTypeReference<List<AllotmentPlanRoom>>> any()
        )).thenReturn(allotmentPlanRoomResponseEntity);

        allotmentPlanRoomService.
                getAllotmentPlansRoomsList(
                        headerMap, 1,"?fromDate=2017-10-10&toDate=2018-10-10");
        Mockito.verify(restTemplate, times(1)).exchange(
                Mockito.anyString(),
                Mockito.<HttpMethod>any(),
                Mockito.<HttpEntity<?>>any(),
                Mockito.<ParameterizedTypeReference<List<AllotmentPlanRestriction>>>any()
        );
    }
}
