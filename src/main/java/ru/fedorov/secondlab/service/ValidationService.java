package ru.fedorov.secondlab.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.fedorov.secondlab.exception.ValidationFailedException;

@Service
public interface ValidationService {

    void isValid(BindingResult bindingResult) throws ValidationFailedException;

}
