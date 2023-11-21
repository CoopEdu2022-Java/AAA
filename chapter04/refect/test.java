package chapter04.refect;

public class test {
    public static void main(String[] args) throws ClassNotFoundException {
        User person = new User();
        Class c1 = Class.forName("chapter04.refect.User");
        System.out.println(c1);
        Class c2 = person.getClass();
        System.out.println(c2);
    }
}
