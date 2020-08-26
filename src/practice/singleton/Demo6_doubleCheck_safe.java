package practice.singleton;


/**
*6、双重检查[推荐用]
 **/
public class Demo6_doubleCheck_safe {

    /**
     * 如果不加volatile,不能100%
     * 因为可能发生指令重排
     *
     * **/
    private static volatile Demo6_doubleCheck_safe instance;

    private Demo6_doubleCheck_safe(){};

    public static Demo6_doubleCheck_safe getInstance(){
        if(instance==null){
            synchronized (Demo6_doubleCheck_safe.class){
                if(instance==null){
                    instance = new Demo6_doubleCheck_safe();
                }
            }
        }
        return instance;



    }

}
