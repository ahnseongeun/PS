package chapter7_ambassador;

public class App {
    public static void main(String[] args) {
        var host1 = new Client();
        var host2 = new Client();
        host1.useService(12);
        host2.useService(73);
    }
}
