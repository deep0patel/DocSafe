package Docsafe.userService.service;

import Docsafe.userService.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String Id);

    boolean deleteUser(String Id);

    boolean updateUser(String ID);


    User findByUserID(String userId);


}
