package JAVA.boundedBuffer_생산자_소비자_문제.유한버퍼_with_java;


/**
 * 1번 케이스 데드락 현상 -> 왜 데드락 현상이 일어나는 것이지??
 * 2번 케이스 원하는 결과 값과 오차가 난다.
 * 느리게라도 가야하는 것 아닌가??
 *
 */
public class BoundedBuffer<E> {
    private E[] buffer;
    private static final int BUFFER_SIZE = 100;
    private int count, in, out;

    public BoundedBuffer() {
        buffer = (E[]) new Object[BUFFER_SIZE];
        count = in = out = 0;
    }

    public int getCount(){
        return count;
    }
    public synchronized void insert(E item) {

        while (count == BUFFER_SIZE){
            try{
                System.out.println("insert 입니다");
                wait();
            } catch (InterruptedException e) {

            }
        }
        buffer[in] = item;
        in = (in + 1) % BUFFER_SIZE;
        count++;
        notify();
    }
    public synchronized E remove() {
        E item;
        /* check if buf is empty */
        while (count == 0){
            try{
                System.out.println("remove 입니다");
                wait();
            } catch (InterruptedException e) {
            }
        }
        /* buf is not empty */
        item = buffer[out];
        out = (out+1) % BUFFER_SIZE;
        count--;
        notify();
        return item;
    }
}
