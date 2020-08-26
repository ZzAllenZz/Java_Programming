package practice.synchronizeDemos;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        testCyclicBarrier();
    }

    private static void testCyclicBarrier() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("=======神龙召唤========");
        });

        for(int i = 1;i<=7;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "\t 得到一颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t 重新寻找龙珠");
            },"People "+i).start();
        }

    }
}
