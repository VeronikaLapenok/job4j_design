package ru.job4j.solid.srp;

import java.time.format.DateTimeFormatter;

/*
Нарушение принципа единственной ответственности в том, что задан жёстко задан
формат даты, который впоследствии может измениться
 */
public class Order {
    private String userName;
    private Book book;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy");

}
