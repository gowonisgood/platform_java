package Java_platform.Inheritance_polymorphism.AbstractClass0504;

public class Triangle extends Shape {
    float a;
    float b;
    float c;

    Triangle(float a, float b, float c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public float getLength(){
        return (a+b+c);
    }

    @Override
    public float getArea(){
        float s = (float)(0.5)*(a+b+c);
        return (float)Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    @Override
    public void draw(){
        System.out.printf("Triangle,Area:%.2f,Length:%.2f\n",getLength(),getArea());
    }
}
