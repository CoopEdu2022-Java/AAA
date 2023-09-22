import java.lang.Math;
public class java214 {
        public static void main(String[] args) {
        Circle Circle = new Circle(1.0);

        System.out.println("R: " + Circle.getR());

        System.out.println("Area: " + Circle.calculateArea());
        System.out.println("Perimeter: " + Circle.calculateCircle());

}
}
class Circle {
    private double E;


    public Circle(double R) {
        this.E = R;
    }

    public double getR() {
        return E;
    }




    public double calculateArea() {
        double a = Math.PI *Math.pow(E, 2);
        return a;
    }

    public double calculateCircle() {
        return 2 * Math.PI * E;
    }

}
