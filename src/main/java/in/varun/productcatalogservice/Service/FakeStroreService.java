package in.varun.productcatalogservice.Service;

import in.varun.productcatalogservice.Dtos.FakeStoreDto;
import in.varun.productcatalogservice.Model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class FakeStroreService implements IProductService {

    RestTemplate restTemplate;
    public FakeStroreService(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate;
    }

    @Override
    public Product getProductById(int id) {
       ResponseEntity<FakeStoreDto> fakeStoreDtoResponseEntity=
               restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreDto.class,id);
       if(fakeStoreDtoResponseEntity.hasBody())
       {
           return fakeStoreDtoResponseEntity.getBody().from(fakeStoreDtoResponseEntity.getBody());
       }
       return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct() {
        return null;
    }

    @Override
    public Product updateProduct() {
        return null;
    }
}
