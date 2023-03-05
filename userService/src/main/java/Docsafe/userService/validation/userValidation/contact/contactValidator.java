package Docsafe.userService.validation.userValidation.contact;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class contactValidator implements ConstraintValidator<ValidateContact, String> {

    @Override
    public boolean isValid(String contact, ConstraintValidatorContext constraintValidatorContext) {

        // Regular expression pattern for Canadian mobile number
        String pattern = "^(\\+?1)?[ -]?(\\()?([2-9][0-9]{2})(\\))?[- ]?([2-9][0-9]{2})[- ]?([0-9]{4})$";

        // Check if the mobileNumber  matches with the pattern
        return contact.matches(pattern);
    }
}
