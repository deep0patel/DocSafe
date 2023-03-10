package Docsafe.userService.validation.userValidation.id;


import Docsafe.userService.entities.User;
import Docsafe.userService.service.UserService;
import Docsafe.userService.validation.userValidation.docId.ValidateDocID;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class userIdValidator implements ConstraintValidator<ValidateUserId, String> {

    @Autowired
    private UserService userService;

    @Override
    public void initialize(ValidateUserId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String userID, ConstraintValidatorContext constraintValidatorContext) {

//        System.out.println("Reached here");
//        List<User> l = userService.findByUserID(userID);
//        System.out.println("Exception  here");
//
//
//        return l.isEmpty();

//        if (userService.findByUserID(userID) != null) {
//            return false; // userId already exists
//        }
//        return true; // userId is unique

   //     return userService.findByUserID(userID);

        return true;

    }

}
