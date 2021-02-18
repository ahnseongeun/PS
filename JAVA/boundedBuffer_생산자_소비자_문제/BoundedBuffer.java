package JAVA.boundedBuffer_생산자_소비자_문제;

public class BoundedBuffer<E> {

    private static final int BUFFER_SIZE = 2;
    private static final int NAP_TIME = 5;

    private Semaphore mutex;
    private Semaphore empty;
    private  Semaphore full;
    private int count, in, out;
    private E[] buffer;

    public BoundedBuffer(){
        this.count = 0;
        this.in = 0;
        this.out = 0;
        this.buffer = (E[]) new Object[BUFFER_SIZE];
        this.mutex = new Semaphore(1);
        this.empty = new Semaphore(BUFFER_SIZE);
        this.full = new Semaphore(0);
    }

    // producer and consumer will call this to nap
    public static void napping(){
        int sleepTime = (int) (NAP_TIME * Math.random());
        try{
            Thread.sleep(sleepTime*1000);
        } catch (InterruptedException e) {
            System.out.println("napping 에러");
        }
    }

    /* Producers call this method */
    public synchronized void insert(E item){

        empty.P();

        while(count == BUFFER_SIZE){
            try{
                wait();
            }catch (InterruptedException e) {
                System.out.println("생산자 에러");
            }
        }

        buffer[in] = item;
        in = (in + 1) % BUFFER_SIZE;
        count++;
        notify();
    }

    /* Consumers call this method*/
    public synchronized E remove(){
        E item;

        while(count == 0){
            try{
                wait();
            }catch (InterruptedException ie){
                System.out.println("소비자 에러");
            }
        }

        item = buffer[out];
        out = (out + 1) % BUFFER_SIZE;
        count--;

        notify();

        return item;
    }

}
