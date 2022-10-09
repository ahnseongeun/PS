package chapter06_adapter;

public class FishingBoatAdapter implements RowingBoat {

    private final FishingBoat boat = new FishingBoat();

    @Override
    public void row() {
        boat.sail();
    }

}
