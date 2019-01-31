import java.util.concurrent.ExecutionException;

public class FutureData implements Data {
    private boolean ready = false;
    private RealData realdata = null;
    private ExecutionException exception = null;

    public synchronized void setRealData(RealData realdata) {
        if (ready)
            return;

        this.ready = true;
        this.realdata = realdata;
        notifyAll();
    }

    public synchronized void setException(Throwable throwable) {
        if (ready)
            return;

        this.ready = true;
        this.exception = new ExecutionException(throwable);
        notifyAll();
    }

    @Override
    public synchronized String getContent() throws ExecutionException {
        while(!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        if (exception != null) {
            throw exception;
        }

        return realdata.getContent();
    }
}