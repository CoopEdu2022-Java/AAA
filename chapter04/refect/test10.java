package chapter04.refect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test10 {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        test1();
        test2();
    }

    public static void test1() {
        User user = new User();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 200000000; i++) {
            user.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时" + (endTime - startTime) + "ms");
    }

    public static void test2() throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        User user = new User();
        Class c2 = user.getClass();
        Method getName = c2.getDeclaredMethod("getName", null);
        getName.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            getName.invoke(user, null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时" + (endTime - startTime) + "ms");
    }
}

class User {
    private String name = "aaa";

    String getName() {
        return name;
    }
}
