package CodingTest.Tmon;


class HairInformation {
    private int minute;
    private int statePlus;
    private int price;
    public HairInformation(int minute, int statePlus, int price) {
        this.minute=minute;
        this.statePlus=statePlus;
        this.price=price;
    }
    public int getMinute() {
        return minute;
    }

    public int getStatePlus() {
        return statePlus;
    }

    public int getPrice() {
        return price;
    }

}