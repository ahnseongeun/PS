package JAVA.boundedBuffer_생산자_소비자_문제.세마포어_with_NonBusyWating;


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
    Semaphore mutex, full, empty;

    Buffer(int size) {
        buf = new int[size];
        this.size = size;
        count = in = out = 0;
        mutex = new Semaphore(1);
        full = new Semaphore(0);
        empty = new Semaphore(size);
    }

    void insert(int item) {
        try {
            empty.acquire();    // 버퍼의 비어있는 공간을 1 감소시킨다.(비어있는 공간이 없으면 block)
            mutex.acquire();
            buf[in] = item;
            in = (in+1)%size;
            count++;
            mutex.release();
            full.release();    // 버퍼의 찬 공간을 1 증가시킨다.
        } catch(InterruptedException e) {}
    }

    int remove() {
        try {
            full.acquire();    // 버퍼의 찬 공간을 1 감소시킨다.(버퍼가 모두 비어있으면 block)
            mutex.acquire();
            int item = buf[out];
            out = (out+1)%size;
            count--;
            mutex.release();
            empty.release();   // 버퍼의 비어있는 공간을 1 증가시킨다.
            return item;
        } catch(InterruptedException e) {}
        return -1;
    }
}
