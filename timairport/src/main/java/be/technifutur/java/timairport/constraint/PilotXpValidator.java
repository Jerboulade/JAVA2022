package be.technifutur.java.timairport.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class PilotXpValidator implements ConstraintValidator<PilotXp, LocalDate> {

    PilotXp constraint;

    @Override
    public void initialize(PilotXp constraintAnnotation) {
        constraint = constraintAnnotation;
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext context) {
        //(LocalDate.now().compareTo(localDate) > 5) &&
        System.out.println(constraint.value());
        System.out.println(localDate);
        System.out.println(localDate.plusYears(constraint.value()));
        System.out.println(localDate.plusYears(constraint.value()).isBefore(LocalDate.now()));
        if (localDate.plusYears(constraint.value()).isAfter(LocalDate.now())){
            context.buildConstraintViolationWithTemplate(String.format("Need %d year(s) experience!", constraint.value())).addConstraintViolation();
            return false;
        }
        return true;
    }
}
