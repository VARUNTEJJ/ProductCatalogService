package in.varun.productcatalogservice.Controller;

import in.varun.productcatalogservice.Dtos.ProductDTO;
import in.varun.productcatalogservice.Dtos.SearchRequestDto;
import in.varun.productcatalogservice.Model.Product;
import in.varun.productcatalogservice.Service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping
    public Page<Product> search(@RequestBody SearchRequestDto searchRequestDto){
        Page<Product> products = searchService.searchProducts(
                searchRequestDto.getQuery(),
                searchRequestDto.getPageNo(),
                searchRequestDto.getPageSize(),
                searchRequestDto.getSortParams());

       return products;
    }

}
