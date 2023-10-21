import functions.*;
class Main{
    public static void main(String[] args) {
        TabulatedFunction function = new TabulatedFunction(0, 1, 10);
        for (int i = 0; i < function.getPointsCount(); i++) {
            System.out.println(function.getPointX(i) + " " + function.getFunctionValue(function.getPointX(i)));
        }
        double [] arr = {1., 2., 3., 4., 5., 6., 7., 8., 9., 10.};
        TabulatedFunction function1 = new TabulatedFunction(1, 10, arr);
        for (int i = 0; i < function1.getPointsCount(); i++) {
            System.out.println(function1.getPointX(i) + " " + function1.getFunctionValue(function1.getPointX(i)));
        }
    }
}