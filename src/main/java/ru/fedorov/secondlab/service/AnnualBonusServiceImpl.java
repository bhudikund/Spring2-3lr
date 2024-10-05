package ru.fedorov.secondlab.service;

import org.springframework.stereotype.Service;
import ru.fedorov.secondlab.model.Positions;
import ru.fedorov.secondlab.model.Request;
import ru.fedorov.secondlab.util.DateTimeUtil;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;


@Service
public class AnnualBonusServiceImpl implements AnnualBonusService {


    @Override
    public double calculate(Positions positions, double salary, double bonus, int workDays,String systemTime) {
        int daysInYear = getYearDays(systemTime);
        return salary * bonus * daysInYear * positions.getPositionCoefficient() / workDays;
    }

    public int getYearDays(String systemTime) {

        Instant instant = Instant.parse(systemTime);

        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("UTC"));

        LocalDate localDate = zonedDateTime.toLocalDate();

        int daysInYear = localDate.lengthOfYear();

        return daysInYear;

    }
}
