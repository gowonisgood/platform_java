package Java_platform.Genenric.GenericPlayer0605;

public class Forward extends Player{

    public Forward(Builder builder){
        super(builder);
    }

    @Override
    public int getSpeed(){
        return speed+10;
    }



    public static class Builder extends Player.Builder<Forward.Builder>{
        @Override
        public Forward build(){
            return new Forward(this);
        }

        @Override
        protected Builder self(){
            return this;
        }
    }
}
