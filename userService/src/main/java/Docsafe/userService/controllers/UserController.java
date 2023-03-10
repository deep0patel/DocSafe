package Docsafe.userService.controllers;

import Docsafe.userService.entities.EmailDocUpload;
import Docsafe.userService.entities.User;
import Docsafe.userService.service.UserService;
import Docsafe.userService.service.impl.EmailServiceImpl;
import Docsafe.userService.service.impl.EmailServiceImplS;
import Docsafe.userService.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;




@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailServiceImplS emailServices;

    @Autowired
    private EmailDocUpload emailDocUpload;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @GetMapping("/newUser")
    public String userRegistration(Model model){
        model.addAttribute("user", new User());
        return "normalSignup";
    }

    // Validation method to check if userID is unique
    private boolean isUserIdUnique(String userID) {
        User user = userService.findByUserID(userID);
        return user == null;
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute User user, BindingResult result, Model model){
        if (result.hasErrors()) {
            logger.info("User Invalid ! Feedback given to user");
            model.addAttribute("user", user);
            return "normalSignup";
        } else {
            // Validate userID uniqueness before saving the user
            if (!isUserIdUnique(user.getUserID())) {
                result.rejectValue("userID", "Duplicate.user.userID");
                logger.info("Duplicate User ID Found ! Feedback given to user");
                model.addAttribute("user", user);
                return "normalSignup";
            }

            userService.saveUser(user);
            logger.info("User Valid ! sending email with link to upload document");

            String from = "deep1234p@gmail.com";
            emailDocUpload.setTo(user.getEmail());
            emailDocUpload.setMessage("Thank you for joining DocSafe. \n Please click the link below to upload your Driving License.");

            //sending email
            try {
                emailServices.sendHtmlEmail(emailDocUpload.getMessage(), EmailDocUpload.subject, emailDocUpload.getTo(), from, logger);
            }
            catch (Exception e){
                logger.info(e.getMessage());
                e.printStackTrace();
            }
            model.addAttribute("email", user.getEmail());
            return "userShow";
        }
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

