package functions.meta;

import functions.Function;

/**
 * Класс для описания сдвига функции вдоль осей абсцисс и ординат
 */
public class Shift implements Function {
    private Function f1;
    double shiftX, shiftY;
    public Shift(Function function_1, double scaleX, double scaleY) {
        this.f1 = function_1;
        this.shiftX = scaleX;
        this.shiftY = scaleY;
    }
    @Override
    public double getLeftDomainBorder() {
        return this.f1.getRightDomainBorder() + this.shiftX;
    }
    @Override
    public double getRightDomainBorder() {
        return this.f1.getLeftDomainBorder() + this.shiftX;
    }
    @Override
    public double getFunctionValue(double x) {
        return this.f1.getFunctionValue(x + this.shiftX) + this.shiftY;
    }
}
