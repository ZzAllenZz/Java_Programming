package exam;


import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


public class Main {
    public static void main(String[] args) {
        int i = 0;


//        for(int j =0;j<1;){
//            if(i==100000) break;
//            else System.out.println(i++);
//        }

        CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<Integer>();
        a.add(1);
        a.get(0);


        Integer c = 300;
        Integer b = 300;
        System.out.println(b == c);

        Integer d = 100;
        Integer e = 100;
        System.out.println(d == e);

        Integer f = new Integer(30);
        Integer g = 30;
        System.out.println(f == g);

    }

    public void getA (int a ,String b){

    }

    public void getA (String b,int a){

    }




}

