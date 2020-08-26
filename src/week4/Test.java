package week4;
import week3.CloneExample;
import java.util.*;
public class Test extends CloneExample {
    private int number;

    public Test(int number) {
        this.number = number;
    }

    public static void main(String[] args){
        Id<Integer> id = new Id<>(123);
        System.out.println(id.key);
        System.out.println(id.getKey());
        Unit y = Unit.u;
        Unit x = Unit.u;
        System.out.println(x==y); //true

        Tuple<Integer,String> t = new Tuple<>(456,"HELLO");
        System.out.println(t.getKey());
        System.out.println(t.getValue());
        System.out.println(t.getTuple().key);


        String what = "what";
        Integer a = 123;
        System.out.println(a.equals(new Integer(123)));
        System.out.println(what.hashCode());
        System.out.println(a);
        System.out.println(a.hashCode());
        System.out.println(a.toString());

        Test test = new Test(567);
        System.out.println(test.toString());

        System.out.println("------Clone Test--------");
        CloneExample clone0 = new CloneExample();
        CloneExample clone1 = null;
        try{
            clone1 = clone0.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }

        System.out.println(clone0.a);
        System.out.println(clone1 == clone0);
        System.out.println(clone1.equals(clone0));

        CloneExample2 example2 = new CloneExample2();
        CloneExample2 example21 = null;
        try{
           example21 = example2.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }

        System.out.println("------type erasure test-----");

        List<String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();

        System.out.println(l1.getClass() == l2.getClass());
        System.out.println(l1.getClass());



    }
}
