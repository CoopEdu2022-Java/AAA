import java.util.ArrayList;
import java.util.List;

public class java1011 {
    public static void main(String[] args) {
        int length = 2;

        List<String> set = allnumberlist(length);

        String s = "100100";
        boolean TOF = true;

        for (String combination : set) {
            if (!s.contains(combination)) {
                TOF = false;
                break;
            }
        }

        System.out.println(TOF);
    }

    public static List<String> allnumberlist(int length) {
        List<String> set = new ArrayList<>();

        int totalset = (int) Math.pow(2, length);

        for (int i = 0; i < totalset; i++) {
            String binary = getallbi(i, length);
            set.add(binary);
        }

        return set;
    }

    // 生成二进制
    public static String getallbi(int a, int length) {
        StringBuilder binary = new StringBuilder();

        for (int i = length - 1; i >= 0; i--) {
            int bi = (a >> i) & 1;
            binary.append(bi);
        }
        return binary.toString();
    }
}
