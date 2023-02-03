package be.technifutur.java.timairport.constraint;

import be.technifutur.java.timairport.model.entity.Pilot;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PilotIsNotNullValidator implements ConstraintValidator<PilotIsNotNull, Pilot> {
    @Override
    public boolean isValid(Pilot pilot, ConstraintValidatorContext constraintValidatorContext) {
        return pilot!=null;
    }
}
