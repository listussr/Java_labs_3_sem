package threads;

import functions.Functions;

public class SimpleIntegrator implements Runnable {
    private Task task;

    public SimpleIntegrator(Task task) {
        this.task = task;
    }

    public void run() {
        for (int i = 0; i < this.task.getTasks(); i++) {
            if(this.task.f == null){
                continue;
            }
            synchronized (this.task) {
                double res = Functions.integral(this.task.f, this.task.leftX, this.task.rightX, this.task.step);
                System.out.println("Result <" + this.task.leftX + "> <" + this.task.rightX + "> <" + this.task.step + "> <" + res + ">");
            }
        }
    }
}
