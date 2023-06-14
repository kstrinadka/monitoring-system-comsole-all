package org.example;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    private Constants() {} // Запрещаем создание объектов этого класса


    public final static Long DEFAULT_OUT_OF_STOCK_VALUE = 0L;

    public final static Long CORNICE_CATEGORY_ID = 1L;

    /**
     * Хранит начальное количество штук каждого из карнизов по артикулу
     */
    public static final Map<String, Long> CORNICE_INITIAL_QUANTITY_MAP = new HashMap<>() {{
        put("62392310", 12L);
        put("62392311", 6L);
        put("62392312", 26L);
        put("62392313", 13L);
        put("62392314", 3L);
    }};
}
