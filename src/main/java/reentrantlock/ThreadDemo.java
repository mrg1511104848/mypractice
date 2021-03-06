package reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @Classname ThreadDemo
 * @Description TODO
 * @Date 2021/3/6 0006 21:36
 * @Created by Administrator
 */
public class ThreadDemo implements Runnable {
    Lock firstLock ;
    Lock secondLock ;

    public ThreadDemo(Lock firstLock, Lock secondLock) {
        this.firstLock = firstLock;
        this.secondLock = secondLock;
    }

    public void run() {
        try {
            firstLock.lock();
            System.out.println(Thread.currentThread().getName()+" >> lock");
            Thread.sleep(1000);
            secondLock.lock();
            System.out.println(Thread.currentThread().getName()+" >> lock");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName()+" >> unlock");
            firstLock.unlock();
            secondLock.unlock();
            System.out.println(Thread.currentThread().getName()+" >> unlock");
        }

    }
}
