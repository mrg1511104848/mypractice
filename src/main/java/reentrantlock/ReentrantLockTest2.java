package reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁的实现 ： 谁等待时间长，谁先获取锁
 */
public class ReentrantLockTest2 {
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
        new Thread(new Runnable() {
            public void run() {
                test();
            }
        }, "线程C").start();
        new Thread(new Runnable() {
            public void run() {
                test();
            }
        }, "线程D").start();
    }
    public static void test(){
        for (int i = 0; i < 2; i++) {
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
}
