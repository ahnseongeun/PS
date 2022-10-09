package chapter02_abstract_factory.elf;

import chapter02_abstract_factory.Army;
import chapter02_abstract_factory.Castle;
import chapter02_abstract_factory.King;
import chapter02_abstract_factory.KingdomFactory;

public class ElkKingdomFactory implements KingdomFactory {

    @Override
    public Castle createCastle() {
        return new ElfCastle();
    }

    @Override
    public King createKing() {
        return new ElfKing();
    }

    @Override
    public Army createArmy() {
        return new ElfArmy();
    }
}
