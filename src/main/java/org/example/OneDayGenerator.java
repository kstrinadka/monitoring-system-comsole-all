package org.example;


import java.util.Random;

/**
 * Генерирует случайное число (количество продаж в день)
 */
public class OneDayGenerator {

    private final Integer period = 3;             // задает промежуток для генерации дополнительного количества продаж (раз в period дней)
    private Integer counter;                // счетчик, который нужнен, чтобы каждые period дней генерировать большее случайное число
    private final Random randomGenerator;         // штука, которая генерирует случайные числа
    private Integer lowerBound = 2;         // нижняя граница случайного числа
    private Integer higherBound = 4;        // верхняя граница случайного числа


    /**
     * Конструктор генератора продаж с дефолтными значениями границ генерации продаж
     */
    public OneDayGenerator () {
        this.counter = 0;
        this.randomGenerator = new Random();
    }

    /**
     * Конструктор генератора продаж, в котором можно указать границы генерации продаж в день
     * @param lowerBound - нижняя граница
     * @param higherBound - верхняя граница
     */
    public OneDayGenerator(Integer lowerBound, Integer higherBound) {
        this.counter = 0;
        this.randomGenerator =  new Random();
        this.lowerBound = lowerBound;
        this.higherBound = higherBound;
    }

    /**
     * Главный метод, который возвращает количество продаж для дня
     */
    public Integer generateNumberOfSales() {
        Integer numberOfSales = this.generateRandomNumber();
        if (this.needMoreSales()) {
            numberOfSales = numberOfSales + this.generateRandomNumber();
        }
        this.counter ++;
        return numberOfSales;
    }

    /**
     * Проверяет нужны ли в этот раз дополнительные продажи (раз в period дней выдает true)
     */
    private boolean needMoreSales() {
        return this.counter % this.period == 0;
    }

    /**
     * @return - Случайное целое число в диапазоне [lowerBound, higherBound]
     */
    private Integer generateRandomNumber() {
        Integer range = this.higherBound - this.lowerBound + 1;
        return this.randomGenerator.nextInt(range) + this.lowerBound;
    }


}
