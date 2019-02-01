package content;

public class ASyncContentImpl implements Content {
    private SyncContentImpl synccontent;
    private boolean ready = false;

    public synchronized void setContent(SyncContentImpl synccontent) {
        this.synccontent = synccontent;
        this.ready = true;
        notifyAll();
    }

    @Override
    public synchronized byte[] getBytes() {
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        return synccontent.getBytes();
    }
}
