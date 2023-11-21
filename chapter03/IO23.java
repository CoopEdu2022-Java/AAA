
import java.io.*;

public class IO23 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\docctrl\\A\\立绘_森蚺_1.png")
                decode("C:\\Users\\17354\\Desktop\\JAVA LEARNING\\dir_for_io_training_copy\\dir2\\dir2_text1.txt",
                "C:\\Users\\17354\\Desktop\\JAVA LEARNING\\dir_for_io_training\\dir2\\dir2_text1.txt");
    }

    public static void code(String path, String newPath) throws IOException {
        File file = new File(path);
        File newFile = new File(newPath);
        FileInputStream in = new FileInputStream(file);
        FileOutputStream out = new FileOutputStream(newFile);
        int data;
        while ((data = in.read()) != -1) {
            out.write(data + 1);
        }
        out.close();
        in.close();
    }

    public static void decode(String path, String newPath) throws IOException {
        File file = new File(path);
        File newFile = new File(newPath);
        FileInputStream in = new FileInputStream(file);
        FileOutputStream out = new FileOutputStream(newFile);
        int data;
        while ((data = in.read()) != -1) {
            out.write(data - 1);
        }
        out.close();
        in.close();
    }
}