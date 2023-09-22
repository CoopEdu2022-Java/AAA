
public class java212 {
    public static void main(String[] args) {
            Dog A = new Dog("A", "null");
            Dog B = new Dog("B", "cat");
            System.out.println("name: " + A.Show()[0] +"\n"+ "breeed: " + A.Show()[1]);
            System.out.println("name: " + B.Show()[0] +"\n"+ "breeed: " + B.Show()[1]);
    }

    
    
}
class Dog{
    String name;
    String Breed;
    public Dog(String name, String Breed){
        this.name = name;
        this.Breed = Breed;
    }

    public String[] Show(){
        return new String[] {this.Breed,this.name};
    }
    

}