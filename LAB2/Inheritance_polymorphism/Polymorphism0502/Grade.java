package Java_platform.Inheritance_polymorphism.Polymorphism0502;

import static Java_platform.Inheritance_polymorphism.Polymorphism0502.Grade.G.FRESH;

public class Grade {
    enum G {FRESH,SOPHOMORE,JUNIOR,SENIEOR}
    private G grade;

    public Grade() {this.grade = G.FRESH ;}
    public Grade(G grade){this.grade=grade;}

    @Override
    public String toString()
    {
        return grade.name();
    }

}
