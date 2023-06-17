package org.example;

import org.example.statistic.DayStatistic;
import org.example.statistic.MonthStatistic;
import org.example.statistic.YearStatistic;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Генерирует статистику по дням за целый год
 */
public class YearStatisticGenerator {
    private Integer rest = 0;           // количество остатка товара на данный момент

    private OneDayStatisticGenerator oneDayStatisticGenerator;      //штука, которая будет генерировать число продаж в день (случайное число генерирует)


    /**
     * Конструктор, который создает этот генератор статистики (внутри еще создается генератор случайных чисел для продаж)
     */
    public YearStatisticGenerator() {
        this.oneDayStatisticGenerator = new OneDayStatisticGenerator();
    }

    /**
     * @param days - список всех дней в году
     * @return - статистика на все дни в году
     */
    public List<DayStatistic> generateAllDaysStatisticList(List<LocalDate> days) {
        List<DayStatistic> dayStatisticList = new ArrayList<>();
        Month currentMonth = null;

        for (LocalDate day: days) {
            if (day.getMonth() != currentMonth) {
                currentMonth = day.getMonth();
                this.rest += 100;
            }

            DayStatistic currentDay = generateDayStatistic(day);
            dayStatisticList.add(currentDay);
        }
        return dayStatisticList;
    }

    /**
     * @param dayStatisticList - статистика за все дни в году
     * @return - статистика по месяцам
     */
    public List<MonthStatistic> generateAllMonthsStatisticList(List<DayStatistic> dayStatisticList) {
        List<MonthStatistic> monthStatisticList = new ArrayList<>();
        Month currentMonth = dayStatisticList.get(0).getDay().getMonth();
        List<DayStatistic> currentMonthDays = new ArrayList<>();

        for (DayStatistic day: dayStatisticList) {
            if (day.getDay().getMonth() != currentMonth) {
                String monthName = currentMonth.getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault());
                MonthStatistic currentMonthStatistic = new MonthStatistic(monthName, currentMonthDays);
                monthStatisticList.add(currentMonthStatistic);
                currentMonthDays = new ArrayList<>();
                currentMonth = day.getDay().getMonth();
            }
            currentMonthDays.add(day);
        }

        String monthName = currentMonth.getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault());
        MonthStatistic currentMonthStatistic = new MonthStatistic(monthName, currentMonthDays);
        monthStatisticList.add(currentMonthStatistic);

        return monthStatisticList;
    }


    /**
     * Создает статистику на указанный день
     * @param day - текущий день
     * @return - статистика на текущий день
     */
    private DayStatistic generateDayStatistic(LocalDate day) {
        Integer todayNumberOfSales = oneDayStatisticGenerator.generateNumberOfSales();
        DayStatistic newDayStatistic = null;

        // если нет остатка на складе
        if (this.rest == 0) {
            newDayStatistic = new DayStatistic(day, 0, 0, todayNumberOfSales);
            return newDayStatistic;
        }

        // если хватает остатка на складе для заданного количества покупок
        if (this.rest >= todayNumberOfSales) {
            this.rest -= todayNumberOfSales;
            newDayStatistic = new DayStatistic(day, todayNumberOfSales, this.rest, 0);
            return newDayStatistic;
        }

        // если остаток есть, но его не хватает на заданное количество покупок
        if (this.rest < todayNumberOfSales) {
            Integer wantToBuy = todayNumberOfSales - this.rest;
            Integer soldCount = this.rest;
            this.rest -= soldCount;
            newDayStatistic = new DayStatistic(day, soldCount, this.rest, wantToBuy);
            return newDayStatistic;
        }

        return newDayStatistic;
    }


    /**
     * @param monthStatistics - статистика по месяцам
     * @param yearName - название года (по сути число)
     * @return - статистика за год
     */
    public YearStatistic generateYearStatistic(List<MonthStatistic> monthStatistics, String yearName) {
        YearStatistic yearStatistic = new YearStatistic(yearName, monthStatistics);
        return yearStatistic;
    }
}
