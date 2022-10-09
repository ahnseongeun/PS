package chapter01_abstact_document.main;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TEST {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    @Test
    public void test() {
        LOGGER.info("TEST GOOD!");
    }
}
