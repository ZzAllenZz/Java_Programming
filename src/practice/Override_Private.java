package practice;

public class Override_Private {
    public static void main(String[] args) {
        Father father = new Son();

    }
}


class Father{

    private int a = 1;
    private int foo( int a ){
        return a+1;
    }

    public static void main(String[] args) {
        Father father = new Father();
        System.out.println(father.foo(10));
        Father father1 = new Son();
        System.out.println(father1.foo(10));
    }
}

class Son extends  Father{
    private int foo(int a ){
        return a-1;
    }

    public static void main(String[] args) {
        Son son = new Son();
        System.out.println(son.foo(10));

    }
}