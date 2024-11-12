package Java_platform.Genenric.GenericPlayer0605;

public class Goalkeeper extends Player {
    public Goalkeeper(Builder builder){
        super(builder);
    }

    @Override
    public int getSpeed(){
        return speed-20;
    }



    public static class Builder extends Player.Builder<Goalkeeper.Builder>{
        private int reflexes;
        private int jumpheight;

        public Builder setReflexes(int r){
            reflexes = r;
            return self();
        }

        public Builder setJumpHeight(int h){
            jumpheight = h;
            return self();
        }

        @Override
        public Goalkeeper build(){
            return new Goalkeeper(this);
        }

        @Override
        protected Builder self(){
            return this;
        }
    }
}
