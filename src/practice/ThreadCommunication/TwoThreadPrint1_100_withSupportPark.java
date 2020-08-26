package practice.ThreadCommunication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TwoThreadPrint1_100_withSupportPark {

    static int a;
    static Lock lock = new ReentrantLock();
    static Condition condOne = lock.newCondition();


    public static void main(String[] args) {

        new Thread(()->{


            lock.lock();
            try {
                while(a<=100){

                    if(a%2==1) System.out.println("A: "+ a++);

                    condOne.signal();
                    if(a==100) break;
                    condOne.await();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }


        }).start();

        new Thread(()->{


            lock.lock();
            try {
                while(a<=100){

                    if(a%2==0) System.out.println("B: "+a++);

                    condOne.signal();
                    if(a==101) break;
                    condOne.await();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }


        }).start();



    }
}
