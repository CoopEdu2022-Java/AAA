import java.util.ArrayList;
import java.util.List;

public class java132 {
    public static void main(String[] args) {
        String[] jia = {"a", "b", "c"};
        String[] yi = {"x", "y", "z"};

        List<String> allse = new ArrayList<>(); 
        String a;

        for (int i = 0; i < yi.length; i++) {
            for (int j = 0; j < jia.length; j++) {
                a = jia[j] + yi[i]; 

                // 添加逻辑以避免重复元素
                if (!a.equals("ax") && !a.equals("cz") && !a.equals("cx")) {
                    allse.add(a);
                }
            }
        }

        System.out.println("All Results:");
        for (String result : allse) {
            System.out.println(result);
        }
    }
}
