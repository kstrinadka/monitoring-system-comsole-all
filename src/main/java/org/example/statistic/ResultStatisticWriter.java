package org.example.statistic;


/**
 * Класс, который будет красиво выводить результат в консоль
 */
public class ResultStatisticWriter {

    private YearStatistic yearStatistic;

    public ResultStatisticWriter(YearStatistic yearStatistic) {
        this.yearStatistic = yearStatistic;
    }

    /**
     * Распечатывает всю статистику
     */
    public void writeAllStatistic() {
        writeYearStatistic();
    }


    /**
     * Печатает статистику за год
     */
    public void writeYearStatistic() {
        System.out.println();
        System.out.println("Статистика за " + yearStatistic.getYearName() + " год: ");
        System.out.println("Цена товара: " + yearStatistic.getPrice() + " руб");
        System.out.println("Сумма продаж за год: " + yearStatistic.getSalesSum() + " руб");
        System.out.println("Количество out of stock дней за год: " + yearStatistic.getOutOfStockDays());
        System.out.println("Количество out of stock непроданных товаров за год: " + yearStatistic.getOutOfStockNumber());
        System.out.println("Сумма цены на по out of stock товарам: " + yearStatistic.getPrice() * yearStatistic.getOutOfStockNumber() + " руб");

        for (MonthStatistic month: yearStatistic.getMonthStatisticList()) {
            writeMonthStatistic(month);
        }
    }

    /**
     * Печатает статистику за месяц
     */
    public void writeMonthStatistic(MonthStatistic month) {
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Статистика за " + month.getMonthName() + " месяц: ");
        System.out.println("Количество out of stock дней за месяц: " + month.getOutOfStockDays());
        System.out.println("Количество out of stock непроданных товаров за год: " + month.getOutOfStockNumber() + ".");

        for (DayStatistic day: month.getDayStatisticList()) {
            this.writeDayStatistic(day);
        }
    }

    /**
     * Печатает статистику за день
     */
    public void writeDayStatistic(DayStatistic day) {
        System.out.println();
        System.out.println("Статистика за " + day.getDay().toString() + " день: ");
//        System.out.println("Продано единиц товара: " + day.getSoldCount() +
//                ". Остаток товара на конец дня " + day.getRest() +
//                ". Не получилось продать из-за того, что товар закончился на остатке: " + day.getWantTobuy() + ".");

        System.out.println("    Продано единиц товара: " + day.getSoldCount() + ".");
        System.out.println("    Остаток товара на конец дня: " + day.getRest()  + ".");
        System.out.println("    Не получилось продать из-за того, что товар закончился на остатке: " + day.getWantTobuy() + ".");
    }
}
