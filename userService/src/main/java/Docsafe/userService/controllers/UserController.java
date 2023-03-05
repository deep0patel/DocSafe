package Docsafe.userService.controllers;

import Docsafe.userService.entities.User;
import Docsafe.userService.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/newUser")
    public String userRegistration(Model model){
        model.addAttribute("user", new User());
        return "normalSignup";
    }

    //You might need to move these methods to user Rest controller.
    // add logger later to generate a log that new user has been created
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute @Valid User user, BindingResult result, Model model){

        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "normalSignup";
        } else {
            userService.saveUser(user);
            model.addAttribute("email", user.getEmail());
            return "userShow";
        }

    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler({MethodArgumentNotValidException.class})
//    public Map<String, String> handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }
}
