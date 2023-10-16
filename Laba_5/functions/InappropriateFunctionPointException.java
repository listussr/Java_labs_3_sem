package functions;
import java.lang.Exception;
/*
public class InappropriateFunctionPointException extends Exception {
    public InappropriateFunctionPointException(){
        super();
    }

    public InappropriateFunctionPointException(String s){
        super(s);
    }

    public InappropriateFunctionPointException(String message, Throwable cause){
        super(message, cause);
    }

    public InappropriateFunctionPointException(Throwable cause){
        super(cause);
    }

    protected InappropriateFunctionPointException(String message,
                                                  Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

 */

public class InappropriateFunctionPointException extends IndexOutOfBoundsException {
    public InappropriateFunctionPointException(){
        super();
    }

    public InappropriateFunctionPointException(String s){
        super(s);
    }

    public InappropriateFunctionPointException(int index){
        super("Index out of range: " + index);
    }

    public InappropriateFunctionPointException(long index){
        super("Index out of range: " + index);
    }
}

