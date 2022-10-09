package chapter09_async_method_invocation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.Callable;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Slf4j
class ThreadAsyncExecutorTest {

    @Captor
    private ArgumentCaptor<Optional<Exception>> optionalCaptor;

    @Mock
    private Callable<Object> task;

    @Mock
    private AsyncCallback<Object> callback;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * new Object와 startProcess로 return된 Object가 동일한지 검사??
     */
    @Test
    void testSuccessfulTaskWithoutCallback() throws Exception {
        assertTimeout(Duration.ofMillis(3000),() -> {
            // Instantiate a new executor and start a new 'null' task ...
            final var executor = new ThreadAsyncExecutor();

            final var result = new Object();
            when(task.call()).thenReturn(result);


            final var asyncResult = executor.startProcess(task);
            assertNotNull(asyncResult);

            // Prevent timing issues, and wait until the result is available
            asyncResult.await();
            assertTrue(asyncResult.isCompleted());

            // Our task should only execute once ...
            verify(task, times(1)).call();

            log.info("result = {}, asyncResult = {} ", result, asyncResult.getValue());
            assertSame(result, asyncResult.getValue());
        });
    }

    @Test
    void testSuccessfulWithCallback() throws Exception {
        assertTimeout(Duration.ofMillis(3000), () -> {
            // Instantiate a new executor and start a new 'null' task ...
            final var executor = new ThreadAsyncExecutor();

            final var result = new Object();
            when(task.call()).thenReturn(result);

            final var asyncResult = executor.startProcess(task, callback);
            assertNotNull(asyncResult);
            asyncResult.await();
            assertTrue(asyncResult.isCompleted());


            verify(task, times(1)).call();

            // ...same for the callback, we expect our object
            verify(callback, times(1))
                    .onComplete(eq(result), optionalCaptor.capture());

            final var optionalException
                    = optionalCaptor.getValue();
            log.info("optionalException : {}", optionalException);
            assertNotNull(optionalException);
            assertFalse(optionalException.isPresent());

            // ... and the result should be exactly the same object
            assertSame(result, asyncResult.getValue());

        });
    }



}
