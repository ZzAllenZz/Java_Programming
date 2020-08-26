package practice.ThreadCommunication;

public class TwoThreadPrint1_100_withLock {

    static int a = 1;

    static Object lock = new Object();

    public static void main(String[] args) {

        new Thread (()->{
            synchronized (lock){
                while(a<=100){
                    if(a%2==1) System.out.println("A: "+ a++);
                    lock.notifyAll();
                    /**
                     * //最后一次不能再等待，否则会一直死等
                    * */
                    if(a==100) break;
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        }).start();

        new Thread (()->{
            synchronized (lock){
                while(a<=100){
                    if(a%2==0) System.out.println("B: "+ a++);
                    lock.notifyAll();
                    if(a==101) break;
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        }).start();


/**      new Thread (()->{
            while(a<=100){
                synchronized (lock){
                    if(a<=100&&a%2==1){
                        System.out.println("A: "+ a++);
                    }

                }
            }
        }).start();

        new Thread (()->{
            while(a<=100){
                synchronized (lock){
                    if(a<=100&&a%2==0){
                        System.out.println("B: "+ a++);
                    }

                }
            }
        }).start();*/



    }
}
