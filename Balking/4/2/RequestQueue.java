import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class RequestQueue {
    private final BlockingQueue<Request> queue = new LinkedBlockingQueue<>();
    
    public void putRequest(Request request) {
        try {
            boolean offered = queue.offer(request, 30L, TimeUnit.SECONDS);

            if (!offered) {
                throw new LivenessException("thrown by "+Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
        }
    }

    public Request getRequest() {
        Request request = null;

        try {
            request = queue.poll(30L, TimeUnit.SECONDS);

            if (request == null) {
                throw new LivenessException("thrown by " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
        }

        return request;
    }
}