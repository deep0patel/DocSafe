package Docsafe.userService.repositories;

import Docsafe.userService.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Transactional
    User findByUserID(String userId);

    //any custom method can be added here to make it faster. May be you can concatinate two names to create a full name here.
    // or may be you can preprocess any data before giving out.

}
