public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (Thread.currentThread().isInterrupted()) {
                        //if (Thread.interrupted()) {
                            throw new InterruptedException();
                        }

                        System.out.print(".");
                    } catch (InterruptedException e) {
                        System.out.print("*");
                    }
                }
            }
        };

        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        thread.interrupt();
    }
}