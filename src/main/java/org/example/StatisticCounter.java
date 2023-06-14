package org.example;


import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StatisticCounter {






    public static void writeAllMonths() {
        for (Month month : Month.values()) {
            System.out.println(month);
        }
    }

    public static void writeAllDaysInYear2023(){
        writeAllDaysInYear(2023);
    }

    public static void writeAllDaysInYear(Integer year) {
        LocalDate startDate = LocalDate.of(year, 1, 1); // Первый день года
        LocalDate endDate = LocalDate.of(year, 12, 31); // Последний день года

        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            System.out.println(currentDate);
            currentDate = currentDate.plusDays(1); // Переход к следующему дню
        }
    }


    /**
     * @param year - список всех дней в году
     */
    public static List<LocalDate> generateDaysInYearList(Integer year) {
//        int year = 2023; // Год, для которого вы хотите вывести все дни
        LocalDate startDate = LocalDate.of(year, 1, 1); // Первый день года
        LocalDate endDate = LocalDate.of(year, 12, 31); // Последний день года

        LocalDate currentDate = startDate;
        Month currentMonth = null;
        List<LocalDate> listOfDays = new ArrayList<>();

        while (!currentDate.isAfter(endDate)) {
            listOfDays.add(currentDate);
            if (currentDate.getMonth() != currentMonth) {
                currentMonth = currentDate.getMonth();
                String monthName = currentMonth.getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault());
                System.out.println(monthName);
            }

            System.out.println(currentDate.getDayOfMonth());

            currentDate = currentDate.plusDays(1); // Переход к следующему дню
        }

        return listOfDays;
    }
}
