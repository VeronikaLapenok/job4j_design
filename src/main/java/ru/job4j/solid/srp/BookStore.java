package ru.job4j.solid.srp;

/*
Принцип единственной ответственности нарушает метод sendOrder(String customer, int bookId).
Его следует вынести в отдельный интерфейс, который будет описывать методы для работы
с доставкой товара.
 */
public interface BookStore {
    public void addBook(String title);

    public Book findBookById(int id);

    public void sendOrder(String customer, int bookId);
}
