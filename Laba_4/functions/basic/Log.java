package functions.basic;

/**
 * Класс описывает функцию логарифма
 */
public class Log extends ContinuousFunctions {
    private final double base;
    public Log(double bx) {
        this.base = bx;
    }
    @Override
    public double getFunctionValue(double x) {
        return x > 0 ? Math.log(x) / Math.log(base) : Double.NaN;
    }

    @Override
    public double getLeftDomainBorder() {
        return 0;
    }
}
