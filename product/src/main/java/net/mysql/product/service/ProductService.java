package net.mysql.product.service;

import net.mysql.product.model.Product;
import net.mysql.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Lets spring know this class is a service
@Service
public class ProductService {

    // dependency injection
    @Autowired
    private ProductRepository repo;

    public List<Product> listAll() {
        return repo.findAll();
    }

    public void saveProduct(Product product) {
        repo.save(product);
    }

    public Product getProductById(Integer id) {
        return repo.findById(id).get();
    }

    public void deleteProductById(Integer id) {
        repo.deleteById(id);
    }
}
