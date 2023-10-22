import functions.*;
import functions.basic.*;
import functions.meta.*;
import threads.*;
import java.io.*;
import java.util.Iterator;
import java.util.Random;

class Main_8 {

    /*
    public static void Array_tests(){
        // конструкторы
        ArrayTabulatedFunction f2 = new ArrayTabulatedFunction(0, 1, 10);
        for (int i = 0; i < f2.getPointsCount(); i++) {
            System.out.println(f2.getPointX(i) + " " + f2.getFunctionValue(f2.getPointX(i)));
        }
        double[] arr = {1., 2., 3., 4., 5., 6., 7., 8., 9., 10.};
        ArrayTabulatedFunction f = new ArrayTabulatedFunction(1, 10, arr);
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
        f.setPoint(0, new FunctionPoint(-2, 5));
        for (int i = 0; i < 3; i++) {
            System.out.println(f.getPointX(i) + " " + f.getFunctionValue(f.getPointX(i)));
        }
        // исключение
        f.setPoint(1, new FunctionPoint(-3, 5));
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
        ArrayTabulatedFunction f1 = new ArrayTabulatedFunction(1, 10, arr);
        // удаление
        f1.deletePoint(5);
        System.out.println("deletePoint(5)");
        for (int i = 0; i < f1.getPointsCount(); i++) {
            System.out.println(f1.getPointX(i) + " " + f1.getFunctionValue(f1.getPointX(i)));
        }
        // выброс исключений для удаления
        f1.deletePoint(15);
        ArrayTabulatedFunction f3 = new ArrayTabulatedFunction(1, 10, 2);
        f3.deletePoint(3);
        //
        f1.addPoint(new FunctionPoint(5, 5));
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
        ArrayTabulatedFunction f = new ArrayTabulatedFunction(1, 10, arr);
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
        f.setPoint(0, new FunctionPoint(-2, 5));
        for (int i = 0; i < 3; i++) {
            System.out.println(f.getPointX(i) + " " + f.getFunctionValue(f.getPointX(i)));
        }
        // исключение
        f.setPoint(1, new FunctionPoint(-3, 5));
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
        ArrayTabulatedFunction f1 = new ArrayTabulatedFunction(1, 10, arr);
        // удаление
        f1.deletePoint(5);
        System.out.println("deletePoint(5)");
        for (int i = 0; i < f1.getPointsCount(); i++) {
            System.out.println(f1.getPointX(i) + " " + f1.getFunctionValue(f1.getPointX(i)));
        }
        // выброс исключений для удаления
        f1.deletePoint(15);
        ArrayTabulatedFunction f3 = new ArrayTabulatedFunction(1, 10, 2);
        f3.deletePoint(3);
        //
        f1.addPoint(new FunctionPoint(5, 5));
        System.out.println("addPoint(new FunctionPoint_2(5, 5))");
        for (int i = 0; i < f1.getPointsCount(); i++) {
            System.out.println(f1.getPointX(i) + " " + f1.getFunctionValue(f1.getPointX(i)));
        }
    }
    */

