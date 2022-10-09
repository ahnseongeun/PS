package chapter04_visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SoldierVisitor
 */
public class SoldierVisitor implements UnitVisitor{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void visitSoldier(Soldier soldier) {
        logger.info("Greetings {}", soldier);
    }

    @Override
    public void visitSergeant(Sergeant sergeant) {

    }

    @Override
    public void visitCommander(Commander commander) {

    }
}
