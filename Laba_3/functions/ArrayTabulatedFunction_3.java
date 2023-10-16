package functions;

import java.util.Arrays;

public class ArrayTabulatedFunction_3 {
    private FunctionPoint_3[] points;

    public ArrayTabulatedFunction_3(){
        this.points = new FunctionPoint_3[1];
        this.points[0] = new FunctionPoint_3(0., 0.);
    }
    public ArrayTabulatedFunction_3(double leftX, double rightX, int pointCounts) {
        /*
         * Конструктор с параметрами в виде границ области определения функции и кол-ва точек, определенных в этой области
         */
        this.points = new FunctionPoint_3[pointCounts];
        double step = (rightX - leftX) / ((double)pointCounts - 1);
        for (int i = 0; i < pointCounts; i++) {
            points[i] = new FunctionPoint_3(leftX + i * step, 0.);
        }
    }
    public ArrayTabulatedFunction_3(double leftX, double rightX, double[] values) {
        /*
         * Конструктор с параметрами в виде границ области определения функции и значений функции в этой области
         */
        double step = (rightX - leftX) / ((double) values.length - 1);
        this.points = new FunctionPoint_3[values.length];
        for (int i = 0; i < values.length; ++i) {
            this.points[i] = new FunctionPoint_3(leftX + i * step, values[i]);
        }
    }

    public double getLeftDomainBorder(){
        /*
         * Возвращает левую границу области определения
         */
        return this.points[0].getX();
    }

    public double getRightDomainBorder(){
        /*
         * Возвращает правую границу области определения
         */
        return this.points[this.points.length - 1].getX();
    }

    public double getFunctionValue(double x){
        /*
         * Возвращает значение функции в точке, принадлежащей области определения
         */
        if((x > this.points[points.length - 1].getX()) || (x < this.points[0].getX()))
            return Double.NaN;
        int i = 0;
        for (; i < this.points.length; i++) {
            if(x == this.points[i].getX())
                return this.points[i].getY();
            else if (x < this.points[i].getX()) {
                break;
            }
        }
        /*
           f(x) = kx + b
           k = (y2 - y1) / (x2 - x1)
           b = y1 - k
         */
        double k = (this.points[i].getY() - this.points[i - 1].getY()) / (this.points[i].getX() - this.points[i - 1].getX());
        double b = (this.points[i].getY() - k * this.points[i].getX());
        return (k * x + b);
    }

    public int getPointsCount(){
        return this.points.length;
    }

    public FunctionPoint_3 getPoint(int index){
        try {
            if(index < 0 || index >= this.points.length)
                throw new FunctionPointIndexOutOfBoundsException("Точка с индексом " + index + " не найдена");
            return this.points[index];
        } catch (FunctionPointIndexOutOfBoundsException e) {
            System.out.print('\n' + e.getMessage() + '\n' + '\n');
            return null;
        }
    }

    public void setPoint(int index, FunctionPoint_3 point){
        /*
         Для функции, определяемой точками {(0; 0), (1; 1), (2; 4)}, точку с индексом 1 нельзя заменить точкой (-1; 5).
         Однако точку с индексом 0 уже можно заменить.
         */
        try {
            if (index == 0 && point.getX() <= this.points[index].getX()){
                this.points[index].setX(point.getX());
                this.points[index].setY(point.getY());
                return;
            }
            if(point.getX() < this.points[index - 1].getX() || point.getX() > this.points[index + 1].getX())
                throw new InappropriateFunctionPointException("Точка c абсциссой =" + point.getX() + " вне области определения");
            this.points[index] = new FunctionPoint_3(point.getX(), point.getY());
        } catch(InappropriateFunctionPointException e) {
            System.out.print('\n' + e.getMessage() + '\n' + '\n');
        }
    }

    public double getPointX(int index){
        try{
            if (index < 0 || index >= this.points.length)
                throw new FunctionPointIndexOutOfBoundsException("Точка с индексом " + index + " не найдена");
            return this.points[index].getX();
        } catch (FunctionPointIndexOutOfBoundsException e) {
            System.out.print('\n' + e.getMessage() + '\n' + '\n');
            return Double.NaN;
        }
    }

    public void setPointX(int index, double x){
        try {
            if (x < this.points[index - 1].getX() || x > this.points[index + 1].getX())
                throw new InappropriateFunctionPointException("Точка c абсциссой =" + x + " вне области определения");
            this.points[index].setX(x);
        }catch (InappropriateFunctionPointException e){
            System.out.print('\n' + e.getMessage() + '\n' + '\n');
        }
    }

    public double getPointY(int index){
        try {
            if (index < 0 || index >= this.points.length)
                throw new FunctionPointIndexOutOfBoundsException("Точка с индексом " + index + " не найдена");
            return this.points[index].getY();
        }catch (FunctionPointIndexOutOfBoundsException e){
            System.out.print('\n' + e.getMessage() + '\n' + '\n');
            return Double.NaN;
        }
    }

    public void setPointY(int index, double y){
        try {
            if(index < 0 || index >= this.points.length)
                throw new FunctionPointIndexOutOfBoundsException("Точка с индексом " + index + " не найдена");
            this.points[index].setY(y);
        } catch (FunctionPointIndexOutOfBoundsException e){
            System.out.print('\n' + e.getMessage() + '\n' + '\n');
        }
    }

    public void deletePoint(int index){
        try {
            if(this.points.length < 3){
                throw new IllegalStateException("Недостаточно точек для удаления");
            }
            else if (index > this.points.length - 1){
                throw new FunctionPointIndexOutOfBoundsException("Точка с индексом " + index + " не найдена и не может быть удалена");
            }
            if (index == 0){
                for (int i = 0; i < this.points.length - 1; i++) {
                    this.points[i] = this.points[i + 1];
                }
                return;
            }
            for (int i = index - 1; i < this.points.length - 1; i++) {
                this.points[i] = this.points[i + 1];
            }
            this.points[this.points.length - 1] = null;
            this.points = Arrays.copyOf(this.points, this.points.length - 1);
        } catch (Exception e) {
            System.out.print('\n' + e.getMessage() + '\n' + '\n');
        }
    }

    public void addPoint(FunctionPoint_3 point){
        FunctionPoint_3[] arr = new FunctionPoint_3[this.points.length + 1];
        int i = 0;
        while(point.getX() > this.points[i++].getX());
        System.arraycopy(this.points, 0, arr, 0, i - 1);
        arr[i - 1] = point;
        System.arraycopy(this.points, i - 1, arr, i, this.points.length - i + 1);
        this.points = arr;
        arr = null;
    }
}