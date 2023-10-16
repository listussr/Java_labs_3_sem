package functions;

import java.io.*;

public class TabulatedFunctions {
    private TabulatedFunctions() {}
    public static TabulatedFunction tabulate(Function f, double leftX, double rightX, int pointCount) {
        try {
            if (leftX < f.getLeftDomainBorder() || rightX > f.getRightDomainBorder()) {
                throw new IllegalArgumentException();
            }
            FunctionPoint[] points = new FunctionPoint[pointCount];
            double difference = (rightX - leftX) / (pointCount - 1);
            points[0] = new FunctionPoint(leftX, f.getFunctionValue(leftX));
            for (int i = 1; i < pointCount; i++) {
                points[i] = new FunctionPoint(leftX + i * difference, f.getFunctionValue(leftX + i * difference));
            }
            return new ArrayTabulatedFunction(points);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static void outputTabulatedFunction(TabulatedFunction f, OutputStream out) throws IOException {
        DataOutputStream cout = new DataOutputStream(out);
        cout.writeInt(f.getPointsCount());
        for (int i = 0; i < f.getPointsCount(); i++) {
            cout.writeDouble(f.getPointX(i));
            cout.writeDouble(f.getPointY(i));
        }
        cout.flush();
    }

    public static TabulatedFunction inputTabulatedFunction(InputStream in) throws IOException {
        DataInputStream cin = new DataInputStream(in);
        int amount = cin.readInt();
        FunctionPoint[] points = new FunctionPoint[amount];
        for (int i = 0; i < amount; i++) {
            points[i] = new FunctionPoint(cin.readDouble(), cin.readDouble());
        }
        return new ArrayTabulatedFunction(points);
    }

    public static void writeTabulatedFunction(TabulatedFunction f, Writer out) throws IOException {
        PrintWriter cout = new PrintWriter(out);
        cout.println(f.getPointsCount());
        for (int i = 0; i < f.getPointsCount(); i++) {
            cout.println(f.getPointX(i) + " " + f.getPointY(i));
        }
        cout.flush();
    }

    public static TabulatedFunction readTabulatedFunction(Reader in) throws IOException {
        StreamTokenizer cin = new StreamTokenizer(in);
        cin.nextToken();
        int amount = (int) cin.nval;
        FunctionPoint[] points = new FunctionPoint[amount];
        for (int i = 0; i < amount; i++) {
            cin.nextToken();
            double x_val = (double)cin.nval;
            cin.nextToken();
            double y_val = (double)cin.nval;
            points[i] = new FunctionPoint(x_val, y_val);
        }
        return new ArrayTabulatedFunction(points);
    }
}
