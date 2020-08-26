package week5;

public class Test2 {
    public static void main (String[] args){
        AbstractClassExample ac2 = new AbstractExtendClassExample();
        ac2.func1();

        System.out.println("---interface test-----");
        InterfaceExample ie2 = new InterfaceImplementExample();
        ie2.func1();
        System.out.println(InterfaceExample.x);
        ie2.func2();

    }
}

abstract class AbstractClassExample {

    protected int x;
    private int y;

    public abstract void func1();

    public void func2() {
        System.out.println("func2");
    }
}

class AbstractExtendClassExample extends AbstractClassExample {
    @Override
    public void func1() {
        System.out.println("func1");
    }
}

interface InterfaceExample {

    void func1();
    /*从 Java 8 开始，接口也可以拥有默认的方法实现，
    这是因为不支持默认方法的接口的维护成本太高了。
    * java8以后，interface可以有自己的默认方法（必须用default修饰）
    * */
    default void func2(){
        System.out.println("func2");
    }

    int x = 123;
    // int y;               // Variable 'y' might not have been initialized
    int z = 0;       // Modifier 'public' is redundant for interface fields
    // private int k = 0;   // Modifier 'private' not allowed here
    // protected int l = 0; // Modifier 'protected' not allowed here
    // private void fun3(); // Modifier 'private' not allowed here
}

class InterfaceImplementExample implements InterfaceExample {
    @Override
    public void func1() {
        System.out.println("func1");
    }

/*    public void func2(){
        System.out.println("override func2");
    }*/
}