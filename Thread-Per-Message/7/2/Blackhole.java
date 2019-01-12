public class Blackhole {
    public static void enter(Object obj) {
        System.out.println("Step 1");
        magic(obj);
        System.out.println("Step 2");
        synchronized(obj) {
            System.out.println("Step 3 (never reached here)");
        }
    }
    
    public static void magic(final Object obj) {
        Thread thread = new Thread() {
            public void run() {
                synchronized(obj) {
                    synchronized(this) {
                        this.notifyAll();
                    }

                    try {
                        this.join();
                    } catch (InterruptedException e) {
                    }
                }
            }
        };

        synchronized(thread) {
            thread.start();

            try {
                thread.wait();
            } catch (InterruptedException e) {
            }
        }
    }
}