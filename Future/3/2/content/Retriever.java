package content;

import java.util.concurrent.Callable;

public class Retriever {
    public static Content retrieve(final String urlstr) {
        ASyncContentImpl future = new ASyncContentImpl(
            new Callable<SyncContentImpl>() {
                @Override
                public SyncContentImpl call() throws Exception {
                    return new SyncContentImpl(urlstr);
                }
            }
        );

        new Thread(future).start();

        return future;
    }
}
