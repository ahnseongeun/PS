package JAVA.boundedBuffer_생산자_소비자_문제.세모포어가없을때;


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
    Buffer(int size) {
        buf = new int[size];
        this.size = size;
        count = in = out = 0;
    }
    void insert(int item) {
        /* check if buf is full */
        while (count == size) {
            System.out.println("생산자에서 무한루프중입니다~~");
        }
        /* buf is not full */
        buf[in] = item;
        in = (in+1)%size;
        count++;
    }
    int remove() {
        /* check if buf is empty */
        while (count == 0){
            System.out.println("소비자에서 무한루프중입니다~~");
        }
        /* buf is not empty */
        int item = buf[out];
        out = (out+1)%size;
        count--;
        return item;
    }
}
