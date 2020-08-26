package practice;

public class Overload_1 {
    public static void main(String[] args) {
        Overload_1 overload1 = new Overload_1();
        System.out.println(overload1.foo(1));
        System.out.println(overload1.foo("abc"));
    }

    public int foo(int a ){
        return a+1;

    }
    public String foo(String a ){
        return a;
    }
    //不允许这样
    //    public String foo(int a ){
    //        return a;
    //    }
}
