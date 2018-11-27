import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {
    private static final long TIMEOUT = 30000L;
    private final Queue<Request> queue = new LinkedList<>();
    
    public synchronized void putRequest(Request request) {
        queue.offer(request);
        notifyAll();
    }

    public synchronized Request getRequest() {
        long start = System.currentTimeMillis();

        while (queue.peek() == null) {
            long now = System.currentTimeMillis();
            long rest = TIMEOUT - (now - start);
            
            if (rest <= 0) {
                throw new LivenessException("thrown by " + Thread.currentThread().getName());
            }
            
            try {
                wait(rest);
            } catch (InterruptedException e) {
            }
        }

        return queue.remove();
    }
}