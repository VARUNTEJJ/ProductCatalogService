package in.varun.productcatalogservice.Controller;

import in.varun.productcatalogservice.Dtos.ProductDto;
import in.varun.productcatalogservice.Model.Product;
import in.varun.productcatalogservice.Service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    IProductService productService;
    public ProductController(IProductService productService)
    {
        this.productService=productService;
    }

    //GETING PRODUCT USING ID
    @GetMapping("products/{id}")
    ResponseEntity<ProductDto> getProductById(@PathVariable("id") int product_id)
    {
        if(product_id<1)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Product product=productService.getProductById(product_id);
        if(product==null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ProductDto productDto=product.covert(product);
        return new ResponseEntity<>(productDto,HttpStatus.OK);
    }

    //GETTING ALL PRODUCTS
    @GetMapping("products")
    List<ProductDto> getAllProducts()
    {
        List<ProductDto> productDtos=new ArrayList<>();
        return productDtos;
    }


    //CERATING THE PRODUCT
    @PostMapping("/product")
    ProductDto createProduct(@RequestBody ProductDto prod)
    {
        ProductDto productDto1=new ProductDto();
        return productDto1;
    }

}
