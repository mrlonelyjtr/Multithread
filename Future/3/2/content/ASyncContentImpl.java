package content;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ASyncContentImpl extends FutureTask<SyncContentImpl> implements Content {

    public ASyncContentImpl(Callable<SyncContentImpl> callable) {
        super(callable);
    }

    @Override
    public synchronized byte[] getBytes() {
        byte[] bytes = null;

        try {
            bytes = get().getBytes();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return bytes;
    }
}
