public class Mutex {
    private boolean busy = false;

    public synchronized void lock() {
        if (busy) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        busy = true;
    }
    
    public synchronized void unlock() {
        busy = false;
        notifyAll();
    }
}