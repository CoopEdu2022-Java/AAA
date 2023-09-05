public class java121 {
    public static void main(String[] args) {
        int months = 12;
        int[] rabbitPairs = new int[months];

        rabbitPairs[0] = 1;
        rabbitPairs[1] = 1;

        for (int i = 2; i < months; i++) {
            rabbitPairs[i] = rabbitPairs[i - 1] + rabbitPairs[i - 2];
        }

        System.out.println("兔子繁殖情况：");
        for (int i = 0; i < months; i++) {
            System.out.println("第 " + (i + 1) + " 个月：" + rabbitPairs[i] + " 对兔子");
        }
    }

}
