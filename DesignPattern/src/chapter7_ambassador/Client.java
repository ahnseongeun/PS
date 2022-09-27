package chapter7_ambassador;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Client {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ServiceAmbassador serviceAmbassador = new ServiceAmbassador();

    long useService(int value) {

        var result = serviceAmbassador.doRemoteFunction(value);
        logger.info("Service result: {} ", result);
        return result;
    }

}
