package ru.job4j.ood.ocp;

/**
 * В этом классе прописан лимитированный список продуктов и единственный вариант начисления скидки.
 * Этим наришается принцип открытости/закрытости. Чтобы это исправить, следует определить отдельные
 * интерфейсы для любого вида продуктов, вида скидки и правил начисления скидки
 */
public class Store {
    public double sell(String product, double price, double amount) {
        return Math.round(makeDiscount(product) * price * amount);
    }

    public double makeDiscount(String product) {
        double discount;
        switch (product) {
            case "apple": discount = 0.95;
                    break;
            case "banana": discount = 0.54;
                    break;
            case "orange": discount = 0.78;
                    break;
            default:
                discount = 0;
        }
        return discount;
    }
}
