public final class Channel {

    public Channel(int threads) {
    }

    public void startWorkers() {
    }
    
    public synchronized void putRequest(final Request request) {
        new Thread() {
            @Override
            public void run() {
                request.execute();
            }
        }.start();
    }
}