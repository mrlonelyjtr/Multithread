package content;

public class Retriever {
    public static Content retrieve(final String urlstr) {
        final ASyncContentImpl future = new ASyncContentImpl();

        new Thread() {
            @Override
            public void run() {
                future.setContent(new SyncContentImpl(urlstr));
            }
        }.start();

        return future;
    }
}
