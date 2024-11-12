package Java_platform.Genenric.GenericPlayer0605;

public class MidFielder extends Player {
    public MidFielder(Builder builder){
        super(builder);
    }

    @Override
    public int getSpeed(){
        return speed;
    }



    public static class Builder extends Player.Builder<MidFielder.Builder>{
        @Override
        public MidFielder build(){
            return new MidFielder(this);
        }

        @Override
        protected Builder self(){
            return this;
        }

    }
}