    /*
    public static void interface_tests(){
        //
        TabulatedFunction tCos, tSin;
        Cos cos;
        Sin sin;
        sin = new Sin();
        System.out.println("sin");
        for (double x = 0; x <= 2 * Math.PI; x += 0.1)
            System.out.println("x = " + x + " y =  " + sin.getFunctionValue(x));
        cos = new Cos();
        System.out.println("cos");
        for (double x = 0; x <= 2 * Math.PI; x += 0.1)
            System.out.println("x = " + x + " y =  " + cos.getFunctionValue(x));
        tSin = TabulatedFunctions.tabulate(sin, 0, 2 * Math.PI, 10);
        tCos = TabulatedFunctions.tabulate(cos, 0, 2 * Math.PI, 10);
        System.out.println("tabulated_sin");
        for (double x = 0; x <= 2 * Math.PI; x += 0.1)
            System.out.println("x = " + x + " y =  " + tSin.getFunctionValue(x));
        System.out.println("tabulated_cos");
        for (double x = 0; x <= 2 * Math.PI; x += 0.1)
            System.out.println("x = " + x + " y =  " + tCos.getFunctionValue(x));
        //
        Function sum = Functions.sum(Functions.mult(tSin, tSin), Functions.mult(tCos, tCos));
        System.out.println("========================" + "sum" + "=========================");
        for (double x = 0; x <= 2 * Math.PI; x += 0.1)
            System.out.println("x = " + x + " y =  " + sum.getFunctionValue(x));
        //
        Exp exp = new Exp();
        TabulatedFunction tExp = TabulatedFunctions.tabulate(exp, 0, 10, 11);
        FileWriter out = new FileWriter("exp.txt");
        TabulatedFunctions.writeTabulatedFunction(tExp, out);
        out.flush();
        out.close();
        //
        FileReader in = new FileReader("exp.txt");
        TabulatedFunction tExp1 = TabulatedFunctions.readTabulatedFunction(in);
        in.close();
        System.out.println("========================" + "exp" + "=========================");
        for (int i = 0; i < 11; i++) {
            System.out.println("x = " + i + " y =  " + exp.getFunctionValue(i));
        }
        System.out.println("========================" + "tabulated_exp" + "=========================");
        for (int x = 0; x < 11; x++)
            System.out.println("x = " + x + " y =  " + tExp1.getFunctionValue(x));
        //
        Log ln = new Log(Math.E);
        TabulatedFunction tLn = TabulatedFunctions.tabulate(ln, 0, 10, 11);
        OutputStream output = new FileOutputStream("log.txt");
        TabulatedFunctions.outputTabulatedFunction(tLn, output);
        output.flush();
        output.close();
        //
        InputStream in_ln = new FileInputStream("log.txt");
        TabulatedFunction tLn1 = TabulatedFunctions.inputTabulatedFunction(in_ln);
        in_ln.close();
        System.out.println("========================" + "log" + "=========================");
        for (int i = 0; i < 11; i++)
            System.out.println("x = " + i + " y =  " + ln.getFunctionValue(i));
        System.out.println("========================" + "tabulated_log" + "=========================");
        for (int x = 0; x < 11; x++)
            System.out.println("x = " + x + " y =  " + tLn1.getFunctionValue(x));
        //
        Log ln2 = new Log(Math.E);
        Exp exp2 = new Exp();
        Function f = Functions.composition(ln2, exp2);
        TabulatedFunction tF = TabulatedFunctions.tabulate(f, 0, 10, 11);
        System.out.println("========================" + "ln(e^x)" + "=========================");
        for (int x = 0; x < 11; x++)
            System.out.println("x = " + x + " y =  " + tF.getFunctionValue(x));

        FileOutputStream output2 = new FileOutputStream("ln_exp.txt");
        ObjectOutputStream serial = new ObjectOutputStream(output2);
        serial.writeObject(tF);
        serial.close();
        FileInputStream input2 = new FileInputStream("ln_exp.txt");
        ObjectInputStream deserial = new ObjectInputStream(input2);
        TabulatedFunction tF1 = (TabulatedFunction) deserial.readObject();
        deserial.close();
        System.out.println("========================" + "ln(e^x) after deserialization" + "=========================");
        for (int x = 0; x < 11; x++)
            System.out.println("x = " + x + " y =  " + tF1.getFunctionValue(x));
        //
    }
     */

    /*public static void tests_5_laba(){
        double[] arr = {1., 2., 3., 4., 5., 6., 7., 8., 9., 10.};
        ArrayTabulatedFunction f1 = new ArrayTabulatedFunction(1, 10,arr);
        System.out.println("ArrayTabulatedFunction:\n" + f1.toString());
        LinkedListTabulatedFunction f2 = new LinkedListTabulatedFunction(1, 10,arr);
        System.out.println("LinkedListTabulatedFunction:\n" + f2.toString());
        System.out.println("ArrayTabulatedFunction.equals(LinkedListTabulatedFunction): " + f1.equals(f2));
        System.out.println("ArrayTabulatedFunction.equals(LinkedListTabulatedFunction) reverse: " + f2.equals(f1));
        LinkedListTabulatedFunction f3 = new LinkedListTabulatedFunction(1, 9,arr);
        System.out.println("ArrayTabulatedFunction.equals(LinkedListTabulatedFunction): " + f1.equals(f3));
        System.out.println("ArrayTabulatedFunction.equals(LinkedListTabulatedFunction) reverse: " + f3.equals(f1));
        System.out.println("hashCode f1 " + f1.hashCode());
        System.out.println("hashCode f2 " + f2.hashCode());
        System.out.println("hashCode f3 " + f3.hashCode());
        double[] arr1 = {1.001, 2., 3., 4., 5., 6., 7., 8., 9., 10.};
        ArrayTabulatedFunction f4 = new ArrayTabulatedFunction(1, 10,arr1);
        System.out.println("hashCode f4 " + f4.hashCode());
        ArrayTabulatedFunction f5 = (ArrayTabulatedFunction) f1.clone();
        f1.deletePoint(5);
        System.out.println("ArrayTabulatedFunction:\n" + f1.toString());
        System.out.println("ArrayTabulatedFunction:\n" + f5.toString());
    }
     */

