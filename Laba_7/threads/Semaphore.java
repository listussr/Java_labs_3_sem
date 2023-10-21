package threads;

public class Semaphore {
    private boolean flag = true;

    public synchronized void beginRead() throws InterruptedException {
        while (flag) {
            wait();
        }
    }

    public synchronized void endRead() {
        flag = true;
        notifyAll();
    }

    public synchronized void beginWrite() throws InterruptedException {
        while (!flag) {
            wait();
        }
    }

    public synchronized void endWrite() {
        flag = false;
        notifyAll();
    }
}
