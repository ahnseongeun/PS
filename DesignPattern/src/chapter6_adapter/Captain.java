package chapter6_adapter;

public class Captain {

    private final RowingBoat rowingBoat;

    public Captain(FishingBoatAdapter fishingBoatAdapter) {
        this.rowingBoat = fishingBoatAdapter;
    }

    public void row() {
        rowingBoat.row();
    }
}
