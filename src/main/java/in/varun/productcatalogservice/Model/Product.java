package in.varun.productcatalogservice.Model;

import in.varun.productcatalogservice.Dtos.CategoryDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import in.varun.productcatalogservice.Dtos.FakestoreProductDto;
import in.varun.productcatalogservice.Dtos.ProductDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Product extends BaseModel {


    private String name;
    private String description;
    private Double price;
    private String imageUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Category category;



    public FakestoreProductDto convertToFakeStoreProduct(){
        FakestoreProductDto fakeStoreProductDto = new FakestoreProductDto();
        fakeStoreProductDto.setId(this.getId());
        fakeStoreProductDto.setTitle(this.getName());
        fakeStoreProductDto.setPrice(this.getPrice());
        fakeStoreProductDto.setDescription(this.getDescription());
        fakeStoreProductDto.setImage(this.getImageUrl());
        if(this.getCategory() != null) {
            fakeStoreProductDto.setCategory(this.getCategory().getName());
        }
        return fakeStoreProductDto;
    }

    public ProductDTO convert(){
        ProductDTO productDto = new ProductDTO();
        productDto.setId(this.getId());
        productDto.setName(this.getName());
        productDto.setDescription(this.getDescription());
        productDto.setPrice(this.getPrice());
        productDto.setImageUrl(this.getImageUrl());
        if(this.getCategory() != null) {
            CategoryDTO categoryDto = new CategoryDTO();
            categoryDto.setName(this.getCategory().getName());
            categoryDto.setId(this.getCategory().getId());
            categoryDto.setDescription(this.getCategory().getDescription());
            productDto.setCategory(categoryDto);
        }
        return productDto;

    }
}