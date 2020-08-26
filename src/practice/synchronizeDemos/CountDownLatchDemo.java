package practice.synchronizeDemos;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        countDownLatchTest();
    }

    private static void countDownLatchTest() {
        CountDownLatch countDownLatch = new CountDownLatch(7);

        new Thread(()->{
            try {
                System.out.println("班长准备锁门,等同学都出去");
                countDownLatch.await();
                System.out.println("班长锁门");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"班长").start();

        for(int i =1 ;i<=7;i++){
            new Thread (()->
            {
                System.out.println(Thread.currentThread().getName() + "\t 走出班门");
                countDownLatch.countDown();
            },"Student "+i).start();
        }
    }
}
