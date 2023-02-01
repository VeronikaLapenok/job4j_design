package ru.job4j.ood.isp;

/**
 * Нарушение принципа разделения интерфейсов. Необходимо разделить интерфейсы
 * по видам деятельности
 */
public interface Job {
    public void teach();

    public void drive();

    public void sell();
}
