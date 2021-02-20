package JAVA.조건변수;

import java.sql.Time;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock이라는 하나의 공유 변수를 통해서 한번에 한 사람씩
 * 화장실에 사람이 들어가서 휴지를 한장씩 사용할때마다 청소부가 검사를 하고
 * 휴지가 비어있으면 다시 채우는 로직이다.
 */
public class 조건변수예제 {

    private static Toilet toilet = new Toilet();
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition forCleaner = lock.newCondition();
    private static Condition forPerson = lock.newCondition();

    public static void main(String[] args) {

        // 관리하는 화장실을 지정
        Cleaner cleaner = new Cleaner(toilet, lock, forCleaner, forPerson);
        Thread cleanerThread = new Thread(cleaner, "Cleaner");
        cleanerThread.start();

        Person[] people = new Person[7];
        for (int i = 0; i < people.length; i++) {
            // 사람 객체 생성, 이 사람이 사용해야하는 화장실도 지정
            people[i] = new Person(toilet, lock, forCleaner, forPerson);
            Thread th = new Thread(people[i], "Person-" + i);
            // 사람 객체를 행동시키는 스레드를 실행
            th.start();
        }
    }
}
