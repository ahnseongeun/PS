package chapter4_visitor;

import java.util.Arrays;

/**
 * Interface for the nodes in hiearachy.
 */
public abstract class Unit {

    private final Unit[] children;

    public Unit(Unit[] children) {
        this.children = children;
    }

    public void accept(UnitVisitor visitor) {
        Arrays.stream(children)
                .forEach(child -> child.accept(visitor));
    }

}
