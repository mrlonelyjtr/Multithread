public class Host {

    public static void execute(int count) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }

            doHeavyJob();
        }
    }

    private static void doHeavyJob() {
        System.out.println("doHeavyJob BEGIN");

        long start = System.currentTimeMillis();
        while (start + 10000 > System.currentTimeMillis()) {
        }

        System.out.println("doHeavyJob END");
    }
}