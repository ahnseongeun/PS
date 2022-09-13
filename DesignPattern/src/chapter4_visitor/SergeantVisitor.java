package chapter4_visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SergeantVisitor implements UnitVisitor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void visitSoldier(Soldier soldier) {

    }

    @Override
    public void visitSergeant(Sergeant sergeant) {
        logger.info("Hello {}", sergeant);
    }

    @Override
    public void visitCommander(Commander commander) {

    }
}
