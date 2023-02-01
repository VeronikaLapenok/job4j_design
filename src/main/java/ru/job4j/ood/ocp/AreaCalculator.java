package ru.job4j.ood.ocp;

/**
 * Данный класс нарушает принцип открытости/закрытости, т.к. он не закыт для
 * модификации и с появлением новых видов фигур будет постоянно увеличиваться
 * и усложняться. Для исправления можно сначала описать интерфейс базовой фигуры
 * и потом реализовывать его для каждой фигуры отдельно
 */
public class AreaCalculator {
    public Double calculateRectangleArea(Rectangle rectangle) {
        return rectangle.getLength() * rectangle.getWidth();
    }

    public Double calculateCircleArea(Circle circle) {
        return (22 / 7) * Math.sqrt(circle.getRadius());
    }
}
