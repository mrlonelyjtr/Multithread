public class Main {

    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        Thread alice = new ClientThread(requestQueue, "Alice", 3141592L);
        Thread bobby = new ServerThread(requestQueue, "Bobby", 6535897L);
        alice.start();
        bobby.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }

        System.out.println("***** calling interrupt *****");
        alice.interrupt();
        bobby.interrupt();
    }
}