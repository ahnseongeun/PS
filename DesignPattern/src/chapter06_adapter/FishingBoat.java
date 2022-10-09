package chapter06_adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FishingBoat {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    void sail() {
        logger.info("The fishing boat is sailing");
    }
}
