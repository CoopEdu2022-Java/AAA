
public class java133 {
    public static void main(String[] args) {
        int hight = 9;
        char character = '6';
        int get;
        if (hight % 2 == 0) {
            get = (hight - 2) / 2;

        } else {
            get = (hight - 1) / 2;
        }
        for (int i = 0; i <= get; i++) {
            for (int j = 0; j < get - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print(character);
            }
            System.out.println();
        }
        for (int i = get; i > -1; i--) {
            for (int j = 0; j < get - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print(character);
            }
            System.out.println();
        }

    }
}
