package compass_api.client;

import com.google.gson.reflect.TypeToken;
import compass_api.model.AllotmentPlanRestriction;
import compass_api.model.AllotmentPlanRoom;
import compass_api.model.Consumer;
import compass_api.model.ContractRatePlan;
import compass_api.model.ContractRatePlanList;
import compass_api.model.ListResponse;
import compass_api.model.RatePlanSaleChannel;
import compass_api.model.User;
import compass_api.service.QueryProcessingService;
import compass_api.service.ServiceProperties;
import compass_api.service.compass.AllotmentPlanRestrictionService;
import compass_api.service.compass.AllotmentPlanRoomService;
import compass_api.service.compass.ConsumerListService;
import compass_api.service.compass.ContractRatePlanService;
import compass_api.service.compass.RatePlanSaleChannelListService;
import compass_api.service.compass.UserService;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class CompassClientImplUnitTest {

    @Test
    public void getContractsRatePlans() throws IOException {

        ContractRatePlanService contractRatePlanService = Mockito.mock(ContractRatePlanService.class);

        Class  classLoader = this.getClass();

        File restTemplateContractRatePlanFile = new File(
                classLoader.getResource("/UnitTestFile/RestTemplateContractRatePlan").getFile());

        String restTemplateContractRatePlan = new String(
                Files.readAllBytes(restTemplateContractRatePlanFile.toPath())
        );

        Gson gson = new Gson();

        ListResponse<ContractRatePlan> contractRatePlanList = gson.fromJson(
            restTemplateContractRatePlan, new TypeToken<ListResponse<ContractRatePlan>>(){}.getType()
        );

        ResponseEntity<ListResponse<ContractRatePlan>> contractRatePlanListResponseEntity =
            new ResponseEntity<>(contractRatePlanList, HttpStatus.OK);

        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("x-consumer-key","1");
        headerMap.put("x-contract-id", "1");

        ServiceProperties serviceProperties = new ServiceProperties();
        CompassClientImpl compassClient = new CompassClientImpl(serviceProperties);

        compassClient.setContractRatePlanService(contractRatePlanService);

        when(contractRatePlanService.getContractsRatePlans(headerMap, 117,""))
            .thenReturn(contractRatePlanListResponseEntity.getBody().getData());

        assertEquals(contractRatePlanListResponseEntity.getBody().getData(),
                compassClient.getContractsRatePlans(headerMap, 117));
    }

    @Test
    public void getAllotmentPlanRestrictionListWithQuery() throws IOException {
        AllotmentPlanRestrictionService allotmentPlanRestrictionService =
                Mockito.mock(AllotmentPlanRestrictionService.class);

        HashMap<String, String> queryMap = new HashMap<>();
        queryMap.put("fromDate","2017-10-10");
        queryMap.put("toDate","2017-12-12");

        String query = "?fromDate=2017-10-10&toDate=2017-12-12";

        Class classLoader = this.getClass();

        File restTemplateAllotmentPlanRestrictionFile = new File(
                classLoader.getResource("/UnitTestFile/RestTemplateAllotmentPlanRestriction").getFile());

        String restTemplateAllotmentPlanRestriction = new String(
                Files.readAllBytes(restTemplateAllotmentPlanRestrictionFile.toPath()));

        Gson gson = new Gson();

        Type allotmentPlanRestrictonType =  new TypeToken<List<AllotmentPlanRestriction>>(){}.getType();

        List<AllotmentPlanRestriction> allotmentPlanRestrictions =
                gson.fromJson(restTemplateAllotmentPlanRestriction, allotmentPlanRestrictonType);

        ResponseEntity<List<AllotmentPlanRestriction>> allotmentPlansRestrictionsResponseEntity =
                new ResponseEntity<>(allotmentPlanRestrictions, HttpStatus.OK);

        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("x-consumer-key","1");
        headerMap.put("x-contract-id", "1");

        ServiceProperties serviceProperties = new ServiceProperties();

        CompassClientImpl compassClient = new CompassClientImpl(serviceProperties);

        compassClient.setAllotmentPlanRestrictionService(allotmentPlanRestrictionService);


        when(allotmentPlanRestrictionService.getAllotmentPlansRestrictionsList(headerMap,170, query)).
                thenReturn(allotmentPlansRestrictionsResponseEntity.getBody());

        assertEquals(allotmentPlansRestrictionsResponseEntity.getBody(),
                compassClient.getAllotmentPlansRestrictionsListWithQuery(headerMap,170,queryMap));
    }

    @Test
    public void getAllotmentPlanRoomListWithQuery() throws IOException {

        AllotmentPlanRoomService allotmentPlanRoomService = Mockito.mock(AllotmentPlanRoomService.class);

        HashMap<String, String> queryMap = new HashMap<>();
        queryMap.put("fromDate","2017-10-10");
        queryMap.put("toDate","2017-12-12");

        String query = "?fromDate=2017-10-10&toDate=2017-12-12";

        Class classLoader = this.getClass();

        File restTemplateAllotmentPlanRoomListFile = new File(
                classLoader.getResource("/UnitTestFile/RestTemplateAllotmentPlanRoomList").getFile());

        String restTemplateAllotmentPlanRoomList = new String(Files.readAllBytes(
                restTemplateAllotmentPlanRoomListFile.toPath()));

        Gson gson = new Gson();

        Type allotmentPlanRoomListType = new TypeToken<List<AllotmentPlanRoom>>(){}.getType();

        List<AllotmentPlanRoom> allotmentPlanRooms = gson.fromJson(
                restTemplateAllotmentPlanRoomList, allotmentPlanRoomListType);

        ResponseEntity<List<AllotmentPlanRoom>> allotmentPlanRoomResponseEntity =
                new ResponseEntity<>(allotmentPlanRooms, HttpStatus.OK);
        HashMap<String, String> headerMap = new HashMap<>();

        headerMap.put("x-consumer-key","1");
        headerMap.put("x-contract-id", "1");

        ServiceProperties serviceProperties = new ServiceProperties();

        CompassClientImpl compassClient = new CompassClientImpl(serviceProperties);

        compassClient.setAllotmentPlanRoomService(allotmentPlanRoomService);

        when(allotmentPlanRoomService.getAllotmentPlansRoomsList(headerMap, 170, query)).
                thenReturn(allotmentPlanRoomResponseEntity.getBody());

        assertEquals(allotmentPlanRoomResponseEntity.getBody(),
                compassClient.getAllotmentPlansRoomsListWithQuery(headerMap, 170, queryMap));
    }

    @Test
    public void getRatePlanSaleChannelList() throws IOException {
        RatePlanSaleChannelListService service = Mockito.mock(RatePlanSaleChannelListService.class);

        Class loader = this.getClass();
        File responseFile = new File(loader.getResource("/UnitTestFile/RestTemplateRatePlanSaleChannelList").getFile());
        String response = new String(Files.readAllBytes(responseFile.toPath()));

        Type ratePlanSaleChannelListType = new TypeToken<List<RatePlanSaleChannel>>(){}.getType();

        List<RatePlanSaleChannel> ratePlanSaleChannels = new Gson().fromJson(response, ratePlanSaleChannelListType);
        ResponseEntity<List<RatePlanSaleChannel>> responseEntity = new ResponseEntity<>(
                ratePlanSaleChannels, HttpStatus.OK);

        ServiceProperties serviceProperties = new ServiceProperties();
        CompassClientImpl client = new CompassClientImpl(serviceProperties);
        client.setRatePlanSaleChannelListService(service);

        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("x-user-id", "1");
        headerMap.put("x-consumer-key", "1");

        when(service.getRatePlansSaleChannelsList(headerMap, 2)).thenReturn(responseEntity.getBody());

        List<RatePlanSaleChannel> saleChannelList = client.getRatePlansSaleChannelsList(headerMap, 2);

        assertEquals(responseEntity.getBody(), saleChannelList);
    }

    @Test
    public void getUsers() throws IOException {
        UserService service = Mockito.mock(UserService.class);

        Class loader = this.getClass();
        File respFile = new File(loader.getResource("/UnitTestFile/RestTemplateUser.json").getFile());
        String response = new String(Files.readAllBytes(respFile.toPath()));

        User user = new Gson().fromJson(response, User.class);
        ResponseEntity<User> responseEntity = new ResponseEntity<>(user, HttpStatus.OK);

        ServiceProperties serviceProperties = new ServiceProperties();
        CompassClientImpl client = new CompassClientImpl(serviceProperties);
        client.setUserService(service);

        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("x-user-id", "1");
        headerMap.put("x-consumer-key", "1");

        HashMap<String, String> queryMap = new HashMap<>();
        queryMap.put("hedeKey", "hodoValue");
        String query = QueryProcessingService.getQueryParsingervice(queryMap);

        when(service.getUsers(headerMap, 3, query)).thenReturn(responseEntity.getBody());

        User clientUser = client.getUsers(headerMap, 3, queryMap);

        assertEquals(responseEntity.getBody(), clientUser);
    }

    @Test
    public void getConsumers() {
        ConsumerListService service = Mockito.mock(ConsumerListService.class);

        List<Consumer> consumerList = new ArrayList<>();
        Consumer consumer = new Consumer();
        consumer.setId(1);
        consumer.setSlug("slug");
        consumer.setConsumerKey("xxxx");
        consumerList.add(consumer);

        ResponseEntity<List<Consumer>> consumerListResponseEntity = new ResponseEntity<>(
                consumerList, HttpStatus.OK
        );

        ServiceProperties serviceProperties = new ServiceProperties();
        CompassClientImpl client = new CompassClientImpl(serviceProperties);
        client.setConsumerListService(service);

        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("x-user-id", "1");
        headerMap.put("x-consumer-key", "1");

        HashMap<String, String> queryMap = new HashMap<>();
        queryMap.put("perPage", "1000");

        when(service.getConsumersList(
            headerMap, QueryProcessingService.getQueryParsingervice(queryMap)
        ))
            .thenReturn(consumerListResponseEntity.getBody());

        List<Consumer> clientConsumers = client.getConsumersList(headerMap, queryMap);

        assertEquals(consumerListResponseEntity.getBody(), clientConsumers);
    }
}
