package compass_api.client;

import compass_api.model.*;
import compass_api.model.Booking.Booking;
import compass_api.model.Booking.PaymentInfo.PaymentInfo;
import compass_api.model.Booking.ProductBooking;

import java.util.HashMap;
import java.util.List;
import org.springframework.http.HttpMethod;

public interface CompassClient {

    ContractRatePlanList getContractsRatePlans(HashMap<String, String> headerMap, Integer contractId);

    List<AllotmentPlanRestriction> getAllotmentPlansRestrictionsListWithQuery(
            HashMap<String, String> headerMap,
            Integer allotmentPlanId,
            HashMap<String, String> queryMap
    );

    void createAllotmentPlansRestrictions(
            HashMap<String, String> headerMap,
            Integer allotmentPlanId,
            AllotmentPlanRestrictionUpdate allotmentPlanRestrictionUpdate);

    void deleteAllotmentPlansRestrictions(
            HashMap<String, String> headerMap,
            Integer allotmentPlanId,
            AllotmentPlanRestrictionUpdate allotmentPlanRestrictionUpdate);

    List<AllotmentPlanRestriction> getAllotmentPlansRestrictionsListWithQueryMultiRooms(
            HashMap<String, String> headerMap, Integer allotmentPlanId,
            HashMap<String, String> queryMap, List<Integer> contractRoomIds);

    List<AllotmentPlanRoom> getAllotmentPlansRoomsListWithQuery(
            HashMap<String, String> headerMap,
            Integer allotmentPlanId,
            HashMap<String, String> query
    );

    // TODO: Remove it, because change method should be used instead of this.
    void createAllotmentPlansRooms(
            HashMap<String, String> headerMap,
            Integer allotmentPlanId,
            AllotmentPlanRoomUpdate allotmentPlanRoomUpdate
    );

    void changeAllotmentPlansRooms(
        HashMap<String, String> headerMap,
        Integer allotmentPlanId,
        AllotmentPlanRoomUpdate allotmentPlanRoomUpdate,
        HttpMethod requestType
    );

    ContractInventoryPlan getContractsInventoryPlans(HashMap<String, String> headerMap, Integer contractId);

    ContractRatePlanList getContractsRatePlansWithQuery(
            HashMap<String, String> headerMap,
            Integer contractId,
            HashMap<String, String> mapQuery
    );

    List<ContractRoom> getContractsRoomsList(HashMap<String, String> headerMap, Integer contractId);

    List<ContractRoom> getContractsRoomsListWithQuery(
            HashMap<String, String> headerMap,
            Integer contractId,
            HashMap<String, String> queryMap);

    Contract getContracts(HashMap<String, String> headerMap, Integer contractId);

    Contract getContractsWithQuery(
            HashMap<String, String> headerMap,
            Integer contractId,
            HashMap<String, String> queryMap);

    ContractList getContractsList(HashMap<String, String> headerMap);

    RatePlan getRatePlans(
            HashMap<String, String> headerMap,
            Integer ratePlanCode,
            HashMap<String, String> queryMap
    );

    ContractRoom getContractsRooms(
            HashMap<String, String> headerMap,
            Integer contractId,
            Integer roomCode
    );

    ProductBooking getProductsBookings(HashMap<String, String> headerMap);

    ProductBooking getProductsBookingsWithQuery(
            HashMap<String, String> headerMap,
            HashMap<String, String> queryMap);

    Booking getProductsBookingsWithId(
        HashMap<String, String> headerMap, Integer bookingId, HashMap<String, String> queryMap
    );

    PaymentInfo getProductsBookingsPaymentInfo(HashMap<String, String> headerMap, Integer bookingId);

    List<RatePlanRoomRate> getRatePlansRoomsRatesList(HashMap<String,String> headerMap, Integer ratePlanId);

    List<RatePlanRoom> getRatePlansRoomsListWithQuery(
            HashMap<String,String> headerMap,
            Integer ratePlanId,
            HashMap<String, String> queryMap);

    List<RatePlanRoomRate> getRatePlansRoomsRatesListWithQuery(
            HashMap<String,String> headerMap,
            Integer ratePlanId,
            HashMap<String, String> queryMap);

    void createRatePlansRooms(
            HashMap<String,String> headerMap,
            Integer ratePlanId,
            Integer roomId,
            RatePlanRoomUpdate ratePlanRoomUpdate
    );

    void updateRatePlansRooms(
        HashMap<String,String> headerMap,
        Integer ratePlanId,
        Integer roomId,
        RatePlanRoomUpdate ratePlanRoomUpdate
    );

    void deleteRatePlansRooms(HashMap<String,String> headerMap,Integer ratePlanId, RateUpdate rateUpdate);

    void deleteRatePlansRoomsWithRoomCode(
        HashMap<String, String> headerMap, Integer ratePlanId, Integer contractRoomId, RatePlanRoomDelete ratePlanRoomDelete
    );

    List<RatePlanCancelPolicy> getRatePlanCancelPoliciesWithQuery(HashMap<String,String> headerMap,Integer ratePlanId,
                                                                  HashMap<String, String> queryMap);

    void createRatePlansCancelPolicies(HashMap<String,String> headerMap,
                                       Integer ratePlanId,
                                       RatePlanCancelPolicyUpdate params);

    List<RatePlanCancelPolicy> getRatePlanCancelPoliciesWithQueryMultiRooms(HashMap<String, String> headerMap,
                                                                            Integer ratePlanId,
                                                                            HashMap<String, String> queryMap,
                                                                            List<Integer> contractRoomIds);

    void createRatePlansRoomsList(HashMap<String,String> headerMap,Integer ratePlanId, RateUpdate rateUpdate);

    List<RatePlanSaleChannel> getRatePlansSaleChannelsList(HashMap<String,String> headerMap, Integer ratePlanId);

    User getUsers(HashMap<String, String> headerMap, Integer userId, HashMap<String, String> queryMap);

    List<Consumer> getConsumersList(
        HashMap<String, String> headerMap, HashMap<String, String> queryMap
    );
}