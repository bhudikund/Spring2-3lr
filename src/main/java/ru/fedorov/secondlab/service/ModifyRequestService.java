package ru.fedorov.secondlab.service;


import org.springframework.stereotype.Service;
import ru.fedorov.secondlab.model.Request;

@Service
public interface ModifyRequestService {
    void modify(Request request);
}
