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
    private Integer soldCount;              // сколько продано товара за месяц
    private Integer price = 150;            // цена товара

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
        this.price = dayStatisticList.get(0).getPrice();
        this.soldCount = 0;
        for (DayStatistic day: dayStatisticList) {
            this.soldCount += day.getSoldCount();
            if (day.getWantTobuy() > 0) {
                this.outOfStockNumber += day.getWantTobuy();
                this.outOfStockDays += 1;
            }
        }
    }

    /**
     * Получить сумму продаж за текущий месяц
     */
    public Integer getSalesSum() {
        return this.soldCount * this.price;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getSoldCount() {
        return soldCount;
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
