package homework4;

public class Triangle extends Figure{
    private int x2,y2,x3,y3;

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.setX(x1);
        this.setY(y1);
        this.setX2(x2);
        this.setY2(y2);
        this.setX3(x3);
        this.setY3(y3);
    }

    @Override
    public double getArea() {
        return Math.abs(0.5*(
                Math.abs((this.getX() - this.getX3())*(this.getY2()-this.getY3()))-
                        Math.abs((this.getX2() - this.getX3())*(this.getY()-this.getY3()))
        ));
    }

    @Override
    public double getPerimeter() {
        return Math.sqrt(Math.pow(this.getX2()-this.getX(),2)
                        + Math.pow(this.getY2()-this.getY(),2))+
                Math.sqrt(Math.pow(this.getX3()-this.getX(),2)
                        + Math.pow(this.getY3()-this.getY(),2))+
                Math.sqrt(Math.pow(this.getX3()-this.getX2(),2)
                        + Math.pow(this.getY3()-this.getY2(),2))

                ;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }
}
