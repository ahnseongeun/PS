package chapter10_balking;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class WashingMachine {

    private final DelayProvider delayProvider;
    private WashingMachineState washingMachineState;

    /**
     * Creates a new instance of WashingMachine.
     */
    public WashingMachine() {
        this((interval, timeUnit, task) -> {
            try{
                Thread.sleep(timeUnit.toMillis(interval));
            } catch (InterruptedException ie) {
                log.error("",ie);
                Thread.currentThread().interrupt();
            }
            task.run();
        });
    }

    /**
     * Creates a new instance of WashingMachine using provided delayProvider.
     * This constructor is used only for unit testing purpose.
     * @param delayProvider
     */
    public WashingMachine(DelayProvider delayProvider) {
        this.delayProvider = delayProvider;
        this.washingMachineState = WashingMachineState.ENABLED;
    }

    public WashingMachineState getWashingMachineState() {
        return washingMachineState;
    }

    public void wash() {
        synchronized (this) {
            var machineState = getWashingMachineState();
            log.info("{} : Actual machine state: {}", Thread.currentThread().getName(), machineState);
            if ( this.washingMachineState == WashingMachineState.WASHING ) {
                log.error("Cannot wash if the machine has been already washing!");
                return;
            }
            this.washingMachineState = WashingMachineState.WASHING;
        }
        log.info("{} :  Doing the washing", Thread.currentThread().getName());

        this.delayProvider.executeAfterDelay(30, TimeUnit.MILLISECONDS, this::endOfWashing);
    }

    /**
     * Method responsible of ending the washing by changing machine state.
     */
    public synchronized void endOfWashing() {
        washingMachineState = WashingMachineState.ENABLED;
        log.info("{}: Washing completed. ", Thread.currentThread().getId());
    }

}
