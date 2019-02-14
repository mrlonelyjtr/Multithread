import java.lang.annotation.Target;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int TASKS = 10;

    public static void main(String[] args) {
        /*
        ExecutorService service = Executors.newFixedThreadPool(3);

        try {
            for (int i = 0; i < TASKS; i++) {
                Runnable printTask = new Runnable() {
                    @Override
                    public void run() {
                        Log.println("Hello");
                        Log.close();
                    }
                };

                service.execute(printTask);
            }
        } finally {
            service.shutdown();
        }
        */

        for (int i = 0; i < TASKS; i++) {
            Runnable printTask = new Runnable() {
                @Override
                public void run() {
                    Log.println("Hello");
                    Log.close();
                }
            };

            new Thread(printTask).start();
        }
    }
}
