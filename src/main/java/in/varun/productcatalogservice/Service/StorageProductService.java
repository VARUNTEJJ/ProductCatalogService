package in.varun.productcatalogservice.Service;

import in.varun.productcatalogservice.Model.Product;
import in.varun.productcatalogservice.Model.State;
import in.varun.productcatalogservice.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service("storageProductService")
@Primary
public class StorageProductService implements IProductService {

    private ProductRepository productRepository;

    @Autowired
    private RestTemplate restTemplate;

    public StorageProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product input) {
        Optional<Product> optionalProduct = productRepository.findById(input.getId());

        if (optionalProduct.isEmpty()) {
            return productRepository.save(input);
        } else {
            // we can throw an exception that product already exists
            return null;
        }
    }

    //PUT request
    //this will update the entire product
    @Override
    public Product replaceProduct(Product input, Long productId) {

        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isEmpty()) {
            //Don't create a new product since we are just replacing
            return null;
        } else {
            input.setId(productId);
            input.setCreatedAt(optionalProduct.get().getCreatedAt());

            return productRepository.save(input);
        }
    }

    @Override
    public Product getProductBasedOnUserScope(Long productId, Long userId) {

        Optional<Product> product = productRepository.findById(productId);
        return null;
    }


    public boolean deleteProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            return false;
        } else {
            Product product = optionalProduct.get();
            if (product.getState().equals(State.ACTIVE)) {
                product.setState(State.INACTIVE);
                productRepository.save(product);
                return true;
            }
            return false;
        }
    }
}