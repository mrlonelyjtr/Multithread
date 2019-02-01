import content.Content;
import content.Retriever;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Content content1 = Retriever.retrieve("http://www.acfun.cn");
        Content content2 = Retriever.retrieve("https://www.bilibili.com");
        Content content3 = Retriever.retrieve("http://www.dilidili.wang");

        saveToFile("acfun.html", content1);
        saveToFile("bilibili.html", content2);
        saveToFile("dilidili.html", content3);

        long end = System.currentTimeMillis();

        System.out.println("Elapsed time = " + (end - start) + "msec.");
    }

    private static void saveToFile(String filename, Content content) {
        byte[] bytes = content.getBytes();
        try {
            System.out.println(Thread.currentThread().getName() + ": Saving to " + filename);
            FileOutputStream out = new FileOutputStream(filename);

            for (int i = 0; i < bytes.length; i++) {
                out.write(bytes[i]);
            }

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
