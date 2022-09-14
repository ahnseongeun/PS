package chapter5_acyclic_visitor;

public interface HayesVisitor extends ModemVisitor{
    void visit(Hayes hayes);
}
