package Java_platform.Inheritance_polymorphism.AbstractClass0504;

public class Rectangle extends Shape {
    float width;
    float height;
    Rectangle(float width, float height){
        this.width = width;
        this.height = height;
    }

    @Override
    public float getLength(){
        return (width+height);
    }

    @Override
    public float getArea(){
        return width*height;
    }

    @Override
    public void draw(){

        System.out.printf("Rectangle,Area:%.2f,Length:%.2f\n",getLength(),getArea());
    }
}
