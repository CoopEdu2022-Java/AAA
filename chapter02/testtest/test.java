import java.io.File;

public class test {
    public static void main(String[] args) {
        String B = "D:\\IOTest.txt";
        File A = new File(B);
        if (A.exists()) {
            if (A.isDirectory()) {
                System.out.println("是文件夹");
            } else {
                if (A.isFile()) {
                    System.out.println("是文件");

                }

            }
        }
    }

}
