package in.varun.productcatalogservice.Service;

import in.varun.productcatalogservice.Client.FakeStoreAPIClient;
import in.varun.productcatalogservice.Dtos.FakeStoreDto;
import in.varun.productcatalogservice.Model.Product;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeStrokeService implements IProductService {


    RestTemplate restTemplate;
    public FakeStrokeService(RestTemplate restTemplate)
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
    @GetMapping()
        public List<Product> getAllProducts() {

            List<Product> products = new ArrayList<>();

            ResponseEntity<FakeStoreDto[]> response = FakeStoreAPIClient.getForEntity(
                    "https://fakestoreapi.com/products",
                    FakeStoreDto[].class);

            if(response.hasBody() &&
                    response.getStatusCode().equals(HttpStatusCode.valueOf(200))){
                FakeStoreDto[] fakestoreProductDtos = response.getBody();

                for(FakeStoreDto fakestoreProductDto : fakestoreProductDtos){
                    products.add(fakestoreProductDto.from(fakestoreProductDto));
                }

                return products;

            }

            return null;
        /*
        List class
        common functionalities
        add, remove, update, size, find, etc
        List<T> => List<T>
         */



        }

    @Override
    public Product createProduct(Product input) {
        return null;
    }

    /*
    Generics?
    <T>
    Type erasure
    1. Compiling(Writing code)
    2. Runtime(Running code)

    List<String>
    List<Integer>
    Java checks your code to make sure you are not putting
    an integer into a string list. very strict.

    However, as soon as you compile the code, java "erases" the specific
    type inside the brackets

    List<T> ls = new List<>();


    List => class

    List<Integer> just becomes a list for Java
    List<String> just becomes a list for Java

    Rest templare needs to know exactly what class to create.
    Solution - Use arrays as they don't suffer from type erasure.

    Why do we have type erasure? - concept of generics.



    PUT - replaces/updates the entire product
    PATCH - partially updates the product
     */


    public Product replaceProduct(Product product, Long id){
        /*
        Billion dollar question?
         */
        FakeStoreDto fakestoreProductDto = product.convertToFakeStoreProduct();


        ResponseEntity<FakeStoreDto> response = FakeStoreAPIClient.putForEntity(
                "https://fakestoreapi.com/products/{id}",
                fakestoreProductDto,
                FakeStoreDto.class,
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

