package week11;


import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            Wood[] array = new Wood[num];
            for(int j = 0;j<num;j++){
                array[j] = new Wood();
                array[j].len = sc.nextInt();
            }
            for(int j = 0;j<num;j++){
                array[j].weight = sc.nextInt();
            }
            WoodComparator wc = new WoodComparator();
            Arrays.sort(array,wc);
           for(int j=0;j<num;j++){
                System.out.println(array[j].len);
                System.out.println(array[j].weight);
            }
            int fee = 1;
            for(int j=1;j<num;j++){
                if(array[j].len<array[j-1].len || array[j].weight<array[j-1].weight){
                    fee++;
                }
            }
            System.out.println(fee);
        }
    }
}

class Wood{
    public int len;
    public int weight;
}
class WoodComparator implements Comparator<Wood>{

    @Override
    public int compare(Wood wood, Wood t1) {



        if(wood.len==t1.len){
            if(wood.weight>t1.weight){
                return 1;
            }else return -1;
        }
        else {
            if(wood.len>t1.len){
                return 1;
            }else return -1;
        }
    }
}