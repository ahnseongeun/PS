package chapter9_async_method_invocation;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

@Slf4j
public class App {

    private static Logger logger = LoggerFactory.getLogger(App.class);
    private static final String ROCKET_LAUNCH_LOG_PATTERN = "Space rocket <%s> launched successfully";

    public static void main(String[] args) throws Exception {

        var executor = new ThreadAsyncExecutor();

        final var asyncResult1 = executor.startProcess(lazyval(10, 500));
        final var asyncResult2 = executor.startProcess(lazyval("test", 300));
        final var asyncResult3 = executor.startProcess(lazyval(50L, 500));
        final var asyncResult4 = executor.startProcess(lazyval(20, 400),
            callback("Deploying lunar rover"));
        final var asyncResult5 =
                executor.startProcess(lazyval("callback", 600), callback("Deploying lunar rover"));
        Thread.sleep(350);
        logger.info("Mission command is sipping coffee");

        // wait for completion of the tasks
        final var result1 = executor.endProcess(asyncResult1);
        final var result2 = executor.endProcess(asyncResult2);
        final var result3 = executor.endProcess(asyncResult3);
        asyncResult4.await();
        asyncResult5.await();

        // log the results of the tasks, callbacks log immediately when complete
        logger.info(String.format(ROCKET_LAUNCH_LOG_PATTERN, result1));
        logger.info(String.format(ROCKET_LAUNCH_LOG_PATTERN, result2));
        logger.info(String.format(ROCKET_LAUNCH_LOG_PATTERN, result3));

    }

    /**
     * Creates a callable that lazily evaluates to given value with artificial delay.
     *
     * @param value       value to evaluate
     * @param delayMillis artificial delay in milliseconds
     * @return new callable for lazy evaluation
     */
    private static <T> Callable<T> lazyval(T value, long delayMillis) {
        return new Callable<T>() {
            @Override
            public T call() throws Exception {
                Thread.sleep(delayMillis);
                logger.info(String.format(ROCKET_LAUNCH_LOG_PATTERN, value));
                return value;
            }
        };
    }

    /**
     * Creates a simple callback that logs the complete status of the async result.
     *
     * @param name callback name
     * @return new async callback
     */
    private static <T> AsyncCallback<T> callback(String name) {
        return (value, ex) -> {
            if (ex.isPresent()) {
                logger.info(name + " failed: " + ex.map(Exception::getMessage).orElse(""));
            } else {
                logger.info(name + " <" + value + ">");
            }
        };
    }
}
