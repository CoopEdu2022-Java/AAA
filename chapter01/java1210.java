
public class java1210 {

        public static void main(String[] args) {
            int year = 2024;
            int mounth = 6;
            int date = 7;
            int dateofall = 0;
            int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            boolean key = false;
    
            // 使用 if 语句来检查年份是否是闰年
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                System.out.println(year + "是");
                key = true;
            } else {
                System.out.println(year + "不是");
            }
            for (int i = 0; i < mounth; i++) {
                dateofall = dateofall + daysInMonth[i];
                System.out.println(dateofall);
                if (key == true && mounth >= 3) {
                    dateofall++;       
                    System.out.println(dateofall);             
                } 
            }
            dateofall = dateofall + date;
            System.out.println(dateofall);
        }
}
