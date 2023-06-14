package org.example;

import java.time.LocalDate;


/**
 * Класс, который хранит необходимую за день информацию
 * @param day - день, для которого записывается статистика
 * @param soldCount - количество проданных единиц товара в этот день
 * @param rest - количество остатка товара на данный день
 */
public record SoldDayStatistic(LocalDate day, Integer soldCount, Integer rest) {


    /**
     * Выводит в красивом удобном формате статистику за данный день
     */
    public void writeDayStatistic () {
        System.out.print("Статистика за " + day + ": ");
        System.out.print("Продано: " + soldCount + ", ");
        System.out.println("Остаток: " + rest);
    }
}
