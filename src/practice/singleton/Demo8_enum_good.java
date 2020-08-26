package practice.singleton;


/**8.枚举实现单例
 * 在effective java（这本书真的很棒）中说道，最佳的单例实现模式就是枚举模式。利用枚举的特性，让JVM来帮我们保证线程安全和单一实例的问题。除此之外，写法还特别简单。
 * 直接通过Singleton.INSTANCE.doSomething()的方式调用即可。方便、简洁又安全。
 * 优点:
 *      三个特性，自由序列化，线程安全，保证单例。
 * WHY:
 *     看这篇文章:
 *
 *
 * */


public enum Demo8_enum_good {
    INSTANCE;
    int a = 5;
    public void doSomething(){

    }
}
