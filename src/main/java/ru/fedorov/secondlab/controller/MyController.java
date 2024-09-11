package ru.fedorov.secondlab.controller;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.fedorov.secondlab.exception.UnsupportedCodeException;
import ru.fedorov.secondlab.exception.ValidationFailedException;
import ru.fedorov.secondlab.model.*;
import ru.fedorov.secondlab.service.CodeExceptionService;
import ru.fedorov.secondlab.service.ModifyResponseService;
import ru.fedorov.secondlab.service.RequestCodeExceptionService;
import ru.fedorov.secondlab.service.ValidationService;
import ru.fedorov.secondlab.util.DateTimeUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
@Slf4j
@RestController
public class MyController {

    private final ValidationService validationService;
    private final CodeExceptionService codeExceptionService;
    private final ModifyResponseService modifyResponseService;

    @Autowired
    public MyController(ValidationService validationService, CodeExceptionService codeExceptionService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService){
        this.validationService = validationService;
        this.codeExceptionService = codeExceptionService;
        this.modifyResponseService = modifyResponseService;
    }



    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult){

        log.info("request: {}", request);


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();

        log.info("response: {}", response);

        try {
            validationService.isValid(bindingResult);
            codeExceptionService.isSupported(request);
        }catch (ValidationFailedException e){
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (UnsupportedCodeException e){
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTIO);
            response.setErrorMessage(ErrorMessages.UNSUPPORTED);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
