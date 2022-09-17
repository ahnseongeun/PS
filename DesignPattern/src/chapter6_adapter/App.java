package chapter6_adapter;

public class App {

    public static void main(String[] args) {
        var captain = new Captain(new FishingBoatAdapter());
        captain.row();
    }

}
