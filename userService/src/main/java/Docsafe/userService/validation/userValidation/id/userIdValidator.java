package Docsafe.userService.validation.userValidation.id;


import Docsafe.userService.entities.User;
import Docsafe.userService.service.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class userIdValidator implements ConstraintValidator<ValidateUserId, String> {

    @Qualifier("userService")
    private UserService userService;


    public userIdValidator() {
    }

    public userIdValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String userID, ConstraintValidatorContext constraintValidatorContext) {

        System.out.println("Reached here");
        List<User> l = userService.findByUserID(userID);
        System.out.println("Exception  here");


        return l.isEmpty();

    }

}
