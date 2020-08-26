package week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
public class GenericTestDemo {

    public static void main(String[] args)
    {
        List<Integer> intList = new ArrayList<>();
        List<Double> douList = new ArrayList<>();
        List<String> strList = new ArrayList<>();

        intList.add(1);
        intList.add(2);
        intList.add(2);
        List<Integer> res = reverseList(intList);
        for(Integer a : intList){
            System.out.println(a);
        }
        for(Integer a : res){
            System.out.println(a);
        }


        douList.add(1.1);
        douList.add(2.2);
        douList.add(3.3);
        List<Double> b = reverseList(douList);
        for(Double d : b){
            System.out.println(d);
        }

        strList.add("Nuo");
        strList.add("you, ");
        strList.add("Love");
        List<String> e = reverseList(strList);
        for(String s : e ){
            System.out.println(s);
        }

    }

    private static < T > List<T> reverseList(List<T> t)
    {
        List<T> res = new ArrayList<>();
        res.addAll(t);
        Collections.reverse(res);
        return res;
    }



}
