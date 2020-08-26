package practice.singleton;
//3、懒汉式(线程不安全)[不可用]
public class Demo3_lazy_unsafe {


    private static Demo3_lazy_unsafe uniqueInstance;

    private Demo3_lazy_unsafe(){}

    public static Demo3_lazy_unsafe getInstance(){
        if(uniqueInstance==null) uniqueInstance = new Demo3_lazy_unsafe();
        return uniqueInstance;
    }
}
