package in.varun.productcatalogservice.Model;

import in.varun.productcatalogservice.Dtos.FakeStoreDto;
import in.varun.productcatalogservice.Dtos.ProductDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne(cascade = CascadeType.ALL)
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

    public FakeStoreDto convertToFakeStoreProduct(){
        FakeStoreDto fakeStoreProductDto = new FakeStoreDto();
        fakeStoreProductDto.setId(Math.toIntExact(this.getId()));
        fakeStoreProductDto.setTitle(this.getName());
        fakeStoreProductDto.setPrice(this.getPrice());
        fakeStoreProductDto.setDescription(this.getDescription());
        fakeStoreProductDto.setImageurl(this.getImageUrl());
        if(this.getCategory() != null) {
            fakeStoreProductDto.setCategory(this.getCategory().getName());
        }
        return fakeStoreProductDto;
    }
 }

