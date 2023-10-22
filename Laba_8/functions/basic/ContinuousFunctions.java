package functions.basic;

import functions.Function;

/**
 * Класс описывает бесконечно дифференцируемые функции определённые на промежутке (-inf, +inf)
 */
public class ContinuousFunctions implements Function {
    @Override
    public double getLeftDomainBorder() {
        return Double.NEGATIVE_INFINITY;
    }
    @Override
    public double getRightDomainBorder() {
        return Double.POSITIVE_INFINITY;
    }
    @Override
    public double getFunctionValue(double x) {
        return 0.;
    }
}
