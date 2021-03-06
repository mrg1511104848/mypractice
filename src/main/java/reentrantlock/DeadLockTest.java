package reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 响应中断：一个线程获取不到锁，不会一直等下去。ReentrantLock会给个中断响应
 */
public class DeadLockTest {
    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadDemo(lock1,lock2));
        Thread thread2 = new Thread(new ThreadDemo(lock2,lock1));
        thread1.start();
        thread2.start();
//        thread1.interrupt();
    }
}
