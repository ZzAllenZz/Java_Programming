package practice.ThreadCommunication;



public class TwoThreadsPrint1_100_WithoutLock {
    static int a = 1;
    static volatile boolean flag = true;

    public static void main(String[] args) {

        new Thread(()->{
            while(a<=100){
                if(flag){
                    System.out.println("A: "+a);
                    a++;
                    flag = false;
                }

            }


        }).start();

        new Thread(()->{
            while(a<=100){
                if(!flag){
                    System.out.println("B: "+a);
                    a++;
                    flag=true;
                }

            }

        }).start();

    }
}
