import java.util.concurrent.ExecutionException;

public class Host {
    public Data request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");

        final FutureData future = new FutureData();

        new Thread() {
            @Override
            public void run() {
                try {
                    RealData realdata = new RealData(count, c);
                    future.setRealData(realdata);
                } catch (Exception e) {
                    future.setException(e);
                }
            }
        }.start();

        System.out.println("    request(" + count + ", " + c + ") END");
        return future;
    }
}