package Java_platform.Inheritance_polymorphism.InstanceOfTest0503;

public enum Grade {
    FRESH(1),
    SOPHOMORE(2),
    JUNIOR(3),
    SENIOR(4);


    private int grade;

    /*Grade(){
        this.grade = FRESH;
    }*/

    Grade(int g){
        this.grade = g;
    }

    public int getYear(){return grade;}





}
