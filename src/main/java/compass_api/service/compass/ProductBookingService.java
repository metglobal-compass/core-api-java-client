package compass_api.service.compass;

import compass_api.model.Booking.Booking;
import compass_api.service.HelperEntityService;
import compass_api.service.ServiceProperties;
import compass_api.model.Booking.PaymentInfo.PaymentInfo;
import compass_api.model.Booking.ProductBooking;
import java.util.HashMap;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@EnableConfigurationProperties(ServiceProperties.class)
public class ProductBookingService {

    private final ServiceProperties serviceProperties;
    private RestTemplate restTemplate;
    private HelperEntityService helperEntityService;

    public ProductBookingService(
        ServiceProperties serviceProperties,
        RestTemplate restTemplate,
        HelperEntityService helperEntityService
    ) {
        this.serviceProperties = serviceProperties;
        this.restTemplate = restTemplate;
        this.helperEntityService = helperEntityService;
    }

    // TODO Rename it with getProductsBookingsList
    public ProductBooking getProductsBookings(
            Map<String, String> headerMap,
            String query
    ) {
        HttpEntity<String> httpEntity = helperEntityService.httpEntity(headerMap);

        String url = serviceProperties.getUrl() + "/products/bookings" + query;

        ResponseEntity<ProductBooking> productBookingResponseEntity = restTemplate.exchange(
                url, HttpMethod.GET, httpEntity, ProductBooking.class
        );
        return productBookingResponseEntity.getBody();
    }

    public PaymentInfo getProductsBookingsPaymentInfo(
            Map<String, String> headerMap,
            Integer bookingId

    ){
        HttpEntity<String> httpEntity = helperEntityService.httpEntity(headerMap);

        String paymentUrl = serviceProperties.getUrl() +
                "/products/bookings/" +
                bookingId+
                "/payment-info";

        ResponseEntity<PaymentInfo> paymentInfoResponseEntity = restTemplate.exchange(
                paymentUrl, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<PaymentInfo>() {
                });

        return paymentInfoResponseEntity.getBody();
    }

    public Booking getProductsBookingsWithId(
        HashMap<String, String> headerMap, Integer bookingId, String query
    ) {
        HttpEntity<String> httpEntity = helperEntityService.httpEntity(headerMap);

        String url = serviceProperties.getUrl() + "/products/bookings/" + bookingId + query;

        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, Booking.class).getBody();
    }
}
