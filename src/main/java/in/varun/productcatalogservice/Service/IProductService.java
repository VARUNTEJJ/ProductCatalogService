package in.varun.productcatalogservice.Service;

import in.varun.productcatalogservice.Model.Product;

import java.util.List;

public interface IProductService {
    public Product getProductById(int id);

    public List<Product> getAllProducts();
    Product createProduct(Product input);

    Product replaceProduct(Product input, Long productId);

    Product getProductBasedOnUserScope(Long productId, Long userId);

    /*
    Generics?
    <T>
    Type erasure
    1. Compiling(Writing code)
    2. Runtime(Running code)

    List<String>
    List<Integer>
    Java checks your code to make sure you are not putting
    an integer into a string list. very strict.

    However, as soon as you compile the code, java "erases" the specific
    type inside the brackets

    List<T> ls = new List<>();


    List => class

    List<Integer> just becomes a list for Java
    List<String> just becomes a list for Java

    Rest templare needs to know exactly what class to create.
    Solution - Use arrays as they don't suffer from type erasure.

    Why do we have type erasure? - concept of generics.



    PUT - replaces/updates the entire product
    PATCH - partially updates the product
     */
}
