package homework4;

public class Circle extends Figure {
    private double radius;

    Circle(int x, int y, double radius){
        this.setX(x);
        this.setY(y);
        this.setRadius(radius);
    }

    @Override
    public double getArea() {
        return Math.PI*this.getRadius()*this.getRadius();
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*getRadius();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
