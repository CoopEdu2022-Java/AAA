public class java136 {
    public static void main(String[] args) {
        int sumA = 0;
        int[][] matrix = {
            {1,2,3},{4,5,6},{7,8,9}
        };
        
        for (int i = 0; i < matrix.length; i++) {
            sumA = sumA +matrix[i][i];
            sumA = sumA + matrix[i][2-i];
        }
        sumA = sumA - matrix[1][1];
        System.out.println(sumA);
    }

}
