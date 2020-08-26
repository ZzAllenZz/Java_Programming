package practice.ProxyStudy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

public class LogHandler implements InvocationHandler {

    private Object targetObject;

    public Object newProxyInstance(Object targetObject){
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),targetObject.getClass().getInterfaces(),this);

    }


    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println(("---------dynamic proxy start--------"));
        for(int i = 0;i<objects.length;i++){
            System.out.println(objects[i]);
        }
        Object ret = null;
        try{
            System.out.println("输出日志");
            ret = method.invoke(targetObject,objects);
            System.out.println("输出日志成功");

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("error");
            throw e;
        }
        return ret;
    }
}
