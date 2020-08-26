package week10;


import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int count = 0;
        for(int i =1;i<=a;i++){ //城镇
            for(int j = 1; j<=b;j++){//街道
                if(Math.abs(i-j)%3!=0) continue;
                for(int n=1;n<=c;n++){//楼房
                    if((n+j)%5!=0 ) continue;
                    if((n*i)%4!=0 ) continue;
                    for(int m=1;m<=d;m++){//公寓
                        if(!checkIt(i,m)) continue;
                        else count++;
                    }
                }
            }

        }
        System.out.println(count);
    }

    public static boolean checkIt(int i,int n){
        for(int j =2;j<=i&&j<=n;j++){
            if(i%j==0&&n%j==0) return false;
        }
        return true;

    }
}