package functions.meta;

import functions.Function;

/**
 * Класс для описания суммы двух функций
 */
public class Sum implements Function {
    private Function f1, f2;
    public Sum(Function function_1, Function function_2) {
        this.f1 = function_1;
        this.f2 = function_2;
    }
    @Override
    public double getLeftDomainBorder() {
        return Math.min(f1.getLeftDomainBorder(), f2.getLeftDomainBorder());
    }
    @Override
    public double getRightDomainBorder() {
        return Math.min(f1.getRightDomainBorder(), f2.getRightDomainBorder());
    }
    @Override
    public double getFunctionValue(double x) {
        return f1.getFunctionValue(x) + f2.getFunctionValue(x);
    }
}
