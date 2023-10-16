package functions.basic;

/**
 * Класс описывает функцию косинуса
 */
public class Cos extends TrigonometricFunction {
    @Override
    public double getFunctionValue(double x) {
        return Math.cos(x);
    }
}