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
    public double calculate(Positions positions, double salary, double bonus, int workDays) {
        return salary * bonus * getYearDays() * positions.getPositionCoefficient() / workDays;
    }

    public int getYearDays() {
        Request request = new Request();
        System.out.println( request.getTime()+ " Vremya");
        Instant instant = Instant.parse(request.getSystemTime());
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("UTC"));
        LocalDate localDate = zonedDateTime.toLocalDate();

        int daysInYear = localDate.lengthOfYear();

        request.toString();

        System.out.println(daysInYear + " sfdsdwfaf");

        return 0;

    }
}
