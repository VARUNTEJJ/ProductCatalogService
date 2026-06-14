package in.varun.productcatalogservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;
@Entity
@Setter
@Getter
public class Category extends BaseModel {
    /*
    name                          : String
    description                  : String
    products                     : List<Product>
     */

    private String name;
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    @JsonBackReference
    @BatchSize(size = 15) // you are going to decide batch
    //size based on data analysis
    private List<Product> products;

}