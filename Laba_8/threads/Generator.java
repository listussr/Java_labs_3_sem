package threads;

import functions.basic.Log;

import java.util.Random;

public class Generator extends Thread {
    Task task;
    Semaphore semaphore;
    boolean flag = true;

    public Generator(Task t, Semaphore sem) {
        this.task = t;
        this.semaphore = sem;
    }

    public void run() {
        Random random = new Random();
        for (int i = 0; i < this.task.getTasks() && flag; i++) {
            try {
                semaphore.beginWrite();
                this.task.f = new Log(random.nextInt(9) + 1);
                this.task.leftX = random.nextInt(100);
                this.task.rightX = random.nextInt(100) + 100;
                this.task.step = (double) 1 / (random.nextDouble(1000000.) + 1.0);
                System.out.println("Source <" + this.task.leftX + "> <" + this.task.rightX + "> <" + this.task.step + ">");
                semaphore.endWrite();
            } catch (InterruptedException ex){
                System.out.println("Генератор прервали во время сна, он корректно завершил свою работу");
            }
        }
    }
    public void interrupt() {
        super.interrupt(); //To change body of generated methods, choose Tools | Templates.
        flag = false;
    }
}
