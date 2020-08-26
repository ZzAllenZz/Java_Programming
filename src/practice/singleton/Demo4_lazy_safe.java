package practice.singleton;
//4、懒汉式(线程安全，同步方法)[不推荐用]
public class Demo4_lazy_safe {
    private static Demo4_lazy_safe uniqueInstance;
    private Demo4_lazy_safe(){};

    public static synchronized Demo4_lazy_safe getInstance(){
        if(uniqueInstance==null) uniqueInstance = new Demo4_lazy_safe();
        return uniqueInstance;
    }

}
