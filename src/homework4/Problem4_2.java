package homework4;

public class Problem4_2 {
    public static void solve(){
        Rectangle rectangle = new Rectangle(1,1,3,2);
        System.out.println("Rectangle:");
        System.out.println("area "+rectangle.getArea());
        System.out.println("perimeter "+rectangle.getPerimeter());
        Circle circle = new Circle(1,1,1);
        System.out.println("Circle");
        System.out.println("area "+circle.getArea());
        System.out.println("perimeter "+circle.getPerimeter());
        Triangle triangle = new Triangle(0,0,8,2,-2,6);
        System.out.println("Circle");
        System.out.println("area "+triangle.getArea());
        System.out.println("perimeter "+triangle.getPerimeter());
    }
}
