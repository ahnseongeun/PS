package JAVA.Dining_Philosopher_Problem;

import java.util.concurrent.Semaphore;

class Philosopher extends Thread {
    int id; // philosopher id
    Semaphore lstick, rstick; // left, right chopsticks
    Philosopher(int id, Semaphore lstick, Semaphore rstick) {
        this.id = id;
        this.lstick = lstick;
        this.rstick = rstick;
    }
    public void run() {
        try {
            while (true) {
                lstick.acquire();
                rstick.acquire();
                eating();
                lstick.release();
                rstick.release();
                thinking();
            }
        }catch (InterruptedException e) { }
    }
    void eating() {
        System.out.println("[" + id + "] eating");
    }
    void thinking() {
        System.out.println("[" + id + "] thinking");
    }
}
