package Java_platform.Inheritance_polymorphism.PlayerBuilder0506;

public abstract class Player {
    private String name ;
    private int jerseyNumber ;
    protected int speed ;
    // Builder 클래스를 정의하시오. (단, static nested class 로 정의하시오.  )
    public static class Builder{
        String PlayerType;
        private String Name ;
        private int JerseyNumber ;
        protected int Speed ;

        public Builder setPlayerType(String type){
            this.PlayerType = type;
            return this;
        }

        public Builder setName(String name){
            this.Name = name;
            return this;
        }

        public Builder setJerseyNumber(int jerseyNumber){
            this.JerseyNumber = jerseyNumber;
            return this;
        }

        public Builder setSpeed(int speed){
            this.Speed = speed;
            return this;
        }

        public Player build(){
            switch (PlayerType) {
                case "forward":
                    return new Forward(Name,JerseyNumber,Speed);
                case "midfielder":
                    return new MidFielder(Name,JerseyNumber,Speed);
                case "defender":
                    return new Defender(Name, JerseyNumber,Speed);
                default:
                    break;
            }
            return null;
        }


    }

    @Override
    public String toString(){
        return String.format("Player Name='%s, JerseyNumber=%d, SPEED=%d, ",name,jerseyNumber,speed);
    }

    protected Player(String name, int jerseyNumber, int speed){
        this.name = name;
        this.jerseyNumber = jerseyNumber;
        this.speed = speed;
    }


    protected abstract int getSpeed() ;
}
