package JAVA.boundedBuffer_생산자_소비자_문제.세모포어가없을때;

import JAVA.boundedBuffer_생산자_소비자_문제.세마포어가있을때.Semaphore;


/**
 * 1번 케이스 데드락 현상 -> 왜 데드락 현상이 일어나는 것이지??
 * 2번 케이스 원하는 결과 값과 오차가 난다.
 * 느리게라도 가야하는 것 아닌가??
 *
 */
class Buffer {

    private static int BUFFER_SIZE;
    private int count, in, out;
    private int[] buffer;
    private int count1 = 0;

    public int getCount() {
        return count;
    }

    public int getCount1() {
        return count1;
    }

    public Buffer(int bufferSize){
        this.count = 0;
        this.in = 0;
        this.out = 0;
        this.buffer = new int[bufferSize];
        BUFFER_SIZE = bufferSize;
    }

    /* Producers call this method */
    public void insert(int item){
        while(count == BUFFER_SIZE){
//            try{
//                wait();
//            } catch (InterruptedException e) {
//                System.out.println("버퍼가 다 차지 않았습니다.");
//            }
        }
        buffer[in] = item;
        in = (in + 1) % BUFFER_SIZE;
        count++;
        count1++;
        //notify();
    }

    /* Consumers call this method*/
    public int remove(){

        //remove an item from the buffer
        while(count == 0){
//            try{
//                wait();
//            } catch (InterruptedException e) {
//                System.out.println("버퍼가 비었습니다.");
//            }
        }
        int item = buffer[out];
        out = (out + 1) % BUFFER_SIZE;
        count--;
//        notify();
        return item;
    }

}
