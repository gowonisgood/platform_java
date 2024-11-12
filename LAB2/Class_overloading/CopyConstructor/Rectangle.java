package Java_platform.Class_overloading.CopyConstructor;
import java.util.Objects;

public class Rectangle {
    private final Point point1;
    private final Point point2;

    public Rectangle(Point p1, Point p2){
        point1 = new Point(p1.getX(),p1.getY());
        point2 = new Point(p2.getX(),p2.getY());
    }

    public Rectangle(Rectangle rect){
        this(rect.point1,rect.point2);
    }

    public void moveBy(int a, int b){
        point1.setX(point1.getX()+a);
        point1.setY(point1.getY()+b);
        point2.setX(point2.getX()+a);
        point2.setY(point2.getY()+b);
    }

    @Override
    public String toString() {
        //Your code here
        return "Rectangle[("+point1.getX()+','+point1.getY()+"), ("+point2.getX()+','+point2.getY()+")]";
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null) return false;
        if(getClass()!=o.getClass()) return false;
        Rectangle other = (Rectangle) o;
        return Objects.equals(this.point1, other.point1) && Objects.equals(this.point2, other.point2);
    }

}
