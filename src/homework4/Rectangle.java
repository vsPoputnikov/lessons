package homework4;

public class Rectangle extends Figure {
   private int x2, y2;

    Rectangle(int x1, int y1, int x2, int y2){
        this.setX(x1);
        this.setY(y1);
        this.setX2(x2);
        this.setY2(y2);

    }
    @Override
    public double getArea() {
        return Math.abs((this.getX2()-this.getX())*(this.getY2()-this.getY()));
    }

    @Override
    public double getPerimeter() {
        return 2*(Math.abs((this.getX2()-this.getX()))+Math.abs((this.getY2()-this.getY())));
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }
}
