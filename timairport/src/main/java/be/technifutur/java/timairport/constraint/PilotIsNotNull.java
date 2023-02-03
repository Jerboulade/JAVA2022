package be.technifutur.java.timairport.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PilotIsNotNullValidator.class})
public @interface PilotIsNotNull {

    String message() default "value should not be same";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default {};



}
