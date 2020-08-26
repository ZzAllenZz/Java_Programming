package practice.singleton;
//2. 饿汉式, 静态代码块
public class Demo2_hungry {
    private static Demo2_hungry uniqueInstance;

    static{
        uniqueInstance = new Demo2_hungry();
    }

    private Demo2_hungry(){}

    public static Demo2_hungry getInstance() {
        return uniqueInstance;
    }
}
