package chapter05_acyclic_visitor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class ConfigureForUnixVisitor implements AllModemVisitor{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void visit(Zoom zoom) {
        logger.info(zoom + " used with Unix configurator.");
    }

    @Override
    public void visit(Hayes hayes) {
        logger.info(hayes + " used with Unix configurator.");
    }
}
