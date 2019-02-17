package activeobject;

import java.math.BigInteger;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ActiveObjectImpl implements ActiveObject {
    private final ExecutorService service = Executors.newSingleThreadExecutor();

    @Override
    public Future<String> add(final String x, final String y) {
        class AddRequest implements Callable<String> {

            @Override
            public String call() throws NumberFormatException {
                BigInteger bigX = new BigInteger(x);
                BigInteger bigY = new BigInteger(y);
                BigInteger bigZ = bigX.add(bigY);
                return bigZ.toString();
            }
        }

        return service.submit(new AddRequest());
    }

    @Override
    public void shutdown() {
        service.shutdown();
    }
}
