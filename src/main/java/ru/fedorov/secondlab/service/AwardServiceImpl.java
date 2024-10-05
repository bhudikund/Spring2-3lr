package ru.fedorov.secondlab.service;

import org.springframework.stereotype.Service;
import ru.fedorov.secondlab.model.Positions;

@Service
public class AwardServiceImpl implements AwardService {

    public double Award(Positions positions, double salary, double bonus, int workdays){
        if (positions.isManager() == true){
            return positions.getPositionCoefficient() * 3 * salary * bonus / (workdays/4);
        }
        return 0;
    }
}
