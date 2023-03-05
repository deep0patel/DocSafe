package Docsafe.userService.validation.userValidation.id;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = userIdValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateUserId {

    public String message() default "Oops ! User id not available !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
