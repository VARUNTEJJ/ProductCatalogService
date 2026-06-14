package in.varun.productcatalogservice.Controller;

import in.varun.productcatalogservice.Dtos.ProductDTO;
import in.varun.productcatalogservice.Model.Product;
import in.varun.productcatalogservice.Service.IProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ProductController {
    IProductService productService;

    /*
    Constructor injection
     */

    public ProductController(@Qualifier("storageProductService") IProductService productService){

        this.productService = productService;
    }




    @PutMapping("/products/{productId}")
    ProductDTO updateProduct(@PathVariable("productId") Long productId,
                             @RequestBody ProductDTO productDTO){

        /*
        productDto to product
        pass productDTO and get the product back
         */
        ProductDTO productReponseDTO = new ProductDTO();
        /*
        call the service layer to update the product
         */

        Product product = productService.replaceProduct(productDTO.convertToProduct(), productId);

        if(product != null){
            return product.convert();
        }
        return null;
    }

    /*
    Test in isolation
    a() {
        b(); //we need mock of b
    }
     */


    @PostMapping("/products")
    ProductDTO createProduct(@RequestBody ProductDTO product){

        ProductDTO productReponseDTO = new ProductDTO();
        /*
        call the service layer to save the product
         */

        //productService.createProduct(product);

        Product product1 = productService.createProduct(product.convertToProduct());
        if(product1 != null){
            return product1.convert();
        }
        return productReponseDTO;
    }
    /*
    "name": "iphone",
    "descr": "apple",

     */
    @GetMapping("/products/{id}")
    ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id){

        if (id < 0) {
            throw new IllegalArgumentException("Product Id not found");
        } else if(id == 0) {
            throw new IllegalArgumentException("Products exist with positive id");
        }



        Product product = productService.getProductById(id);


        if(product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }




        ProductDTO productDTO = product.convert();

        return new ResponseEntity<>(productDTO,HttpStatus.OK);
    }

    @GetMapping("/products")
    List<ProductDTO> getAllProducts(){
        List<ProductDTO> productDTOS = new ArrayList<>();
        /*
        call the service layer to get all products
         */

        List<Product> products = productService.getAllProducts();

        if(products != null){
            for(Product product : products){
                productDTOS.add(product.convert());
            }
        }

        return productDTOS;
    }
    @GetMapping("/products/{productId}/{userId}")
    public ProductDTO getProductDetailsBasedOnUserRole(@PathVariable Long productId, @PathVariable Long userId) {
        System.out.println("Call reaching this api");
        Product product = productService.getProductBasedOnUserScope(productId, userId);
//        if(product != null) {
//            return from(product);
//        }
        return null;
    }
}