import functions.*;
class Main_3 {

    public static void Array_tests(){
        // конструкторы
        ArrayTabulatedFunction_3 f2 = new ArrayTabulatedFunction_3(0, 1, 10);
        for (int i = 0; i < f2.getPointsCount(); i++) {
            System.out.println(f2.getPointX(i) + " " + f2.getFunctionValue(f2.getPointX(i)));
        }
        double[] arr = {1., 2., 3., 4., 5., 6., 7., 8., 9., 10.};
        ArrayTabulatedFunction_3 f = new ArrayTabulatedFunction_3(1, 10, arr);
        // границы
        System.out.println("Left domain border: " + f.getLeftDomainBorder());
        System.out.println("Right domain border: " + f.getRightDomainBorder());
        //
        for (int i = 0; i < f.getPointsCount(); i++) {
            System.out.println(f.getPointX(i) + " " + f.getFunctionValue(f.getPointX(i)));
        }
        //
        System.out.println("Number of points: " + f.getPointsCount());
        System.out.println("Function value in preimage set(x=5): " + f.getFunctionValue(5));
        System.out.println("Function value out of the preimage set(x=5.5): " + f.getFunctionValue(5.5));
        //
        System.out.println("GetPoint by index: " + f.getPoint(1));
        // исключение
        System.out.println("GetPoint by index: " + f.getPoint(15));
        //
        f.setPoint(0, new FunctionPoint_3(-2, 5));
        for (int i = 0; i < 3; i++) {
            System.out.println(f.getPointX(i) + " " + f.getFunctionValue(f.getPointX(i)));
        }
        // исключение
        f.setPoint(1, new FunctionPoint_3(-3, 5));
        for (int i = 0; i < 3; i++) {
            System.out.println(f.getPointX(i) + " " + f.getFunctionValue(f.getPointX(i)));
        }
        //
        System.out.println(("GetPointX by index(1): " + f.getPointX(1)));
        System.out.println(("GetPointY by index(0): " + f.getPointY(0)));
        // исключения
        System.out.println(("GetPointX by index(1): " + f.getPointX(-1)));
        System.out.println(("GetPointY by index(0): " + f.getPointY(15)));
        //
        f.setPointX(5, 1);
        f.setPointX(6, 6.5);
        // исключение
        f.setPointY(5, 1);
        //
        for (int i = 0; i < f.getPointsCount(); i++) {
            System.out.println(f.getPointX(i) + " " + f.getFunctionValue(f.getPointX(i)));
        }
        ArrayTabulatedFunction_3 f1 = new ArrayTabulatedFunction_3(1, 10, arr);
        // удаление
        f1.deletePoint(5);
        System.out.println("deletePoint(5)");
        for (int i = 0; i < f1.getPointsCount(); i++) {
            System.out.println(f1.getPointX(i) + " " + f1.getFunctionValue(f1.getPointX(i)));
        }
        // выброс исключений для удаления
        f1.deletePoint(15);
        ArrayTabulatedFunction_3 f3 = new ArrayTabulatedFunction_3(1, 10, 2);
        f3.deletePoint(3);
        //
        f1.addPoint(new FunctionPoint_3(5, 5));
        System.out.println("addPoint(new FunctionPoint_2(5, 5))");
        for (int i = 0; i < f1.getPointsCount(); i++) {
            System.out.println(f1.getPointX(i) + " " + f1.getFunctionValue(f1.getPointX(i)));
        }
    }

    public static void List_tests(){
        // конструкторы
        LinkedListTabulatedFunction f2 = new LinkedListTabulatedFunction(1., 10., 10);
        for (int i = 0; i < f2.getPointsCount(); i++) {
            System.out.println(f2.getPointX(i) + " " + f2.getFunctionValue(f2.getPointX(i)));
        }
        double[] arr = {1., 2., 3., 4., 5., 6., 7., 8., 9., 10.};
        ArrayTabulatedFunction_3 f = new ArrayTabulatedFunction_3(1, 10, arr);
        // границы
        System.out.println("Left domain border: " + f.getLeftDomainBorder());
        System.out.println("Right domain border: " + f.getRightDomainBorder());
        //
        for (int i = 0; i < f.getPointsCount(); i++) {
            System.out.println(f.getPointX(i) + " " + f.getFunctionValue(f.getPointX(i)));
        }
        //
        System.out.println("Number of points: " + f.getPointsCount());
        System.out.println("Function value in preimage set(x=5): " + f.getFunctionValue(5));
        System.out.println("Function value out of the preimage set(x=5.5): " + f.getFunctionValue(5.5));
        //
        System.out.println("GetPoint by index: " + f.getPoint(1));
        // исключение
        System.out.println("GetPoint by index: " + f.getPoint(15));
        //
        f.setPoint(0, new FunctionPoint_3(-2, 5));
        for (int i = 0; i < 3; i++) {
            System.out.println(f.getPointX(i) + " " + f.getFunctionValue(f.getPointX(i)));
        }
        // исключение
        f.setPoint(1, new FunctionPoint_3(-3, 5));
        for (int i = 0; i < 3; i++) {
            System.out.println(f.getPointX(i) + " " + f.getFunctionValue(f.getPointX(i)));
        }
        //
        System.out.println(("GetPointX by index(1): " + f.getPointX(1)));
        System.out.println(("GetPointY by index(0): " + f.getPointY(0)));
        // исключения
        System.out.println(("GetPointX by index(1): " + f.getPointX(-1)));
        System.out.println(("GetPointY by index(0): " + f.getPointY(15)));
        //
        f.setPointX(5, 1);
        f.setPointX(6, 6.5);
        // исключение
        f.setPointY(5, 1);
        //
        for (int i = 0; i < f.getPointsCount(); i++) {
            System.out.println(f.getPointX(i) + " " + f.getFunctionValue(f.getPointX(i)));
        }
        ArrayTabulatedFunction_3 f1 = new ArrayTabulatedFunction_3(1, 10, arr);
        // удаление
        f1.deletePoint(5);
        System.out.println("deletePoint(5)");
        for (int i = 0; i < f1.getPointsCount(); i++) {
            System.out.println(f1.getPointX(i) + " " + f1.getFunctionValue(f1.getPointX(i)));
        }
        // выброс исключений для удаления
        f1.deletePoint(15);
        ArrayTabulatedFunction_3 f3 = new ArrayTabulatedFunction_3(1, 10, 2);
        f3.deletePoint(3);
        //
        f1.addPoint(new FunctionPoint_3(5, 5));
        System.out.println("addPoint(new FunctionPoint_2(5, 5))");
        for (int i = 0; i < f1.getPointsCount(); i++) {
            System.out.println(f1.getPointX(i) + " " + f1.getFunctionValue(f1.getPointX(i)));
        }
    }
    public static void main(String[] args) {
        List_tests();

    }
}