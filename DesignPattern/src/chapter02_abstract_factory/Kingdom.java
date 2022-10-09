package chapter02_abstract_factory;

import chapter02_abstract_factory.elf.ElkKingdomFactory;
import chapter02_abstract_factory.orc.OrcKingdomFactory;

public class Kingdom {

    private King king;
    private Castle castle;
    private Army army;

    public static class FactoryMaker {

        public enum KingdomType {
            ELF, ORC
        }

        public static KingdomFactory makeFactory(KingdomType type) {
            switch (type) {
                case ELF:
                    return new ElkKingdomFactory();
                case ORC:
                    return new OrcKingdomFactory();
                default:
                    throw new IllegalArgumentException("KingdomType not supported");
            }
        }

    }

    public King getKing() {
        return king;
    }

    public Castle getCastle() {
        return castle;
    }

    public Army getArmy() {
        return army;
    }

    public void kingdomSetting(King king, Castle castle, Army army) {
        this.king = king;
        this.castle = castle;
        this.army = army;
    }

}
