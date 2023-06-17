package org.example.statistic;

import java.util.List;

/**
 * Класс для хранения и подсчета статистики за месяц
 */
public class MonthStatistic {
    private String monthName;
    private List<DayStatistic> dayStatisticList;
    private Integer outOfStockDays;
    private Integer outOfStockNumber;

    public MonthStatistic(String monthName, List<DayStatistic> dayStatisticList) {
        this.monthName = monthName;
        this.dayStatisticList = dayStatisticList;
        this.calculateStatistic();
    }

    public String getMonthName() {
        return monthName;
    }

    public Integer getOutOfStockDays() {
        return outOfStockDays;
    }

    public Integer getOutOfStockNumber() {
        return outOfStockNumber;
    }

    public List<DayStatistic> getDayStatisticList() {
        return dayStatisticList;
    }

    private void calculateStatistic() {
        this.outOfStockDays = 0;
        this.outOfStockNumber = 0;
        for (DayStatistic day: dayStatisticList) {
            if (day.getWantTobuy() > 0) {
                this.outOfStockNumber += day.getWantTobuy();
                this.outOfStockDays += 1;
            }
        }
    }

    @Override
    public String toString() {
        return "MonthStatistic{" +
                "monthName='" + monthName + '\'' +
                ", outOfStockDays=" + outOfStockDays +
                ", outOfStockNumber=" + outOfStockNumber +
                '}';
    }
}
