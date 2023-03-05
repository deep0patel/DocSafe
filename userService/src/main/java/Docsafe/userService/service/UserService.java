package Docsafe.userService.service;

import Docsafe.userService.entities.User;

import java.util.List;


public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String Id);

    boolean deleteUser(String Id);

    boolean updateUser(String ID);

    List<User> findByUserID(String userId);


}
