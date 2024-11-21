package Java_platform.Class_overloading.Method_Overloading;

public class Rectangle {
    //Your code here

    Point point1;
    Point point2;

    public Rectangle(Point p1, Point p2) {
        //Your code here
        point1 = p1;
        point2 = p2;
    }

    public void moveBy(int x, int y) {
        //Your code here
        point1.setX(point1.getX()+x);
        point1.setY(point1.getY()+y);
        point2.setX(point2.getX()+x);
        point2.setY(point2.getY()+y);
    }

    public void moveBy(int position) {
        //Your code here
        point1.setX(point1.getX()+position);
        point1.setY(point1.getY()+position);
        point2.setX(point2.getX()+position);
        point2.setY(point2.getY()+position);
    }

    @Override
    public String toString() {
        //Your code here
        return "Rectangle[("+point1.getX()+','+point1.getY()+"), ("+point2.getX()+','+point2.getY()+")]";
    }
}
