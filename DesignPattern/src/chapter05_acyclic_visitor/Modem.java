package chapter05_acyclic_visitor;

public interface Modem {
    void accept(ModemVisitor modemVisitor);
}
