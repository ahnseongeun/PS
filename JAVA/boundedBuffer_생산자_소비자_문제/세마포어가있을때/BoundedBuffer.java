package JAVA.boundedBuffer_생산자_소비자_문제.세마포어가있을때;

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
        mutex.P();

        ++count;
        buffer[in] = item;
        in = (in + 1) % BUFFER_SIZE;

        if(count == BUFFER_SIZE)
            System.out.println("Producer Entered " + item + "Buffer FULL");
        else
            System.out.println("Producer Entered " + item + "Buffer Size = " + count);

        mutex.V();
        full.V();
//        buffer[in] = item;
//        in = (in + 1) % BUFFER_SIZE;
//        count++;
//        notify();
    }

    /* Consumers call this method*/
    public synchronized E remove(){
        E item;
        full.P();
        mutex.P();
        //remove an item from the buffer
        --count;
        item = buffer[out];
        out = (out + 1) % BUFFER_SIZE;
        if(count == 0){
            System.out.println("Consumer Consumed "+ item + "Buffer EMPTY");
        }else{
            System.out.println("Consumer Consumed "+ item + "Buffer Size = " + count);
        }
        mutex.V();
        empty.V();
        return item;
    }

}
