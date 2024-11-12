package Java_platform.Inheritance_polymorphism.AbstractClass0504;

public class Circle extends Shape {
    float radius;
    Circle(float R){
        this.radius = R;
    }

    @Override
    public float getLength(){
        return (2*(float)(Math.PI)*radius);
    }

    @Override
    public float getArea(){
        return (float)Math.PI*radius*radius;
    }

    @Override
    public void draw(){
        System.out.printf("Circle,Area:%.2f,Length:%.2f\n",getLength(),getArea());
    }


}

