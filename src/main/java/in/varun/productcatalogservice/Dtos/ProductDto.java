package in.varun.productcatalogservice.Dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private CatrgoryDto category;
    private Double price;
    private String imageUrl;
}
