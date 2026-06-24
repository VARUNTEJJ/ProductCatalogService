package in.varun.productcatalogservice.Service;

import in.varun.productcatalogservice.Dtos.SortParam;
import in.varun.productcatalogservice.Model.Product;
import in.varun.productcatalogservice.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService implements ISearchService{


    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> searchProducts(String query, Integer pageNo, Integer pageSize, List<SortParam> sortParams)

    {
        Sort sort = Sort.unsorted();

        if(!sortParams.isEmpty()){
            if("ASC".equalsIgnoreCase(sortParams.get(0).getOrder())){
                sort = Sort.by(sortParams.get(0).getParamName()).ascending();
            }else{
                sort = Sort.by(sortParams.get(0).getParamName()).descending();
            }

            for(int i = 1 ; i < sortParams.size() ; i++){
                if("ASC".equalsIgnoreCase(sortParams.get(0).getOrder())) {
                    sort = sort.and(Sort.by(sortParams.get(i).getParamName()).ascending());
                }else{
                    sort = sort.and(Sort.by(sortParams.get(i).getParamName()).descending());
                }
            }
        }

        return productRepository.findByNameContainingIgnoreCase(
                query,
                PageRequest.of(pageNo, pageSize, sort)
        );
    }
}
