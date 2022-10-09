package chapter07_ambassador;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceAmbassador implements RemoteServiceInterface{

    private static final int RETRIES = 3;
    private static final int DELAY_MS = 3000;

    public ServiceAmbassador() { }

    @Override
    public long doRemoteFunction(int value) {
        return safeCall(value);
    }

    private long safeCall(int value) {
        return 1;
    }
}
