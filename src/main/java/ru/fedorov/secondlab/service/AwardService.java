package ru.fedorov.secondlab.service;

import org.springframework.stereotype.Service;
import ru.fedorov.secondlab.model.Positions;

@Service
public interface AwardService {
    double Award(Positions positions, double salary, double bonus, int workdays);
}
