package functions;

import java.io.Serializable;

public interface Function extends Serializable {
    public double getLeftDomainBorder();
    public double getRightDomainBorder();
    public double getFunctionValue(double x);
}
