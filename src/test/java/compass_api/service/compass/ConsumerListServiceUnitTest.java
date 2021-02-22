package compass_api.service.compass;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import compass_api.model.ListResponse;
import compass_api.service.QueryProcessingService;
import java.util.Collections;
import java.util.HashMap;

import compass_api.model.Consumer;
import compass_api.service.HelperEntityService;
import compass_api.service.ServiceProperties;
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

@RunWith(SpringJUnit4ClassRunner.class)
public class ConsumerListServiceUnitTest {

	@Test
	public void getConsumers() {
		ServiceProperties serviceProperties = Mockito.mock(ServiceProperties.class);
		RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
		HelperEntityService helperEntityService = Mockito.mock(HelperEntityService.class);

		ConsumerListService consumerListService = new ConsumerListService(
				serviceProperties, restTemplate, helperEntityService
		);

		HashMap<String, String> headerMap = new HashMap<>();
		headerMap.put("x-consumer-key","1");
		headerMap.put("x-contract-id", "1");

		Consumer consumer = new Consumer();
		consumer.setId(1);
		consumer.setSlug("slug");
		consumer.setConsumerKey("xxxxx");

		ListResponse<Consumer> response = new ListResponse<Consumer>().addElement(consumer);

		ResponseEntity<ListResponse<Consumer>> consumerListResponseEntity = new ResponseEntity<>(
				response, HttpStatus.OK
		);

		when(restTemplate.exchange(
				Matchers.anyString(),
				any(HttpMethod.class),
				Matchers.<HttpEntity<?>> any(),
				Matchers.<ParameterizedTypeReference<ListResponse<Consumer>>> any()
				)).thenReturn(consumerListResponseEntity);

		consumerListService.getConsumersList(
				headerMap,
				QueryProcessingService.getQueryParsingervice(Collections.singletonMap("perPage", "1000"))
		);

		Mockito.verify(restTemplate, times(1)).exchange(
				Mockito.anyString(),
				Mockito.<HttpMethod> any(),
				Mockito.<HttpEntity<?>> any(),
				Mockito.<ParameterizedTypeReference<ListResponse<Consumer>>> any()
		);
	}
}
