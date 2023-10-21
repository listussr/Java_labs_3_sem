package functions;

public class TabulatedFunction{
    private FunctionPoint points[];
    public TabulatedFunction(double leftX, double rightX, int pointCounts){

        //Создаём новый массив точек
        this.points = new FunctionPoint[pointCounts];
        //Высчитываем шаг изменения по x
        double step = (rightX - leftX) / ((double)pointCounts - 1);
        for (int i = 0; i < pointCounts; i++) {
            points[i] = new FunctionPoint(leftX + i * step, 0.);
        }
    }

    public TabulatedFunction(double leftX, double rightX, double[] values){
        //Создаём новый массив точек
        //tab_function = new TreeMap<FunctionPoint, Double>(pointCounts);
        double step = (rightX - leftX) / ((double)values.length - 1);
        this.points = new FunctionPoint[values.length];
        for (int i = 0; i < values.length; ++i) {
            this.points[i] = new FunctionPoint(leftX + i * step, values[i]);
        }
    }

    public double getLeftDomainBorder(){
        return this.points[0].getX();
    }

    public double getRightDomainBorder(){
        return this.points[this.points.length - 1].getX();
    }

    public double getFunctionValue(double x){
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
        /**
           f(x) = kx + b
           k = (y2 - y1) / (x2 - x1)
           b = y1 - k
         */
        double k = (this.points[i].getY() - this.points[i + 1].getY()) / (this.points[i].getX() - this.points[i + 1].getX());
        double b = (this.points[i].getY() - k * this.points[i].getX());
        return (k * x + b);
    }

    public int getPointsCount(){
        return this.points.length;
    }

    public FunctionPoint getPoint(int index){
        return this.points[index];
    }

    public void setPoint(int index, FunctionPoint point){
        /**
         Для функции, определяемой точками {(0; 0), (1; 1), (2; 4)}, точку с индексом 1 нельзя заменить точкой (-1; 5).
         Однако точку с индексом 0 уже можно заменить.
         */
        if(point.getX() < this.points[index - 1].getX() || point.getX() > this.points[index + 1].getX())
            return;
        this.points[index] = new FunctionPoint(point.getX(), point.getY());
    }

    public double getPointX(int index){
        return this.points[index].getX();
    }

    public void setPointX(int index, double x){
        if(x < this.points[index - 1].getX() || x > this.points[index + 1].getX())
            return;
        this.points[index].setX(x);
    }

    public double getPointY(int index){
        return this.points[index].getY();
    }

    public void setPointY(int index, double y){
        this.points[index].setY(y);
    }

    public void deletePoint(int index){
        for (int i = index; i < this.points.length; i++) {
            this.points[i] = this.points[i + 1];
        }
        this.points[this.points.length - 1] = null;
    }

    public void addPoint(FunctionPoint point){
        FunctionPoint[] arr = new FunctionPoint[this.points.length + 1];
        int i = 0;
        while(point.getX() > this.points[i++].getX());
        System.arraycopy(this.points, 0, arr, 0, i - 1);
        arr[i++] = point;
        System.arraycopy(this.points, i - 1, arr, i, this.points.length - i + 1);
        this.points = arr;
        arr = null;
    }
}