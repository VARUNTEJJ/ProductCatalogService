package in.varun.productcatalogservice.Dtos;

import in.varun.productcatalogservice.Model.Category;
//import in.varun.productcatalogservice.Model.CategoryModel;
import in.varun.productcatalogservice.Model.Product;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private CategoryDTO category;
    private Double price;
    private String imageUrl;

    public Product convertToProduct() {
        Product product = new Product();
        product.setId(this.getId());
        product.setName(this.getName());
        product.setDescription(this.getDescription());
        product.setPrice(this.getPrice());
        product.setImageUrl(this.getImageUrl());
        if(product.getCategory() != null) {
            Category category1 = new Category();
            category1.setName(this.getCategory().getName());
            category1.setId(this.getCategory().getId());
            category1.setDescription(this.getCategory().getDescription());
            product.setCategory(category1);
        }
        return product;
    }
}