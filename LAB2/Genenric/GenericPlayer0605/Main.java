package Java_platform.Genenric.GenericPlayer0605;

public class Main {
    public static void main(String[] args) {
        Player forward = new Forward.Builder()
                .setName("Romelu")
                .setJerseyNumber(9)
                .setSpeed(100)
                .build();
        System.out.println(forward);

        MidFielder midfielder = new MidFielder.Builder()
                .setName("Mason")
                .setJerseyNumber(19)
                .setSpeed(100)
                .build();
        System.out.println(midfielder);

        Player defender = new Defender.Builder()
                .setName("Kurt")
                .setJerseyNumber(15)
                .setSpeed(100)
                .build();
        System.out.println(defender);

        Goalkeeper goalkeeper = new Goalkeeper.Builder()
                .setName("Ederson")
                .setJerseyNumber(31)
                .setSpeed(100)
                .setReflexes(95)
                .setJumpHeight(90)
                .build();
        System.out.println(goalkeeper);
    }
}
