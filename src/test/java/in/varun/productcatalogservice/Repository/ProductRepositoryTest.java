package in.varun.productcatalogservice.Repository;

import in.varun.productcatalogservice.Model.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    /*
    @Test
     */

    @Test
    @Transactional
    public void testJPAMethods() {


        String description =
                productRepository.findDescriptionWhereIdIs(1L);

        assertEquals(description,"Latest Apple smartphone");
    }

}