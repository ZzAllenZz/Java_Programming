package week5;

import java.lang.reflect.Field;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public class Test5 {
    public static void main(String[] args) throws ClassNotFoundException ,NoSuchFieldException  , IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> c = methodClass.class;
        Object object = c.newInstance();
        Method[] methods = c.getMethods();
        Method[] declaredMethods = c.getDeclaredMethods();
        System.out.println("---获取方法---");
        //获取methodClass类的add方法
        Method method = c.getMethod("add",int.class , int.class);
        //getMethods()方法获取的所有方法
        System.out.println("getMethods获取的方法：");
        for(Method m:methods)
            System.out.println(m);
        //getDeclaredMethods()方法获取的所有方法
        System.out.println("getDeclaredMethods获取的方法：");
        for(Method m:declaredMethods)
            System.out.println(m);


        Constructor constructor = c.getConstructor(int.class);
        methodClass obj = (methodClass) constructor.newInstance(20);
        System.out.println(obj.getD());


        System.out.println("-----test Field----");
        methodClass temp = new methodClass();
        temp.setSecret(789);


        Field[] fs = c.getDeclaredFields();
        for(Field f: fs){
            f.setAccessible(true);
            System.out.println(f.get(temp));
        }

        System.out.println("----invoke method----");
        Class kclass = methodClass.class;
        Object obj1 = kclass.newInstance();
        Method method2 = kclass.getDeclaredMethod("add",int.class,int.class);
        Object result = method2.invoke(obj1,15,15);
        System.out.println(result);

        System.out.println("----利用反射创建数组-----");
        Class<?> cls = Class.forName("java.lang.String");
        Object array = Array.newInstance(cls,25);
        //往数组里添加内容
        Array.set(array,0,"hello");
        Array.set(array,1,"Java");
        Array.set(array,2,"fuck");
        Array.set(array,3,"Scala");
        Array.set(array,4,"Clojure");
        //获取某一项的内容
        System.out.println(Array.get(array,3));


        int a = 1;
        int b = 0;
        int dasd = a/b;






    }
}

class methodClass {
    public final int fuck = 3;
    public int d;
    private int secret = 123;
    public methodClass(int c){
        d = c;
    }
    public methodClass(){

    }
    public int add(int a,int b) {
        return a+b;
    }
    public int sub(int a,int b) {
        return a+b;
    }
    public int getD(){
        return d;
    }
    public void setSecret(int input){
        secret = input;
    }
}