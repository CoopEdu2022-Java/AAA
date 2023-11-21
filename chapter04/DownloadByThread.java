import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URLConnection;

public class DownloadByThread extends Thread {
    private String url; // 存储下载的URL
    private String path; // 存储文件的路径

    // 构造函数，用于设置URL和文件路径
    DownloadByThread(String url, String path) {
        this.url = url;
        this.path = path;
    }

    @Override
    public void run() {
        Downloader f = new Downloader();
        f.download(url, path); // 在线程中执行下载操作
    }

    public static void main(String[] args) {
        String url = "https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/242px-Java_programming_language_logo.svg.png";

        long startTime = System.currentTimeMillis(); // 记录开始时间

        // 创建三个线程来下载相同的URL到不同的文件
        DownloadByThread t1 = new DownloadByThread(url, "java1.png");
        DownloadByThread t2 = new DownloadByThread(url, "java2.png");
        DownloadByThread t3 = new DownloadByThread(url, "java3.png");

        // 启动线程
        t1.start();
        t2.start();
        t3.start();

        try {
            // 等待所有线程完成
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis(); // 记录结束时间
        long totalTime = endTime - startTime;

        System.out.println("多线程下载完成，总共耗时：" + totalTime + " 毫秒");
    }
}

class Downloader {
    // 下载方法，接受URL和文件路径作为参数
    public void download(String url, String path) {
        try {
            URLConnection connection = URI.create(url).toURL().openConnection();
            BufferedInputStream inputStream = new BufferedInputStream(connection.getInputStream());
            FileOutputStream outputStream = new FileOutputStream(path);
            byte[] buffer = new byte[1024];
            int bytesRead;
            // 从输入流读取数据并写入文件
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            inputStream.close();
            System.out.println(path + " Done!"); // 下载完成后输出消息
        } catch (IOException e) {
            e.printStackTrace(); // 捕获并打印任何异常
        }
    }
}
