package chapter10_balking;

import java.util.concurrent.TimeUnit;

public interface DelayProvider {
    void executeAfterDelay(long interval, TimeUnit timeUnit, Runnable task);
}
