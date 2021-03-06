package reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 基础使用
 */
public class ReentrantLockTest {
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                test();
            }
        }, "线程A").start();
        new Thread(new Runnable() {
            public void run() {
                test();
            }
        }, "线程B").start();
    }
    public static void test(){
        lock.lock();
        System.out.println(Thread.currentThread().getName()+" -- 获取到了锁");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName()+" -- 释放了锁");
            lock.unlock();
        }

    }
}
