package chapter3_active_object;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Slf4j
public abstract class ActiveCreature {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private final BlockingQueue<Runnable> requests;

    private final String name;

    private final Thread thread;

    private int status;


    public ActiveCreature(String name) {
        this.name = name;
        this.status = 0;
        this.requests = new LinkedBlockingQueue<Runnable>();
        thread = new Thread(() -> {
            while(true) {
                try {
                    requests.take().run();
                } catch (InterruptedException e) {
                    logger.error(e.getMessage());
                }
            }
        });
        thread.start();
    }

    public void eat() throws InterruptedException {
        requests.put(() -> {
            logger.info("{} is eating!",name());
            logger.info("{} has finished eating!",name());
        });
    }

    public void roam() throws InterruptedException {
        requests.put(() ->
                logger.info("{} has started to roam in the wastelands ", name())
        );
    }

    public String name() {
        return this.name;
    }

    public void kill(int status) {
        this.status = status;
        this.thread.interrupt();
    }

    public int getStatus() {
        return this.status;
    }
}














