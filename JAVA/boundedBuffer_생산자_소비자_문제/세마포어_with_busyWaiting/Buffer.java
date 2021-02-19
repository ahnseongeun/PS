package JAVA.boundedBuffer_생산자_소비자_문제.세마포어_with_busyWaiting;


import java.util.concurrent.Semaphore;

/**
 * 1번 케이스 데드락 현상 -> 왜 데드락 현상이 일어나는 것이지??
 * 2번 케이스 원하는 결과 값과 오차가 난다.
 * 느리게라도 가야하는 것 아닌가??
 *
 */
class Buffer {
    int[] buf;
    int size;
    int count;
    int in;
    int out;
    Semaphore mutex;   // 세마포 선언

    Buffer(int size) {
        buf = new int[size];
        this.size = size;
        count = in = out = 0;
        mutex = new Semaphore(1);
    }

    void insert(int item) {
        /* check if buf is full */
        while (count == size)
            Thread.onSpinWait();
        /* buf is not full */
        try {
            mutex.acquire();
            buf[in] = item;
            in = (in+1)%size;
            count++;
            mutex.release();
        } catch(InterruptedException e) {}
    }

    int remove() {
        /* check if buf is empty */
        while (count == 0)
            Thread.onSpinWait();
        /* buf is not empty */
        try {
            mutex.acquire();
            int item = buf[out];
            out = (out+1)%size;
            count--;
            mutex.release();
            return item;
        } catch(InterruptedException e) {}

        return -1;
    }
}
