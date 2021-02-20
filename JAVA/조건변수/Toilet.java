package JAVA.조건변수;

class Toilet {

    public int paper;

    public Toilet() {
        this.paper = 7;
    }

    public void setPaper(int paper) {
        this.paper = paper;
    }

    public int getPaper() {
        return paper;
    }

    public void usedPaper() {
        this.paper--;
    }

}
