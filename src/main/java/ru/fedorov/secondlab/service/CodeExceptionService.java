package ru.fedorov.secondlab.service;


import org.springframework.stereotype.Service;
import ru.fedorov.secondlab.exception.UnsupportedCodeException;
import ru.fedorov.secondlab.model.Request;
import ru.fedorov.secondlab.model.Response;

@Service
public interface CodeExceptionService {

        void isSupported(Request request) throws UnsupportedCodeException;

}
