package Java_platform.Inheritance_polymorphism.PlayerBuilder0506;

public class MidFielder extends Player{
    public MidFielder(String name, int jerseyNumber, int speed){
        super(name,jerseyNumber,speed);
    }

    @Override
    protected int getSpeed(){
        return speed;
    }


    @Override
    public String toString(){
        return super.toString()+"Midfielder";
    }
}