    /*public static void nonThread() {
        Task t = new Task(100);
        int i = 0;
        Random random = new Random();
        while(i < t.getTasks()){
            Log log = new Log(random.nextInt(9) + 1);
            int leftX = random.nextInt(100);
            int rightX = random.nextInt(100) + 100;
            double step = (double)1 / (random.nextDouble(1000000.) + 1.0);
            System.out.println("Source <" + leftX + "> <" + rightX + "> <" + step + ">");
            System.out.println("Result <" + leftX + "> <" + rightX + "> <" + step + "> <" + Functions.integral(log, leftX, rightX, step) + ">");
            i++;
        }
    }
    public static void simpleThread() {
        Task t = new Task(100);
        Thread generator_thread = new Thread(new SimpleGenerator(t));
        generator_thread.start();
        Thread integrator_thread = new Thread(new SimpleIntegrator(t));
        integrator_thread.start();
    }

    public static void complicatedThreads() throws InterruptedException {
        Task t = new Task(100);
        Semaphore semaphore = new Semaphore();
        Thread generator = new Generator(t, semaphore);
        generator.start();

        Thread integrator = new Integrator(t, semaphore);
        System.out.println("Generator priority = " + generator.getPriority());
        System.out.println("Integrator priority = " + integrator.getPriority());
        integrator.start();
        Thread.sleep(50);
        generator.interrupt();
        integrator.interrupt();
    }

    public static void 7_laba(){
        Exp exp = new Exp();
        // 1,7182818284590452353602874713527 интеграл от e^x от 0 до 1
        System.out.println(Functions.integral(exp, 0, 1, 0.00000001));
        //nonThread();
        //simpleThread();
        try {
            complicatedThreads();
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
     */

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        double[] arr = {1., 2., 3., 4., 5., 6., 7., 8., 9., 10.};
        System.out.println("ArrayTabulatedFunction");
        ArrayTabulatedFunction f1 = new ArrayTabulatedFunction(1, 10,arr);
        for(FunctionPoint point : f1) {
            System.out.println(point);
        }
        System.out.println("LinkedListTabulatedFunction");
        LinkedListTabulatedFunction f2 = new LinkedListTabulatedFunction(1, 10,arr);
        for(FunctionPoint point : f2) {
            System.out.println(point);
        }
        Iterator<FunctionPoint> it = f1.iterator();
        System.out.println(it);
        //
        Function f = new Cos();
        TabulatedFunction tf;
        tf = TabulatedFunctions.tabulate(f, 0, Math.PI, 11);
        System.out.println(tf.getClass());
        TabulatedFunctions.setTabulatedFunctionFactory(new LinkedListTabulatedFunction.LinkedListTabulatedFunctionFactory());
        tf = TabulatedFunctions.tabulate(f, 0, Math.PI, 11);
        System.out.println(tf.getClass());
        TabulatedFunctions.setTabulatedFunctionFactory(new ArrayTabulatedFunction.ArrayTabulatedFunctionFactory());
        TabulatedFunctions.tabulate(f, 0, Math.PI, 11);
        System.out.println(tf.getClass());
        //
        TabulatedFunction F;
        F = TabulatedFunctions.createTabulatedFunction(ArrayTabulatedFunction.class, 0, 10 , 3);
        System.out.println(F.getClass());
        System.out.println(F);
        F = TabulatedFunctions.createTabulatedFunction(ArrayTabulatedFunction.class, 0, 10 , new double[] {0, 10});
        System.out.println(F.getClass());
        System.out.println(F);
        F = TabulatedFunctions.createTabulatedFunction(LinkedListTabulatedFunction.class, new FunctionPoint[]{
                        new FunctionPoint(0, 0),
                        new FunctionPoint(10, 10)
                }
        );
        System.out.println(F.getClass());
        System.out.println(F);
        F = TabulatedFunctions.tabulate(LinkedListTabulatedFunction.class, new Sin(), 0, Math.PI, 11);
        System.out.println(F.getClass());
        System.out.println(F);
    }
}