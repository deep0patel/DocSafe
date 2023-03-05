package Docsafe.userService.validation.userValidation.docId;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class docIdValidator implements ConstraintValidator<ValidateDocID, String> {
    @Override
    public void initialize(ValidateDocID constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String docID, ConstraintValidatorContext constraintValidatorContext) {

        // Regular expression pattern for Ontario driving license number
        String pattern = "^[A-Z]{1}\\d{4}-\\d{5}-\\d{5}$";

        // Check if the dlNumber matches with the pattern
        return docID.matches(pattern);
    }
}
