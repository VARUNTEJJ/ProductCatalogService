package in.varun.productcatalogservice.Dtos;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CategoryDTO {
    private Long id;
    private String name;
    private String description;
}