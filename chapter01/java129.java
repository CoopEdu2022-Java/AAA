

public class java129 {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            if ((i+100)%Math.sqrt(i+100)==0 && (i+168)%Math.sqrt(i+168)==0) {
                System.out.println("数字是"+i);
            }
        }
    }
}
