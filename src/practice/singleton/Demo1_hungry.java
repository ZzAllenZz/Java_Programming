package practice.singleton;

//1. 饿汉式, 静态变量
public class Demo1_hungry {

    private final static Demo1_hungry uniqueInstance = new Demo1_hungry();

    private Demo1_hungry(){};
    public static Demo1_hungry getInstance(){
        return uniqueInstance;
    }


}
