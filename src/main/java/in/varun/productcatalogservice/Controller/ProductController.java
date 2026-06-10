package in.varun.productcatalogservice.Controller;

import in.varun.productcatalogservice.Dtos.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping("products/{id}")
    ProductDto getProductById(@PathVariable("id") int product_id)
    {
        ProductDto productDto=new ProductDto();
        return productDto;
    }
    @GetMapping("products")
    String getAllProducts()
    {
        return "Hello NEYMAR! how well World cup is going";
    }
}
