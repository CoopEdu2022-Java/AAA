// 定义Shape接口
interface Shape {
    double getArea();
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getArea() {
        return 0.5 * base * height;
    }
}

public class java2039 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(9, 7);
        Circle circle = new Circle(3);
        // 只能输入直角边
        Triangle triangle = new Triangle(6, 7);

        System.out.println("矩形的面积: " + rectangle.getArea());
        System.out.println("圆的面积: " + circle.getArea());
        System.out.println("三角形的面积: " + triangle.getArea());
    }
}
