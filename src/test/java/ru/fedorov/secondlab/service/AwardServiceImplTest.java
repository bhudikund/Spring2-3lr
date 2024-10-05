package ru.fedorov.secondlab.service;

import org.junit.jupiter.api.Test;
import ru.fedorov.secondlab.model.Positions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AwardServiceImplTest {

    @Test
    void award() {
        Positions positions = Positions.TL;
        double bonus = 2.2;
        double salary = 100000;
        int workDays = 250;

        double result = new AwardServiceImpl().Award(positions, bonus, salary, workDays);

        double excpected = 27677.419354838716;

        assertThat(result).isEqualTo(excpected);

    }
}