package Docsafe.userService.service.impl;

import Docsafe.userService.entities.User;
import Docsafe.userService.exception.ResourceNotFoundException;
import Docsafe.userService.repositories.UserRepository;
import Docsafe.userService.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    EntityManager em;
    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(@Valid User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String Id) {

        User user = userRepository.findById(Id)
                .orElseThrow(()-> new ResourceNotFoundException("User does not exist with given ID:" + Id ));
        return user;
    }

    @Override
    public boolean deleteUser(String userId) {
        return false;
    }

    @Override
    public boolean updateUser(String userID) {
        return false;
    }



    @Override
    public User findByUserID(String userId) {

//        try {
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<User> cq = cb.createQuery(User.class);
//            Root<User> from = cq.from(User.class);
//            Predicate userIdPredicate = cb.equal(from.get("userID"), userId);
//            cq.where(userIdPredicate);
//
//            TypedQuery<User> query = em.createQuery(cq);
//
//            return query.getResultList();
//        }
//        catch (Exception e){
//            System.out.println("no user found");
//            return Collections.EMPTY_LIST;
//        }


                 return  userRepository.findByUserID(userId);

//                if(user == null){
//            System.out.println("no user found");
//            return true;
//            }
//
//            return false;

    }


}

