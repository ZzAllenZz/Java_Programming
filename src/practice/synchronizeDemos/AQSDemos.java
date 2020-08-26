package practice.synchronizeDemos;

import java.util.HashMap;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class AQSDemos {
    private static CyclicBarrier barrier = new CyclicBarrier(31);
    private static int a = 0;
    private static Mutex mutex = new Mutex();

    public static void main(String[] args) throws Exception{
        String b  = "123";
//      ` 非法
//        b.wait();
//        b.notify();
        for(int i =1 ;i<=30;i++){
            new Thread(()->{
                for(int j = 1;j<=10000;j++){
                    increment1();
                }
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }).start();
        }
        barrier.await();
        System.out.println("加锁前: a=" + a);


        barrier.reset();
        a = 0;
        for(int i =1 ;i<=30;i++){
            new Thread(()->{
                for(int j =1;j<=10000;j++){
                    increment2();
                }
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        barrier.await();
        System.out.println("加锁后, a=" + a);

    }

    public static void increment1(){
        a++;

    }
    public static void increment2(){
        mutex.lock();
        a++;
        mutex.unlock();

    }


}


class Mutex implements java.io.Serializable {
    //静态内部类,继承AQS
    private static class Sync extends AbstractQueuedSynchronizer{
        //是否处于占用状态
        protected boolean isHeldExclusively(){
            return this.getState()==1;
        }
        //当状态为0时,获取锁,CAS操作成功,则state状态为1
        public boolean tryAcquire (int acquires){
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }
        //释放锁，将同步状态state设置为0。
        public boolean tryRelease(int releases){
            if (getState()==0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
    }

    //同步对象完成一些系列复杂的操作,我们需要指向他即可
    private final Sync sync = new Sync();
    //加锁操作,代理到acquire(模板方法)即可. acquire会调用我们之前重写的tryAcquire方法.
    public void lock(){
        sync.acquire(1);
    }
    public void tryLock(){
        sync.tryAcquire(1);
    }
    //释放锁,代理到release(模板方法)上就行,release会调用我们之前写的tryrelease方法
    public void unlock(){
        sync.release(1);
    }
    public boolean isLocked(){
        return sync.isHeldExclusively();
    }




}