package threads;
import functions.*;
import functions.basic.*;
import functions.meta.*;

public class Task {
    public Function f;
    public double leftX, rightX;
    public double step;
    private int tasks;

    public Task(int tasks) {
        this.tasks = tasks;
    }

    public Task(Function f, double leftX, double rightX, double step, int tasks) {
        this.f = f;
        this.leftX = leftX;
        this.rightX = rightX;
        this.step = step;
        this.tasks = tasks;
    }

    public int getTasks() {
        return this.tasks;
    }
}
