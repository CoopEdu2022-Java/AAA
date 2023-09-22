

public class java211 {
    public static void main(String[] args) {
        Person A = new Person("aaaaa",10);
        System.out.println("姓名：" + A.Getname());
        System.out.println("年龄：" + A.Getage());

    }
}
class Person{
    private String name;
    private int age;

    public Person(String name,int age){
        this.age = age;
        this.name = name;
    }
    public int Getage(){
        return age;
    }
    public String Getname(){
        return name;
    }
}