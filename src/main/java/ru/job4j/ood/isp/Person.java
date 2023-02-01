package ru.job4j.ood.isp;

/**
 * Нарушение принципа разделения интерфейсов, т.к. для человека каждой возрастной
 * группы лучше прописать свой интерфейс
 */
public interface Person {
    public void goesToKindergarten();

    public void study();

    public void work();

    public void retired();
}
