public class java137 {
    public static void main(String[] args) {

        int A[] = { 2, 3, 5, 1, 4, 5, 6, 8 };
        int n = A.length;

        for (int i = n - 1; i > 0; i--) {
            int maxIndex = 0;

           
            for (int j = 1; j <= i; j++) {
                if (A[j] > A[maxIndex]) {
                    maxIndex = j;
                }
            }

           
            int temp = A[i];
            A[i] = A[maxIndex];
            A[maxIndex] = temp;
        }

        for (int result : A) {
            System.out.println(result);
        }
    }
}
