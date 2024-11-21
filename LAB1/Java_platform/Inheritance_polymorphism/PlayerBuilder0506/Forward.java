package Java_platform.Inheritance_polymorphism.PlayerBuilder0506;

public class Forward extends Player {
    public Forward(String name, int jerseyNumber, int speed){
        super(name,jerseyNumber,speed+10);
    }

    @Override
    protected  int getSpeed(){
        return speed+10;
    }

    @Override
    public String toString(){
        return super.toString()+"Forward";
    }
}
