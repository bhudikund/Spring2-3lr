package ru.fedorov.secondlab.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.fedorov.secondlab.exception.UnsupportedCodeException;
import ru.fedorov.secondlab.exception.ValidationFailedException;
@Slf4j
@Service
public class RequestValidationService implements ValidationService {

    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException {
        log.error("bindingResult: {}", bindingResult);
        if(bindingResult.hasErrors()){
            throw new
                    ValidationFailedException(bindingResult.getFieldError().toString());

        }
    }
}
