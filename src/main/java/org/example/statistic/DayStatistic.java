package org.example.statistic;


import java.time.LocalDate;

/**
 * Класс, который хранит необходимую за день информацию
 *
 * day - день, для которого записывается статистика
 * soldCount - количество проданных единиц товара в этот день
 * rest - количество остатка товара на данный день
 * wantToBuy - количество товара, которое хотели купить в этот день покупатели, но данный товар закончился на складе.
 */
public class DayStatistic {
    private LocalDate day;          // просто название дня (число)
    private Integer soldCount;      // сколько единиц товара купили в этот день
    private Integer rest;           // остаток в конце дня после продаж
    private Integer wantTobuy;      // сколько единиц товара хотели купить, но не купили, т.к. нет товара на остатке

    public DayStatistic(LocalDate day, Integer soldCount, Integer rest, Integer wantTobuy) {
        this.day = day;
        this.soldCount = soldCount;
        this.rest = rest;
        this.wantTobuy = wantTobuy;
    }

    public LocalDate getDay() {
        return day;
    }

    public Integer getSoldCount() {
        return soldCount;
    }

    public Integer getRest() {
        return rest;
    }

    public Integer getWantTobuy() {
        return wantTobuy;
    }

    @Override
    public String toString() {
        return "DayStatistic{" +
                "day=" + day +
                ", soldCount=" + soldCount +
                ", rest=" + rest +
                ", wantTobuy=" + wantTobuy +
                '}';
    }
}
