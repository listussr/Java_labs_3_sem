package functions;

import java.io.Serializable;

public class FunctionPoint implements Serializable  {
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
    public FunctionPoint(){
        x = y = 0.;
    }

    public FunctionPoint(double x, double y){
        this.x = x;
        this.y = y;
    }

    public FunctionPoint(FunctionPoint point){
        this.x = point.x;
        this.y = point.y;
    }

    @Override
    public String toString(){
        return "(" + x + "; " + y + ")";
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof FunctionPoint point){
            return x == point.x && y == point.y;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return (int)(Double.doubleToLongBits(x) ^ Double.doubleToLongBits(y));
    }

    @Override
    public Object clone(){
        return new FunctionPoint(this);
    }
}