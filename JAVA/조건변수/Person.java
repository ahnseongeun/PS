package JAVA.조건변수;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Person implements Runnable {

    private Toilet toilet;
    private ReentrantLock lock;
    private Condition forCleaner;
    private Condition forPerson;

    // 사용해야하는 화장실을 지정
    // lock, lock을 위한 Condition 인스턴스 생성
    public Person(Toilet toilet, ReentrantLock lock, Condition forCleaner, Condition forPerson) {
        this.toilet = toilet;
        this.lock = lock;
        this.forCleaner = forCleaner;
        this.forPerson = forPerson;

    }

    // 화장실의 휴지가 있는지 확인
    public boolean checkToilet() {
        return toilet.getPaper() >= 1;
    }

    public void usePaper() {
        // 휴지 하나 사용 후 나머지 휴지를
        toilet.usedPaper();
    }

    public void run() {

        String name = Thread.currentThread().getName();
        //System.out.println(name);
        while (true) {

            // 화장실은 한사람만 사용 가능
            lock.lock(); //호출 스레드에게 락 소유권을 주고 제어를 반환한다.

            try {

                // 화장실에 휴지가 있는지 확인
                // 휴지 없으면 계속 대기
                while (toilet.getPaper() < 1) {

                    System.out.println(name + " is waiting for replacing paper.");

                    try {
                        // 대기 중인 청소부 소환
                        forCleaner.signal();
                        // 휴지가 없으므로 대기 pool로 이동
                        forPerson.await();
                        Thread.sleep(500);
                        System.out.println(name + " wakes.");
                    }
                    //
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                // 화장실 볼 일을 보고 휴지를 사용 후 화장실 시용을 종료
                System.out.println(name + " uses toilet.");
                usePaper();
                try {
                    // 휴지가 없으면 다른 사람을 위해 청소부에게 알린다.
                    if (toilet.getPaper() <= 0) {
                        forCleaner.signal();
                    }
                    // 자신은 화장실을 나간다.
                    forPerson.await();
                    Thread.sleep(500);
                }
                //
                catch (Exception e) {
                }
            }
            //
            finally {
                lock.unlock();
            }
        }
    }
}
