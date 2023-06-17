package org.example;

import org.example.statistic.DayStatistic;
import org.example.statistic.MonthStatistic;
import org.example.statistic.ResultStatisticWriter;
import org.example.statistic.YearStatistic;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Integer year = 2023;
        String yearString = year.toString();

        // создали список всех дней в году
        List<LocalDate> listOfDays = DaysListGenerator.generateDaysInYearList(2023);

        // создали генератор будет создавать нашу статистику
        YearStatisticGenerator yearStatisticGenerator = new YearStatisticGenerator();

        // создали статистику на все дни в году
        List<DayStatistic> allDaysStatisticList = yearStatisticGenerator.generateAllDaysStatisticList(listOfDays);

        // создали статистику по месяцам из статистики на все дни в году
        List<MonthStatistic> allMonthsStatisticList = yearStatisticGenerator.generateAllMonthsStatisticList(allDaysStatisticList);

        // создали статистику за год из статистики за все месяца
        YearStatistic yearStatistic1 = yearStatisticGenerator.generateYearStatistic(allMonthsStatisticList, yearString);

        // печатаем статистику
        ResultStatisticWriter resultStatisticWriter = new ResultStatisticWriter(yearStatistic1);
        resultStatisticWriter.writeAllStatistic();

    }
}
