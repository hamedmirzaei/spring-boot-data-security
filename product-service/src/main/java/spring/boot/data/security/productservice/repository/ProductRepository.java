package spring.boot.data.security.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.data.security.productservice.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
