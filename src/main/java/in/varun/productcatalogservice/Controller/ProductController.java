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
    List<ProductDto> getAllProducts(){
        List<ProductDto> productDTOS = new ArrayList<>();
        /*
        call the service layer to get all products
         */

        List<Product> products = productService.getAllProducts();

        if(products != null){
            for(Product product : products){
                productDTOS.add(product.covert(product));
            }
        }

        return productDTOS;
    }


    //CERATING THE PRODUCT
    @PostMapping("/product")
    ProductDto createProduct(@RequestBody ProductDto prod)
    {

        ProductDto productReponseDTO = new ProductDto();
        /*
        call the service layer to save the product
         */

        //productService.createProduct(product);

        Product product1 = productService.createProduct(prod.convertToProduct());
        if(product1 != null){
            return product1.covert(product1);
        }
        return productReponseDTO;
    }


    @PutMapping("/products/{productId}")
    ProductDto updateProduct(@PathVariable("productId") Long productId,
                             @RequestBody ProductDto productDTO){

        /*
        productDto to product
        pass productDTO and get the product back
         */
        ProductDto productReponseDTO = new ProductDto();
        /*
        call the service layer to update the product
         */

        Product product = productService.replaceProduct(productDTO.convertToProduct(), productId);

        if(product != null){
            return product.covert(product);
        }
        return null;
    }
}
