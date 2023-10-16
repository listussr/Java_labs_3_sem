package functions.basic;

/**
 * Класс описывает функцию экспоненты
 */
public class Exp extends ContinuousFunctions {
    @Override
    public double getFunctionValue(double x) {
        return Math.exp(x);
    }
}
