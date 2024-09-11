package ru.fedorov.secondlab.service;

import org.springframework.stereotype.Service;
import ru.fedorov.secondlab.model.Response;
@Service
public interface ModifyResponseService {

    Response modify(Response response);
}
