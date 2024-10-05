package ru.fedorov.secondlab.service;

import org.springframework.stereotype.Service;
import ru.fedorov.secondlab.model.Positions;
@Service
public interface AnnualBonusService {
    double calculate(Positions positions, double salary, double bonus, int workDays, String systemTime);

}
