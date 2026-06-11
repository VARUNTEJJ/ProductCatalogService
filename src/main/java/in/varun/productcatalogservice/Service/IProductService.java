package in.varun.productcatalogservice.Service;

import in.varun.productcatalogservice.Model.Product;

import java.util.List;

public interface IProductService {
    public Product getProductById(int id);

    public List<Product> getAllProducts();

    public Product createProduct();

    public Product updateProduct();
}
