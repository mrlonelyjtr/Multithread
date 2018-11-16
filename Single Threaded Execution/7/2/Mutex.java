public class Mutex {
    private long locks = 0;
    private Thread owner = null;

    public synchronized void lock() {
        Thread me = Thread.currentThread();

        while (locks > 0 && owner != me) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        assert locks == 0 || owner == me;
        owner = me;
        locks++;
    }
    
    public synchronized void unlock() {
        Thread me = Thread.currentThread();

        if (owner != me || locks == 0) {
            return;
        }

        assert owner == me && locks > 0;
        locks--;

        if (locks == 0) {
            owner = null;
            notifyAll();
        }
    }
}