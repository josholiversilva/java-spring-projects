package net.mysql.product.controller;

import net.mysql.product.model.Product;
import net.mysql.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Product> listAllProducts() {
        return service.listAll();
    }

    @GetMapping("/products/{id}")
    // Path Variable will extract id in GetMapping
    // ResponseEntity<> -> handles HTTP exceptions on bad id
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        try {
            Product product = service.getProductById(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products")
    // Request Body tells spring to serialize json to data object
    public void addProduct(@RequestBody Product product) {
        service.saveProduct(product);
    }

    @PutMapping("/products/{id}")
    // ? is a data type for any (or expect any we dont know)
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable Integer id) {
        try {
            Product existProduct = service.getProductById(id);
            service.saveProduct(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/products/{id}")
    public void deleteProductById(@PathVariable Integer id) {
        service.deleteProductById(id);
    }
}
