package in.varun.productcatalogservice.Model;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class CategoryModel extends BaseModel{
    /*
    name                          : String
    description                  : String
    products                     : List<Product>
     */
    private String name;
    private String description;
    private List<ProductModel> products;
}
