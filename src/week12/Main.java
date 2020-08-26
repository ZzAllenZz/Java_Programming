package week12;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{5,7,3,2,0,5,10};
       /* Arrays.sort(array);*/
        for(int a:array){
            System.out.println(a);
        }

        List<Integer> list = Arrays.asList(array);
        Collections.sort(list,new myComparator());
        list.forEach(li->{
            System.out.println(li);
            System.out.println("huhuhu");
        });
        for(int a:list){
            System.out.println(a);
        }

    }
}

class myComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer integer, Integer t1) {
/*        if(integer.intValue()==5){
            System.out.println("yes");
            return -1;}*/
        if(integer.intValue()>=t1.intValue()) {
            System.out.println("no");
            return 1;
        }
        else {
            System.out.println("fuck");
            return -1;
        }
    }
}