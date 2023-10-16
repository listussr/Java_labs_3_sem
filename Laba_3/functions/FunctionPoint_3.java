package functions;

public class FunctionPoint_3{
    private double x, y;

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }
    public FunctionPoint_3(){
        x = y = 0.;
    }

    public FunctionPoint_3(double x, double y){
        this.x = x;
        this.y = y;
    }

    public FunctionPoint_3(FunctionPoint_3 point){
        this.x = point.x;
        this.y = point.y;
    }



}