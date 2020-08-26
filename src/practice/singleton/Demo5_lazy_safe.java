package practice.singleton;
//5、懒汉式(线程安全，同步代码块) [不可用]
/**
 * 由于第四种实现方式同步效率太低，所以摒弃同步方法，改为 同步产生实例化的的代码块。但是这种同步并不能起到线程同步的作用。
 *
 * 跟第3种实现方式遇到的情形一致，假如一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。
* */
public class Demo5_lazy_safe {
    private static Demo5_lazy_safe uniqueInstance;
    private Demo5_lazy_safe(){};

    public static synchronized Demo5_lazy_safe getInstance(){
        if(uniqueInstance==null) {
            synchronized (Demo5_lazy_safe.class){
                uniqueInstance = new Demo5_lazy_safe();
            }
        }
        return uniqueInstance;
    }
}
