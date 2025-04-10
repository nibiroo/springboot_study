package io.github.nibiroo.study.Repository;

import io.github.nibiroo.study.Model.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByName (String name);
}
