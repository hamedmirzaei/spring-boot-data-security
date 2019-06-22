package spring.boot.data.security.productapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.data.security.productapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User getByUsername(String username);
}
