package compass_api.service.compass;

import compass_api.model.ContractRoom;
import compass_api.service.HelperEntityService;
import compass_api.service.ServiceProperties;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class ContractRoomServiceUnitTest {

    @Test
    public void getContractRoom() {

        ServiceProperties serviceProperties = Mockito.mock(ServiceProperties.class);
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        HelperEntityService helperEntityService = Mockito.mock(HelperEntityService.class);

        ContractRoomService contractRoomService = new ContractRoomService(
                serviceProperties,
                restTemplate ,
                helperEntityService);

        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("x-consumer-key","1");
        headerMap.put("x-contract-id", "1");

        ContractRoom contractRoom = new ContractRoom();
        contractRoom.setName("testRoom");
        contractRoom.setId(1);

        ResponseEntity<ContractRoom> contractRoomResponseEntity = new ResponseEntity<>(contractRoom, HttpStatus.OK);

        when(restTemplate.exchange(
                Matchers.anyString(),
                Matchers.any(HttpMethod.class),
                Matchers.<HttpEntity<?>> any(),
                Matchers.<Class<ContractRoom>> any()
        )).thenReturn(contractRoomResponseEntity);

        contractRoomService.getContractsRooms(headerMap, 1,1);

        Mockito.verify(restTemplate, times(1)).exchange(
                Mockito.anyString(),
                Mockito.<HttpMethod>any(),
                Mockito.<HttpEntity<?>>any(),
                Mockito.<Class<ContractRoom>>any()
        );
    }
}
