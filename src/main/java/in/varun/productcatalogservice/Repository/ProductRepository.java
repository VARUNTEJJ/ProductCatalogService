package in.varun.productcatalogservice.Repository;

import in.varun.productcatalogservice.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long id);

    @Override
    List<Product> findAll();

    @Override
    Product save(Product product);


    List<Product> findByPriceBetween(Double low, Double high);


    List<Product> findAllByOrderByPrice();

    @Query("SELECT p.description FROM Product p WHERE p.id = :id") //HQL
    String findDescriptionWhereIdIs(@Param("id") Long id);
}