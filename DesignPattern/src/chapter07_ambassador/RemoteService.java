package chapter07_ambassador;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Thread.sleep;

@Slf4j
public class RemoteService implements RemoteServiceInterface{

    private static final int THRESHOLD = 200;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static RemoteService service = null;
    private final RandomProvider randomProvider;

    /**
     * this constructor is used for testing purposes only
     * @param randomProvider
     */
    public RemoteService(RandomProvider randomProvider) {
        this.randomProvider = randomProvider;
    }

    private RemoteService(){
        this(Math::random);
    }

    static RemoteService getRemoteService() {
        if (service == null) {
            service = new RemoteService();
        }
        return service;
    }




    @Override
    public long doRemoteFunction(int value) {

        long waitTime = (long) Math.floor(randomProvider.random() * 1000);

        try {
            sleep(waitTime);
        } catch (InterruptedException e) {
            logger.error("Thread sleep state interrupted", e);
            Thread.currentThread().interrupt();
        }

        return waitTime <= THRESHOLD ? value * 10L
                : RemoteServiceStatus.FAILURE.getRemoteServiceStatusValue();
    }
}
