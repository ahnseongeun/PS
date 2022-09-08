package chapter2_abstract_factory;

public interface KingdomFactory {
    Castle createCastle();
    King createKing();
    Army createArmy();
}
