package chapter5_acyclic_visitor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Hayes implements Modem{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void accept(ModemVisitor modemVisitor) {
        if (modemVisitor instanceof HayesVisitor) {
            ((HayesVisitor) modemVisitor).visit(this);
        } else {
            logger.info("Only HayesVisitor is allowed to visit Hayes modem");
        }
    }

    @Override
    public String toString() {
        return "Hayes modem";
    }
}
