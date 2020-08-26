package week5;
import java.lang.reflect.*;
public class Test3 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException , ClassNotFoundException , IllegalAccessException , InstantiationException {

        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        // 在 A 中存在 show(A obj)，直接调用
        a.show(a); // A.show(A)
        // 在 A 中不存在 show(B obj)，将 B 转型成其父类 A
        a.show(b); // A.show(A)
        // 在 B 中存在从 A 继承来的 show(C obj)，直接调用
        b.show(c); // A.show(C)
        // 在 B 中不存在 show(D obj)，但是存在从 A 继承来的 show(C obj)，将 D 转型成其父类 C
        b.show(d); // A.show(C)

        // 引用的还是 B 对象，所以 ba 和 b 的调用结果一样
        A ba = new B();
        ba.show(a); //B.show(A)
        ba.show(c); // A.show(C)
        ba.show(d); // A.show(C)

        System.out.println("----------Reflection test-------------");
        Class className1 = Class.forName("Board");
        System.out.println(className1.toString());
        Class className2 = a.getClass();
        System.out.println(className2.toString());
        Class className3 = A.class;
        System.out.println(className3.toString());
        A instance = a.getClass().newInstance();
        System.out.println(instance.aaa);
        if(instance.getClass() == a.getClass()){
            System.out.println("equal");
        }

        Class  class1 = Integer.class;
        System.out.println(class1.toString());
        Class class2 = Integer.TYPE;
        System.out.println(class2.toString());
        if(class1 == class2){
            System.out.println("equal!!!");
        }
        int intt = 5;
        System.out.println(className2.isInstance(b));
        System.out.println(className2.isInstance(d));


        Class<?> ccc = String.class;
        Object str = ccc.newInstance();
        System.out.println(str);


        Class ddd = String.class;
        Constructor constructor = ddd.getConstructor(String.class);
        Object object = constructor.newInstance("hello world");
        System.out.println(object);


    }
}

class A {

    int aaa;
    public A(){
        aaa=15;
    }
    public void show(A obj) {
        System.out.println("A.show(A)");
    }

    public void show(C obj) {
        System.out.println("A.show(C)");
    }
}

class B extends A {

    @Override
    public void show(A obj) {
        System.out.println("B.show(A)");
    }
}

class C extends B {
}

class D extends C {
}