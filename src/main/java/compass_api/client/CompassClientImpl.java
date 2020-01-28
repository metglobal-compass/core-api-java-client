package compass_api.client;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import compass_api.model.AllotmentPlanRestriction;
import compass_api.model.AllotmentPlanRestrictionUpdate;
import compass_api.model.AllotmentPlanRoom;
import compass_api.model.AllotmentPlanRoomUpdate;
import compass_api.model.Booking.Booking;
import compass_api.model.Booking.PaymentInfo.PaymentInfo;
import compass_api.model.Booking.ProductBooking;
import compass_api.model.Consumer;
import compass_api.model.Contract;
import compass_api.model.ContractInventoryPlan;
import compass_api.model.ContractList;
import compass_api.model.ContractRatePlanList;
import compass_api.model.ContractRoom;
import compass_api.model.RatePlan;
import compass_api.model.RatePlanCancelPolicy;
import compass_api.model.RatePlanCancelPolicyUpdate;
import compass_api.model.RatePlanRoom;
import compass_api.model.RatePlanRoomDelete;
import compass_api.model.RatePlanRoomRate;
import compass_api.model.RatePlanRoomUpdate;
import compass_api.model.RatePlanSaleChannel;
import compass_api.model.RateUpdate;
import compass_api.model.User;
import compass_api.service.HeaderService;
import compass_api.service.HelperEntityService;
import compass_api.service.LoggingRequestInterceptor;
import compass_api.service.QueryProcessingService;
import compass_api.service.ServiceProperties;
import compass_api.service.compass.AllotmentPlanRestrictionService;
import compass_api.service.compass.AllotmentPlanRoomService;
import compass_api.service.compass.ConsumerListService;
import compass_api.service.compass.ContractInventoryPlanService;
import compass_api.service.compass.ContractListService;
import compass_api.service.compass.ContractRatePlanService;
import compass_api.service.compass.ContractRoomListService;
import compass_api.service.compass.ContractRoomService;
import compass_api.service.compass.ContractService;
import compass_api.service.compass.ProductBookingService;
import compass_api.service.compass.RatePlanCancelPolicyService;
import compass_api.service.compass.RatePlanRoomListService;
import compass_api.service.compass.RatePlanRoomRateService;
import compass_api.service.compass.RatePlanRoomService;
import compass_api.service.compass.RatePlanSaleChannelListService;
import compass_api.service.compass.RatePlanService;
import compass_api.service.compass.UserService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class CompassClientImpl implements CompassClient {

    private ContractRatePlanService contractRatePlanService;
    private AllotmentPlanRoomService allotmentPlanRoomService;
    private AllotmentPlanRestrictionService allotmentPlanRestrictionService;
    private ServiceProperties serviceProperties;
    private ContractInventoryPlanService contractInventoryPlanService;
    private ContractRoomListService contractRoomListService;
    private ContractListService contractListService;
    private ContractService contractService;
    private RatePlanService ratePlanService;
    private ContractRoomService contractRoomService;
    private ProductBookingService productBookingService;
    private RatePlanRoomListService ratePlanRoomListService;
    private RatePlanRoomRateService ratePlanRoomRateService;
    private RatePlanRoomService ratePlanRoomService;
    private RatePlanCancelPolicyService ratePlanCancelPolicyService;
    private RatePlanSaleChannelListService ratePlanSaleChannelListService;
    private UserService userService;
    private ConsumerListService consumerListService;
    private Cache<Object, Object> cache;

    public void setRatePlanRoomService(RatePlanRoomService ratePlanRoomService) {
        this.ratePlanRoomService = ratePlanRoomService;
    }

    public void setProductBookingService(ProductBookingService productBookingService) {
        this.productBookingService = productBookingService;
    }

    public void setContractRoomService(ContractRoomService contractRoomService) {
        this.contractRoomService = contractRoomService;
    }

    public void setRatePlanService(RatePlanService ratePlanService) {
        this.ratePlanService = ratePlanService;
    }

    public void setContractService(ContractService contractService) {
        this.contractService = contractService;
    }

    public void setContractInventoryPlanService(ContractInventoryPlanService contractInventoryPlanService) {
        this.contractInventoryPlanService = contractInventoryPlanService;
    }

    public void setContractRatePlanService(ContractRatePlanService contractRatePlanService) {
        this.contractRatePlanService = contractRatePlanService;
    }

    public void setAllotmentPlanRoomService(AllotmentPlanRoomService allotmentPlanRoomService) {
        this.allotmentPlanRoomService = allotmentPlanRoomService;
    }

    public void setAllotmentPlanRestrictionService(AllotmentPlanRestrictionService allotmentPlanRestrictionService) {
        this.allotmentPlanRestrictionService = allotmentPlanRestrictionService;
    }

    public void setContractRoomListService(ContractRoomListService contractRoomListService) {
        this.contractRoomListService = contractRoomListService;
    }

    public void setRatePlanRoomListService(RatePlanRoomListService ratePlanRoomListService) {
        this.ratePlanRoomListService = ratePlanRoomListService;
    }

    public void setRatePlanRoomRateService(RatePlanRoomRateService ratePlanRoomRateService) {
        this.ratePlanRoomRateService = ratePlanRoomRateService;
    }

    public void setRatePlanCancelPolicyService(RatePlanCancelPolicyService ratePlanCancelPolicyService) {
        this.ratePlanCancelPolicyService = ratePlanCancelPolicyService;
    }

    public void setRatePlanSaleChannelListService(RatePlanSaleChannelListService ratePlanSaleChannelListService) {
        this.ratePlanSaleChannelListService = ratePlanSaleChannelListService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setConsumerListService(ConsumerListService consumerListService) {
        this.consumerListService = consumerListService;
    }

    public CompassClientImpl(ServiceProperties serviceProperties) {
        this.serviceProperties = serviceProperties;

        cache = Caffeine.newBuilder()
                .expireAfterAccess(10, TimeUnit.MINUTES)
                .build();

        RestTemplate restTemplate = new RestTemplate(
                new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory())
        );
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        List<ClientHttpRequestInterceptor> interceptors;
        interceptors = new ArrayList<>();
        interceptors.add(new LoggingRequestInterceptor());
        restTemplate.setInterceptors(interceptors);

        contractRatePlanService = new ContractRatePlanService(
                serviceProperties,
                restTemplate,
                new HelperEntityService());

        allotmentPlanRoomService = new AllotmentPlanRoomService(
                serviceProperties,
                restTemplate,
                new HeaderService(),
                new HelperEntityService());

        allotmentPlanRestrictionService = new AllotmentPlanRestrictionService(
                serviceProperties,
                restTemplate,
                new HelperEntityService(),
                new HeaderService());

        contractInventoryPlanService = new ContractInventoryPlanService(
                serviceProperties,
                restTemplate,
                new HelperEntityService());

        contractRoomListService = new ContractRoomListService(
                serviceProperties,
                restTemplate,
                new HelperEntityService());

        contractRoomListService = new ContractRoomListService(
                serviceProperties,
                restTemplate,
                new HelperEntityService());

        contractService = new ContractService(
                serviceProperties,
                restTemplate,
                new HelperEntityService());

        ratePlanService = new RatePlanService(
                serviceProperties,
                restTemplate,
                new HelperEntityService());

        contractRoomService = new ContractRoomService(
                serviceProperties,
                restTemplate,
                new HelperEntityService());

        contractListService = new ContractListService(
                serviceProperties,
                restTemplate,
                new HelperEntityService()
        );

        productBookingService = new ProductBookingService(
                serviceProperties,
                restTemplate,
                new HelperEntityService());

        ratePlanRoomRateService = new RatePlanRoomRateService(
                serviceProperties, restTemplate, new HelperEntityService());

        ratePlanRoomListService = new RatePlanRoomListService(serviceProperties,
                restTemplate, new HeaderService(), new HelperEntityService());

        ratePlanRoomService = new RatePlanRoomService(
                serviceProperties, restTemplate, new HeaderService(), new HelperEntityService());

        ratePlanCancelPolicyService = new RatePlanCancelPolicyService(serviceProperties, restTemplate,
                new HelperEntityService(), new HeaderService());

        ratePlanSaleChannelListService = new RatePlanSaleChannelListService(serviceProperties, restTemplate,
                new HelperEntityService());

        userService = new UserService(serviceProperties, restTemplate, new HelperEntityService());

        consumerListService = new ConsumerListService(
                serviceProperties, restTemplate, new HelperEntityService()
        );
    }

    @Override
    public ContractRatePlanList getContractsRatePlans(HashMap<String, String> headerMap, Integer contractId) {

        return contractRatePlanService.getContractsRatePlans(headerMap, contractId, "");
    }

    @Override
    public List<AllotmentPlanRestriction> getAllotmentPlansRestrictionsListWithQuery(
            HashMap<String, String> headerMap, Integer allotmentPlanId, HashMap<String, String> queryMap) {

        String query = QueryProcessingService.getQueryParsingervice(queryMap);

        return allotmentPlanRestrictionService.
                getAllotmentPlansRestrictionsList(headerMap, allotmentPlanId, query);
    }

    @Override
    public void createAllotmentPlansRestrictions(
            HashMap<String, String> headerMap,
            Integer allotmentPlanId,
            AllotmentPlanRestrictionUpdate allotmentPlanRestrictionUpdate) {

        allotmentPlanRestrictionService.createAllotmentPlansRestrictions(
                headerMap,
                allotmentPlanId,
                allotmentPlanRestrictionUpdate);
    }

    @Override
    public void deleteAllotmentPlansRestrictions(
            HashMap<String, String> headerMap,
            Integer allotmentPlanId,
            AllotmentPlanRestrictionUpdate allotmentPlanRestrictionUpdate) {

        allotmentPlanRestrictionService.
                deletellotmentPlansRestrictions(headerMap, allotmentPlanId, allotmentPlanRestrictionUpdate);
    }

    @Override
    public List<AllotmentPlanRestriction> getAllotmentPlansRestrictionsListWithQueryMultiRooms(
            HashMap<String, String> headerMap, Integer allotmentPlanId,
            HashMap<String, String> queryMap, List<Integer> contractRoomIds) {

        String query = QueryProcessingService.getQueryParsingervice(queryMap);

        return allotmentPlanRestrictionService.getAllotmentPlansRestrictionsMultiRooms(headerMap, allotmentPlanId,
                query, contractRoomIds);
    }

    @Override
    public List<AllotmentPlanRoom> getAllotmentPlansRoomsListWithQuery(HashMap<String, String> headerMap,
                                                                       Integer allotmentPlanId,
                                                                       HashMap<String, String> queryMap) {
        String query = QueryProcessingService.getQueryParsingervice(queryMap);

        return allotmentPlanRoomService.getAllotmentPlansRoomsList(headerMap, allotmentPlanId, query);
    }

    @Override
    public void createAllotmentPlansRooms(HashMap<String, String> headerMap,
                                          Integer allotmentPlanId,
                                          AllotmentPlanRoomUpdate allotmentPlanRoomUpdate) {

        allotmentPlanRoomService.createAllotmentPlansRooms(headerMap, allotmentPlanId, allotmentPlanRoomUpdate);
    }

    @Override
    public ContractInventoryPlan getContractsInventoryPlans(HashMap<String,String> headerMap, Integer contractId) {

        return contractInventoryPlanService.getContractsInventoryPlans(headerMap, contractId);
    }

    @Override
    public ContractRatePlanList getContractsRatePlansWithQuery(HashMap<String,String> headerMap, Integer contractId, HashMap<String, String> queryMap) {

        String query = QueryProcessingService.getQueryParsingervice(queryMap);

        return contractRatePlanService.getContractsRatePlans(headerMap, contractId, query);
    }

    @Override
    public List<ContractRoom> getContractsRoomsList(HashMap<String,String> headerMap, Integer contractId) {

        return contractRoomListService.getContractsRoomsList(headerMap, contractId, "");
    }

    @Override
    public List<ContractRoom> getContractsRoomsListWithQuery(HashMap<String,String> headerMap, Integer contractId, HashMap<String, String> queryMap) {

        String query = QueryProcessingService.getQueryParsingervice(queryMap);

        return contractRoomListService.getContractsRoomsList(headerMap, contractId, query);
    }

    @Override
    public Contract getContracts(HashMap<String,String> headerMap, Integer contractId) {
        return contractService.getContracts(headerMap, contractId, "");
    }

    @Override
    public Contract getContractsWithQuery(HashMap<String,String> headerMap, Integer contractId, HashMap<String, String> queryMap) {
        String query = QueryProcessingService.getQueryParsingervice(queryMap);
        return contractService.getContracts(headerMap, contractId, query);
    }

    @Override
    public ContractList getContractsList(HashMap<String,String> headerMap) {

        return contractListService.getContractsList(headerMap);
    }

    @Override
    public RatePlan getRatePlans(HashMap<String,String> headerMap, Integer ratePlanCode, HashMap<String, String> queryMap) {

        String query = QueryProcessingService.getQueryParsingervice(queryMap);

        String key = "r:" + ratePlanCode + ":q:" + query;

        RatePlan ratePlan = (RatePlan) cache.getIfPresent(key);
        if (ratePlan == null) {
            ratePlan = ratePlanService.getRatePlans(headerMap, ratePlanCode, query);
            cache.put(key, ratePlan);

        }
        return ratePlan;
    }

    @Override
    public ContractRoom getContractsRooms(HashMap<String,String> headerMap, Integer contractId, Integer roomCode) {

        String key = "r:" + contractId + ":c:" + roomCode;

        ContractRoom contractRoom = (ContractRoom) cache.getIfPresent(key);

        if (contractRoom == null) {
            contractRoom = contractRoomService.getContractsRooms(headerMap, contractId, roomCode);
            cache.put(key, contractRoom);
        }
        return contractRoom;
    }

    @Override
    public ProductBooking getProductsBookings(HashMap<String,String> headerMap) {

        return productBookingService.getProductsBookings(headerMap, "");
    }

    @Override
    public ProductBooking getProductsBookingsWithQuery(HashMap<String,String> headerMap,
                                                       HashMap<String, String> queryMap) {

        String query = QueryProcessingService.getQueryParsingervice(queryMap);

        return productBookingService.getProductsBookings(headerMap, query);
    }

    @Override
    public Booking getProductsBookingsWithId(
        HashMap<String, String> headerMap, Integer bookingId, HashMap<String, String> queryMap
    ) {
        String query = QueryProcessingService.getQueryParsingervice(queryMap);

        return productBookingService.getProductsBookingsWithId(headerMap, bookingId, query);
    }

    @Override
    public PaymentInfo getProductsBookingsPaymentInfo(HashMap<String,String> headerMap,
                                                      Integer bookingId) {

        return productBookingService.getProductsBookingsPaymentInfo(headerMap, bookingId);
    }

    @Override
    public List<RatePlanRoomRate> getRatePlansRoomsRatesList(HashMap<String,String> headerMap,
                                                             Integer ratePlanId) {

        return ratePlanRoomRateService.getRatePlansRoomRatesList(headerMap, ratePlanId, "");
    }

    @Override
    public List<RatePlanRoom> getRatePlansRoomsListWithQuery(HashMap<String,String> headerMap,
                                                             Integer ratePlanId,
                                                             HashMap<String, String> queryMap) {
        String query = QueryProcessingService.getQueryParsingervice(queryMap);
        return ratePlanRoomListService.getRatePlansRoomsListWithQuery(headerMap, ratePlanId, query);
    }

    @Override
    public List<RatePlanRoomRate> getRatePlansRoomsRatesListWithQuery(
            HashMap<String,String> headerMap,
            Integer ratePlanId,
            HashMap<String, String> queryMap) {

        String query = QueryProcessingService.getQueryParsingervice(queryMap);

        return ratePlanRoomRateService.getRatePlansRoomRatesList(headerMap, ratePlanId, query);
    }

    @Override
    public void createRatePlansRooms(
        HashMap<String, String> headerMap,
        Integer ratePlanId,
        Integer roomId,
        RatePlanRoomUpdate ratePlanRoomUpdate
    ) {
        ratePlanRoomService.createRatePlansRooms(headerMap, ratePlanId, roomId, ratePlanRoomUpdate);
    }

    @Override
    public void updateRatePlansRooms(
        HashMap<String, String> headerMap,
        Integer ratePlanId,
        Integer roomId,
        RatePlanRoomUpdate ratePlanRoomUpdate
    ) {
        ratePlanRoomService.updateRatePlansRooms(headerMap, ratePlanId, roomId, ratePlanRoomUpdate);
    }

    @Override
    public void deleteRatePlansRooms(HashMap<String,String> headerMap, Integer ratePlanId, RateUpdate rateUpdate) {
        ratePlanRoomListService.deleteRatePlansRooms(headerMap, ratePlanId, rateUpdate);
    }

    @Override
    public void deleteRatePlansRoomsWithRoomCode(
        HashMap<String, String> headerMap, Integer ratePlanId, Integer contractRoomId, RatePlanRoomDelete ratePlanRoomDelete
    ) {
        ratePlanRoomService.deleteRatePlansRooms(headerMap, ratePlanId, contractRoomId, ratePlanRoomDelete);
    }

    @Override
    public List<RatePlanCancelPolicy> getRatePlanCancelPoliciesWithQuery(HashMap<String,String> headerMap,
                                                                         Integer ratePlanId,
                                                                         HashMap<String, String> queryMap) {
        String query = QueryProcessingService.getQueryParsingervice(queryMap);
        return ratePlanCancelPolicyService.getRatePlansCancelPolicies(headerMap, ratePlanId, query);
    }

    @Override
    public void createRatePlansCancelPolicies(HashMap<String,String> headerMap, Integer ratePlanId,
                                              RatePlanCancelPolicyUpdate params) {
        ratePlanCancelPolicyService.createRatePlansCancelPolicies(headerMap, ratePlanId, params);
    }

    @Override
    public List<RatePlanCancelPolicy> getRatePlanCancelPoliciesWithQueryMultiRooms(HashMap<String, String> headerMap,
                                                                                   Integer ratePlanId,
                                                                                   HashMap<String, String> queryMap,
                                                                                   List<Integer> contractRoomIds) {

        String query = QueryProcessingService.getQueryParsingervice(queryMap);

        return ratePlanCancelPolicyService.getRatePlansCancelPoliciesMultiRooms(headerMap,
                ratePlanId, query, contractRoomIds);
    }

    @Override
    public void createRatePlansRoomsList(HashMap<String,String> headerMap,
                                         Integer ratePlanId,
                                         RateUpdate rateUpdate) {
        ratePlanRoomListService.createRatePlansRoomsList(headerMap, ratePlanId, rateUpdate);
    }

    @Override
    public List<RatePlanSaleChannel> getRatePlansSaleChannelsList(HashMap<String, String> headerMap, Integer ratePlanId) {
        return ratePlanSaleChannelListService.getRatePlansSaleChannelsList(headerMap, ratePlanId);
    }

    @Override
    public User getUsers(HashMap<String, String> headerMap, Integer userId, HashMap<String, String> queryMap) {
        String query = QueryProcessingService.getQueryParsingervice(queryMap);
        String key = "u:" + userId;

        User user = (User) cache.getIfPresent(key);
        if (user == null) {
            user = userService.getUsers(headerMap, userId, query);
            cache.put(key, user);
        }

        return user;
    }

    @Override
    public List<Consumer> getConsumersList(HashMap<String, String> headerMap) {
        return consumerListService.getConsumersList(headerMap);
    }
}
