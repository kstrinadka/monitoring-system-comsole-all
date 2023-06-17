package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DaysListGenerator {

    /**
     * Создает список всех дней в году
     * @param year - список всех дней в году
     */
    public static List<LocalDate> generateDaysInYearList(Integer year) {
        LocalDate startDate = LocalDate.of(year, 1, 1); // Первый день года
        LocalDate endDate = LocalDate.of(year, 12, 31); // Последний день года
        LocalDate currentDate = startDate;
        List<LocalDate> listOfDays = new ArrayList<>();
        while (!currentDate.isAfter(endDate)) {
            listOfDays.add(currentDate);
            currentDate = currentDate.plusDays(1); // Переход к следующему дню
        }
        return listOfDays;
    }
}
