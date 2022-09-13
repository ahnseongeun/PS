package chapter4_visitor;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class CommanderVisitor implements UnitVisitor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void visitSoldier(Soldier soldier) {

    }

    @Override
    public void visitSergeant(Sergeant sergeant) {

    }

    @Override
    public void visitCommander(Commander commander) {
        logger.info("Good to see you {}", commander);
    }
}
