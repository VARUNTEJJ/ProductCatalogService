package in.varun.productcatalogservice.Model;

import in.varun.productcatalogservice.Dtos.ProductDto;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product extends BaseModel{

      /*
    name                          : String
    description                  : String
    price                            : Double
    imageUrl                     : String
    category                      : Category
    */
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private CategoryModel category;

    public ProductDto covert(Product product) {
        ProductDto productDto=new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        productDto.setImageUrl(product.getImageUrl());
        CategoryModel categoryModel=new CategoryModel();
        categoryModel.setName(product.getName());
        productDto.setName(categoryModel.getName());
        return productDto;
    }
}
