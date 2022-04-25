package lesson43.validator;

import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class PositiveOrZeroValidator implements ConstraintValidator<PositivOrZero, Integer> {

    private PositivOrZero annotation;

    @Override
    public void initialize(PositivOrZero annotation) {
        this.annotation = annotation;
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value < 0) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Возникла ошибка проверки значения")
                    .addPropertyNode(annotation.property())
                    .addConstraintViolation();
            return false;
        }
        return true;
    }

}
