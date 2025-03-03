package spring.api.springcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.api.springcore.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
