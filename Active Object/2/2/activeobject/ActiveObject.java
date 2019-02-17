package activeobject;

import java.util.concurrent.Future;

public interface ActiveObject {
    public abstract Future<String> add(String x, String y);
    public abstract void shutdown();
}
