package Docsafe.userService.validation.userValidation.contact;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = contactValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateContact {

    public String message() default "{user.contact.NotValid.default.message}";

    // Contact Not Valid. Please use +1 111-111-1111 format

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
