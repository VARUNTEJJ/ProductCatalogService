package in.varun.productcatalogservice.Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ProductModel extends BaseModel{

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
}
