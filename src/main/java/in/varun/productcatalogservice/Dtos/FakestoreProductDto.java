package in.varun.productcatalogservice.Dtos;

import in.varun.productcatalogservice.Model.Category;
//import in.varun.productcatalogservice.Model.CategoryModel;
import in.varun.productcatalogservice.Model.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakestoreProductDto {
    private Long id;
    private String title;
    private String description;
    private String image;
    private Double price;
    private String category;

    public Product from(FakestoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setName(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());

        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }
}
