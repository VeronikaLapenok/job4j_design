package ru.job4j.solid.srp;

/*
Из этого класса следует убрать методы calculateFee() и save(), т.к. они нарушают принцип
единственной ответственности. Класс Book предназначен для описания сущности и сюда можно добавить
только геттеры, сеттеры, equals, hashcode и toString
 */
public class Book {
    private String title;
    private String author;
    private int weight;

    public void calculateFee() {

    }

    public void save() {

    }
}
