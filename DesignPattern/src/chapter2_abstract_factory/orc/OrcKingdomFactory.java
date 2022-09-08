package chapter2_abstract_factory.orc;

import chapter2_abstract_factory.Army;
import chapter2_abstract_factory.Castle;
import chapter2_abstract_factory.King;
import chapter2_abstract_factory.KingdomFactory;

public class OrcKingdomFactory implements KingdomFactory {

    @Override
    public Castle createCastle() {
        return new OrcCastle();
    }

    @Override
    public King createKing() {
        return new OrcKing();
    }

    @Override
    public Army createArmy() {
        return new OrcArmy();
    }
}
