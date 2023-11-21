import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IO22 {
    public static void main(String[] args) throws IOException {
        String Apath = "D:\\docctrl\\IOTest";
        String Bpath = "D:\\docctrl\\A";

        File Afile = new File(Apath);
        File Bfile = new File(Bpath);
        System.out.println(Afile.getName());
        copydir(Afile, Bfile);
    }

    public static void copydir(File Afile, File Bfile) throws IOException {
        Bfile.mkdir();
        File[] files = Afile.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    FileInputStream fis = new FileInputStream(file);
                    FileOutputStream fos = new FileOutputStream(new File(Bfile, file.getName()));

                    byte[] bytes = new byte[1024];
                    int len;

                    while ((len = fis.read(bytes)) != -1) {
                        fos.write(bytes, 0, len);
                    }

                    fos.close();
                    fis.close();
                } else {
                    copydir(file, new File(Bfile, file.getName()));
                }
            }
        }
    }
}
