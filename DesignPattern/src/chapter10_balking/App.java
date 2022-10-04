package chapter10_balking;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class App {
    public static void main(String... args) throws InterruptedException {
        final var washingMachine = new WashingMachine();
        var executorService = Executors.newFixedThreadPool(10);

        for ( int i = 0; i < 10; i++) {
            Thread.sleep(10);
            executorService.execute(washingMachine::wash);
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdown();
            }
        } catch ( InterruptedException ie ) {
            log.error("ERROR: Waiting on executor service shutdown!");
            Thread.currentThread().interrupt();
        }
    }
}
