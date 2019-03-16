package homework4;

public abstract class Figure {
    private int x;
    private int y;

    public abstract double getArea();
    public abstract double getPerimeter();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
