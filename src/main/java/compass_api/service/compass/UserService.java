package compass_api.service.compass;

import java.util.Map;

import compass_api.model.User;
import compass_api.service.HelperEntityService;
import compass_api.service.ServiceProperties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@EnableConfigurationProperties(ServiceProperties.class)
public class UserService {
	private final ServiceProperties serviceProperties;
	private RestTemplate restTemplate;
	private HelperEntityService helperEntityService;

	public UserService(ServiceProperties serviceProperties,
			RestTemplate restTemplate,
			HelperEntityService helperEntityService) {
		this.serviceProperties = serviceProperties;
		this.restTemplate = restTemplate;
		this.helperEntityService = helperEntityService;
	}

	public User getUsers(Map<String, String> headerMap, Integer userId, String query) {
		HttpEntity<String> entity = helperEntityService.httpEntity(headerMap);
		ResponseEntity<User> userResponseEntity = restTemplate.exchange(
				serviceProperties.getUrl() + "/users/" + userId + query,
				HttpMethod.GET, entity, User.class);

		return userResponseEntity.getBody();
	}
}
