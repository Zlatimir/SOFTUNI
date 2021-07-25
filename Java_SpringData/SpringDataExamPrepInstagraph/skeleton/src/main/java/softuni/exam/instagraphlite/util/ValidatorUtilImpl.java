package softuni.exam.instagraphlite.util;

import org.springframework.stereotype.Component;
import softuni.exam.instagraphlite.repository.PictureRepository;

import javax.validation.Validation;
import javax.validation.Validator;

@Component
public class ValidatorUtilImpl implements ValidatorUtil {

    private final PictureRepository pictureRepository;

    public ValidatorUtilImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public <T> boolean isValid(T entity) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        return validator.validate(entity).isEmpty();

    }
}
