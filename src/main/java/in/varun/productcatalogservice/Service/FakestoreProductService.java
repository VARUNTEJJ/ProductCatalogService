package in.varun.productcatalogservice.Service;

import in.varun.productcatalogservice.Client.FakeStoreAPIClient;
import in.varun.productcatalogservice.Dtos.FakestoreProductDto;
import in.varun.productcatalogservice.Model.Product;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("fakestore")
public class FakestoreProductService implements IProductService {

    private FakeStoreAPIClient fakeStoreAPIClient;

    public FakestoreProductService(FakeStoreAPIClient fakeStoreAPIClient){
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }

    @Override
    public Product getProductById(Long id) {
//        FakestoreProductDto fakestoreProductDto = restTemplate.getForObject(
//                "https://fakestoreapi.com/products/{id}",
//                FakestoreProductDto.class,
//                id);

        ResponseEntity<FakestoreProductDto> fakestoreProductDtoResponseEntity = fakeStoreAPIClient.getForEntity(
                "https://fakestoreapi.com/products/{id}",
                FakestoreProductDto.class,
                id
        );


        if (fakeStoreAPIClient.validateResponse(fakestoreProductDtoResponseEntity)) {
            return fakestoreProductDtoResponseEntity.getBody().from(fakestoreProductDtoResponseEntity.getBody());
        }

        return null;

    }

    @Override
    public List<Product> getAllProducts() {

        List<Product> products = new ArrayList<>();

        ResponseEntity<FakestoreProductDto[]> response = fakeStoreAPIClient.getForEntity(
                "https://fakestoreapi.com/products",
                FakestoreProductDto[].class);

        if(response.hasBody() &&
                response.getStatusCode().equals(HttpStatusCode.valueOf(200))){
            FakestoreProductDto[] fakestoreProductDtos = response.getBody();

            for(FakestoreProductDto fakestoreProductDto : fakestoreProductDtos){
                products.add(fakestoreProductDto.from(fakestoreProductDto));
            }

            return products;

        }

        return null;

    }

    @Override
    public Product createProduct(Product input) {
        return null;
    }



    public Product replaceProduct(Product product, Long id){
        /*
        Billion dollar question?
         */
        FakestoreProductDto fakestoreProductDto = product.convertToFakeStoreProduct();


        ResponseEntity<FakestoreProductDto> response = fakeStoreAPIClient.putForEntity(
                "https://fakestoreapi.com/products/{id}",
                fakestoreProductDto,
                FakestoreProductDto.class,
                id
        );

        if(response.hasBody() &&
                response.getStatusCode().equals(HttpStatusCode.valueOf(200))){
//            FakestoreProductDto fakestoreProductDto1 = response.getBody();
//            return fakestoreProductDto1.from(fakestoreProductDto1);
            return product;
        }

        return  null;
    }

    @Override
    public Product getProductBasedOnUserScope(Long productId, Long userId) {
        return null;
    }
}