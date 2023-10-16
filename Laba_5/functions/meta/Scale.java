package functions.meta;

import functions.Function;

/**
 * Класс для описания сжатия и растяжения функции вдоль осей абсцисс и ординат
 */
public class Scale implements Function {
    private Function f1;
    double scaleX, scaleY;
    public Scale(Function function_1, double scaleX, double scaleY) {
        this.f1 = function_1;
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }
    @Override
    public double getLeftDomainBorder() {
        return this.f1.getRightDomainBorder() * this.scaleX;
    }
    @Override
    public double getRightDomainBorder() {
        return this.f1.getLeftDomainBorder() * this.scaleX;
    }
    @Override
    public double getFunctionValue(double x) {
        return this.f1.getFunctionValue(x) * this.scaleY;
    }
}
