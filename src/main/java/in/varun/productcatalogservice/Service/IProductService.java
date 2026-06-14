package in.varun.productcatalogservice.Service;

import in.varun.productcatalogservice.Model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product createProduct(Product input);

    Product replaceProduct(Product input, Long productId);

    Product getProductBasedOnUserScope(Long productId, Long userId);
}