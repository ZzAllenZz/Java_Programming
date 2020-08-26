package week9;

import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int count = 1;
        int round = 1;
        input = input -2;
        while(input>=0){
            count +=findFact(input+round)/(findFact(input)*findFact(round));
            input = input -2;
            round++;
        }
        System.out.println(count);
        System.out.println(findFact(2));
    }


    public static int findFact(int num){
        if(num==0|| num ==1) return 1;
        return num*findFact(num-1);
    }
}