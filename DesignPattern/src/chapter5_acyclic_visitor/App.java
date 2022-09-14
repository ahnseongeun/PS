package chapter5_acyclic_visitor;

public class App {
    public static void main(String[] args) {
        var conUnix = new ConfigureForUnixVisitor();
        var conDos = new ConfigureForDosVisitor();

        var zoom = new Zoom();
        var hayes = new Hayes();

        hayes.accept(conDos);
        zoom.accept(conDos);
        hayes.accept(conUnix);
        zoom.accept(conUnix);
    }
}
