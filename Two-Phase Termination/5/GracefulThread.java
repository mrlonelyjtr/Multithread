public class GracefulThread extends Thread {
    private volatile boolean shutdownRequested = false;

    public final void shutdownRequest() {
        shutdownRequested = true;
        interrupt();
    }

    public final boolean isShutdownRequested() {
        return shutdownRequested;
    }

    @Override
    public final void run() {
        try {
            while (!isShutdownRequested()) {
                doWork();
            }
        } catch (InterruptedException e) {
        } finally {
            doShutdown();
        }
    }

    protected void doWork() throws InterruptedException {
    }

    protected void doShutdown() {
    }
}
