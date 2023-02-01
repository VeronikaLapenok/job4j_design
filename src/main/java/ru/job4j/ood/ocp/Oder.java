package ru.job4j.ood.ocp;

import java.time.format.DateTimeFormatter;

/**
 * Нарушение принципа открытости закрытости в том, что жёстко задан
 * формат даты, который впоследствии может измениться
 */
public class Oder {
    private String userName;
    private String good;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy");
}
