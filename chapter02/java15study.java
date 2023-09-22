public class java15study {
    public static void main(String[] args) {
        // ccc a = new ccc();
        ccc a = new bbb();
        System.out.println(a.sum());
        
    }
}
class ccc{
    int i = 10;

    int sum(){
        return getI() + 10;
    }
    int getI(){
        return i;
    }
}
class bbb extends ccc{

    int i = 20;

    int sum(){
        return getI() + 20;
    }
    // int getI(){
    //     return i;
    // }
}
