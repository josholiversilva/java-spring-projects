package net.mysql.product.repository;

import net.mysql.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// JPA -> relational data management (spring <-> JPA <-> rdb)
// No need to write a single SQL query
// <DB,id type> uses these values for manipulation
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
