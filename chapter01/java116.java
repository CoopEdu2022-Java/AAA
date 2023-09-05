

public class java116 {
    public static void main(String[] args) {
        int year = 2024; // 请替换为你想要检查的年份

        // 使用 if 语句来检查年份是否是闰年
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + "是");
        } else {
            System.out.println(year + "不是");
        }
    }
}
