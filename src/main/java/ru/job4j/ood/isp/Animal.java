package ru.job4j.ood.isp;

/**
 * Нарушение принципа разделения интерфейсов, т.к. не все животные могут
 * летать или бегать и, например при реализации этого интерфейса для тигра
 * метод fly() придется глушить
 */
public interface Animal {
    public void run();

    public void fly();

    public void swim();
}
