package be.technifutur.java.timairport.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PilotXpValidator.class)
public @interface PilotXp {
    String message() default "Not enough XP";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default {};

    int value() default 2;
}
