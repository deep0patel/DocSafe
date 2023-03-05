package Docsafe.userService.validation.userValidation.docId;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = docIdValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateDocID {


    public String message() default "Document Id is not valid, Use example: H1234-56789-01235";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
