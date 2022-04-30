package jjfactory.template.crud.repository;

import jjfactory.template.crud.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    User findByName(String name);
    User findByEmail(String email);
    Page<User> findAll(Pageable pageable);
}
