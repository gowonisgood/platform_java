package Java_platform.Genenric.GenericPlayer0605;

public class Defender extends Player {

    protected Defender(Builder builder){
        super(builder);
    }

    @Override
    public int getSpeed(){
        return speed-10;
    }



    public static class Builder extends Player.Builder<Builder>{
        @Override
        public Defender build(){
            return new Defender(this);
        }

        @Override
        protected Builder self(){
            return this;
        }

    }
}
