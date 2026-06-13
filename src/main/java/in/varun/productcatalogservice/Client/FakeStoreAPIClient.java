package in.varun.productcatalogservice.Client;

import in.varun.productcatalogservice.Dtos.FakeStoreDto;
import jakarta.annotation.Nullable;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreAPIClient {

    private static RestTemplate restTemplate;

    public FakeStoreAPIClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public static <T> ResponseEntity<T> putForEntity(String url, @Nullable Object request, Class<T> responseType, @Nullable Object... uriVariables) throws RestClientException {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor, uriVariables);
    }

    public static <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, HttpMethod.GET, requestCallback, responseExtractor, uriVariables);
    }



    /*
    getForEntity
     */

    public Boolean validateResponse(ResponseEntity<FakeStoreDto> fakeStoreProductDtoResponseEntity) {
        if (fakeStoreProductDtoResponseEntity.hasBody() &&
                fakeStoreProductDtoResponseEntity.getStatusCode().
                        equals(HttpStatusCode.valueOf(200))) {
            return true;
        }

        return false;
    }
}