
public class java123 {
    public static void main(String[] args) {
        int count = 90;
        int pointer = 2;
            for (int i = pointer; i <= count; i++) {
                if (count % i == 0){
                    count = count / i;
                    System.out.println(i);
                    continue;
                }
            }
            System.out.println(count);

    }
}
