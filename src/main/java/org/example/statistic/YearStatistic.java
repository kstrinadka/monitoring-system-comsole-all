package org.example.statistic;


import java.util.List;

/**
 * Класс для хранения и подсчета статистики за год
 */
public class YearStatistic {

    private String yearName;
    private List<MonthStatistic> monthStatisticList;
    private Integer outOfStockDays;
    private Integer outOfStockNumber;


    public YearStatistic(String yearName, List<MonthStatistic> monthStatisticList) {
        this.yearName = yearName;
        this.monthStatisticList = monthStatisticList;
        this.calculateStatistic();
    }

    private void calculateStatistic() {
        this.outOfStockDays = 0;
        this.outOfStockNumber = 0;
        for (MonthStatistic month: monthStatisticList) {
            if (month.getOutOfStockNumber() > 0) {
                this.outOfStockNumber += month.getOutOfStockNumber();
                this.outOfStockDays += month.getOutOfStockDays();
            }
        }
    }

    public String getYearName() {
        return yearName;
    }

    public List<MonthStatistic> getMonthStatisticList() {
        return monthStatisticList;
    }

    public Integer getOutOfStockDays() {
        return outOfStockDays;
    }

    public Integer getOutOfStockNumber() {
        return outOfStockNumber;
    }

    @Override
    public String toString() {
        return "YearStatistic{" +
                "yearName='" + yearName + '\'' +
                ", outOfStockDays=" + outOfStockDays +
                ", outOfStockNumber=" + outOfStockNumber +
                '}';
    }
}
