package week10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
//用Collections的sort()方法对集合进行排序。
/*
 * 题目：
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */

public class test3 {

    public String PrintMinNumber(Integer [] s) {
        if(s==null) return null;
        String s1="";
        ArrayList<Integer> list=new ArrayList<Integer>(Arrays.asList(s));
//        for(int i=0;i<s.length;i++){
//             list.add(s[i]);
//        }
        Collections.sort(list,new Comparator<Integer>(){//数组里的数两两组合比较，按照比较值更得的顺序升序排序
            public int compare(Integer str1,Integer str2){
                String s1=str1+""+str2;
                String s2=str2+""+str1;
                System.out.println(s1);
                System.out.println(s2);
                System.out.println(s1.compareTo(s2));
                return s1.compareTo(s2);//变成-s1.compareTo(s2)就是降序排序了
            }
        });
        for(int j:list){
            System.out.println("输出为:"+j);
            s1+=j;
        }
        return s1;
    }

    public static void main(String[] args) {

        Integer [] list={3,32,321};
        test3 demo=new test3();
        System.out.println(demo.PrintMinNumber(list));
    }

}