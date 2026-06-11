package in.varun.productcatalogservice.Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class CategoryModel extends BaseModel{
    /*
    name                          : String
    description                  : String
    products                     : List<Product>
     */
    private String name;
    private String description;
    private List<Product> products;
}
