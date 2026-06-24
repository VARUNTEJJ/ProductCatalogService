package in.varun.productcatalogservice.Service;

import in.varun.productcatalogservice.Dtos.SortParam;
import in.varun.productcatalogservice.Model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ISearchService {
    Page<Product> searchProducts(String query,
                                 Integer pageNo,
                                 Integer pageSize,
                                 List<SortParam> sortParams);
}
