package ru.job4j.solid.srp;

/*
Kласс синглтона, помимо того чтобы выполнять свои непосредственные обязанности,
занимается еще и контролированием количества своих экземпляров, тем самым нарушая
принцип единственной ответственности
 */
public class Singleton {
    private static Singleton singletonObject;

    public Singleton() {
    }

    public static Singleton getInstance() {
        return null;
    }
}
