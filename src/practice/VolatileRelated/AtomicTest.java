package practice.VolatileRelated;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/**
*       验证volatile的不保证原子性
 *  *   验证volatile保证可见性
* */

public class AtomicTest {
    //比较加不加volatile
    static volatile boolean flag = false;

    static AtomicInteger a = new AtomicInteger(0);
    static volatile int b = 1;
    public static void main(String[] args) {
        testAtomic();
        testVisible();
    }

    private static void testVisible() {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                flag = true;
                System.out.println(Thread.currentThread().getName() + "\talter flag");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"b").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\tstart in");
            while(!flag){

            }
            System.out.println(Thread.currentThread().getName() + "\tend");


        },"a").start();
    }


    public static void testAtomic(){
        for (int i = 0; i <20 ; i++) {
            new Thread(()->{
                for(int j =0;j<1000;j++){
                    b++;
                    a.addAndGet(1);
                    /**
                     * 打印和不打印 差别很大,为什么。是因为 println是同步方法吗。。。
                    * */
//                    System.out.println("b:"+b);
//                    System.out.println("a: "+a);
                }
            }).start();
        }

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\tfinally b = " + b);
        System.out.println(Thread.currentThread().getName() + "\tfinally a = " + a);
    }
}
