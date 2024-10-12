package Java_platform.Inheritance_polymorphism.PlayerBuilder0506;

public class Defender extends Player{
    public Defender(String name, int jerseyNumber, int speed){
        super(name,jerseyNumber,speed-10);
    }

    @Override
    protected int getSpeed(){
        return speed;
    }

    @Override
    public String toString(){
        return super.toString()+"Defender";
    }
}
