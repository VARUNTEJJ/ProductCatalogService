package in.varun.productcatalogservice.Dtos;

import in.varun.productcatalogservice.Model.CategoryModel;
import in.varun.productcatalogservice.Model.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreDto {
    /*
    Fakestore product
    id integer
    title string
    price number <float>
    description string
    category string
    image string <uri>
    */

    private Integer id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String imageurl;

    public Product from(FakeStoreDto fakeStoreDto)
    {
        Product product=new Product();
        product.setPrice(fakeStoreDto.getPrice());
        product.setId(Long.valueOf(fakeStoreDto.getId()));
        product.setImageUrl(fakeStoreDto.getImageurl());
        product.setDescription(fakeStoreDto.getDescription());
        CategoryModel categoryModel=new CategoryModel();
        categoryModel.setName(fakeStoreDto.getCategory());
        product.setName(categoryModel.getName());
        return product;
    }
}
