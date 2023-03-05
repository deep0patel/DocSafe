package Docsafe.userService.service.impl;

import Docsafe.userService.entities.User;
import Docsafe.userService.exception.ResourceNotFoundException;
import Docsafe.userService.repositories.UserRepository;
import Docsafe.userService.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Component("userService")
public class UserServiceImpl implements UserService {


    @Autowired
    EntityManager em;
    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
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
    public List<User> findByUserID(String userId) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> from = cq.from(User.class);
        Predicate userIdPredicate = cb.equal(from.get("userID"  ), userId);
        cq.where(userIdPredicate);

        TypedQuery<User> query = em.createQuery(cq);

        return query.getResultList();

    }


}

