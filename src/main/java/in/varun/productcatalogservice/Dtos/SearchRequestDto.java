package in.varun.productcatalogservice.Dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SearchRequestDto {
    private String query;
    private Integer pageNo;
    private Integer pageSize;
    private List<SortParam> sortParams;
}
