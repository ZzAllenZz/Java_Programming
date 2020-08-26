package practice.ThreadCommunication;

import java.util.concurrent.locks.LockSupport;

//一个线程打印1 2 3 ...
//一个线程打印a b c ...
//一个线程打印A B C ...
//交替打印 1 a A 2 b B 3 c C ... 直到所有字母打印完毕
public class Print1_100_withLockSupport {
    private static int index = 1;


    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        Thread aThread = new Thread(a);
        B b = new B();
        Thread bThread = new Thread(b);
        C c = new C();
        Thread cThread = new Thread(c);

        a.unparkThread = bThread;
        b.unparkThread = cThread;
        c.unparkThread = aThread;

        aThread.start();
        Thread.sleep(1);
        bThread.start();
        Thread.sleep(1);
        cThread.start();



    }

    static class A implements Runnable{
        public Thread unparkThread;
        @Override
        public void run() {
            while(index<=26){
                System.out.println(index++);
                //唤醒B线程
                LockSupport.unpark(unparkThread);

                if(index==27){
                    //最后一次不能再等待，否则会死等
                    break;
                }

                //阻塞自己
                LockSupport.park();
            }
        }
    }

    static class B implements Runnable{
        public Thread unparkThread;
        @Override
        public void run() {
            while(index<=27){
                char c = (char) ('a' + (index - 2));
                System.out.println(c);

                //唤醒C线程
                LockSupport.unpark(unparkThread);

                if(index==27){
                    //最后一次不能再等待，否则会一直死等
                    break;
                }


                //阻塞自己
                LockSupport.park();

            }
        }
    }

    static class C implements Runnable{
        public Thread unparkThread;
        @Override
        public void run() {
            while(index<=27){
                char c = (char) ('A' + (index - 2));
                System.out.println(c);

                if(index==27){
                    //最后一次不能再等待，否则会一直死等
                    break;
                }
                //唤醒A线程
                LockSupport.unpark(unparkThread);

                //阻塞自己
                LockSupport.park();

            }
        }
    }

}

