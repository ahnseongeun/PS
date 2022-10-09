package chapter08_arrange_act_assert;

import lombok.AllArgsConstructor;

/**
 * Arrange/Act/Assert (AAA) is a unit test pattern. In this simple example, we have a ({@link Cash})
 * object for plus, minus and counting amount.
 */
@AllArgsConstructor
public class Cash {

    private int amount;

    void plus(int addend) {
        amount += addend;
    }

    boolean minus(int subtrahend) {
        if ( amount >= subtrahend) {
            amount -= subtrahend;
            return true;
        } else {
            return false;
        }
    }

    int count() {
        return amount;
    }
}
