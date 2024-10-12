package Java_platform.Inheritance_polymorphism.AbstractClass0504;

public abstract class Shape {
    private int lineColor;

    public int getLineColor() {return lineColor;}
    public void setLineColor(int color) {lineColor = color;}


    public abstract float getLength();
    public abstract float getArea();
    public abstract void draw();

}
