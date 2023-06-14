package org.example;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

//        StatisticCounter.writeAllDaysInYear(2023);

        List<LocalDate> listOfDays = StatisticCounter.generateDaysInYearList(2023);

        for (LocalDate day: listOfDays) {
            System.out.println(day);
        }
    }
}
