package spring.boot.data.security.productapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.data.security.productapp.model.AuthGroup;

import java.util.List;

public interface AuthGroupRepository extends JpaRepository<AuthGroup, Long> {
    List<AuthGroup> findByUsername(String username);
}
