package compass_api.service.compass;

import java.util.List;
import java.util.Map;

import compass_api.model.Consumer;
import compass_api.service.HelperEntityService;
import compass_api.service.ServiceProperties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@EnableConfigurationProperties(ServiceProperties.class)
public class ConsumerListService {
	private final ServiceProperties serviceProperties;
	private RestTemplate restTemplate;
	private HelperEntityService helperEntityService;

	public ConsumerListService(ServiceProperties serviceProperties, RestTemplate restTemplate, HelperEntityService helperEntityService) {
		this.serviceProperties = serviceProperties;
		this.restTemplate = restTemplate;
		this.helperEntityService = helperEntityService;
	}

	public List<Consumer> getConsumersList(Map<String, String> headerMap) {
		HttpEntity<String> entity = helperEntityService.httpEntity(headerMap);

		ResponseEntity<List<Consumer>> consumersResponseEntity = restTemplate.exchange(
				serviceProperties.getUrl() + "/consumers", HttpMethod.GET,
				entity, new ParameterizedTypeReference<List<Consumer>>() {
				});

		return consumersResponseEntity.getBody();
	}
}
