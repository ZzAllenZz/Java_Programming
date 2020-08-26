package exam;

import java.util.Scanner;

public class Ai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(CountZero(a));
    }

    public static int CountZero (int n){
        int count = 0;
        while(n/5!=0){
            count+=n/5;
            n /=5;
        }
        return count;
    }

}