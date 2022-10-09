package chapter09_async_method_invocation;

import java.util.concurrent.ExecutionException;

public interface AsyncResult<T> {

    /**
     * Status of the async task execution
     */
    boolean isCompleted();

    T getValue() throws ExecutionException;

    void await() throws InterruptedException;
}
