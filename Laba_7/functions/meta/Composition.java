package functions.meta;

import functions.Function;

/**
 * Класс сложной для описания функции
 */
public class Composition implements Function {
    private Function f1;
    private Function f2;
    public Composition(Function function_1, Function function_2) {
        this.f1 = function_1;
        this.f2 = function_2;
    }
    @Override
    public double getLeftDomainBorder() {
        return this.f1.getLeftDomainBorder();
    }
    @Override
    public double getRightDomainBorder() {
        return this.f1.getRightDomainBorder();
    }
    @Override
    public double getFunctionValue(double x) {
        return this.f1.getFunctionValue(this.f2.getFunctionValue(x));
    }
}
