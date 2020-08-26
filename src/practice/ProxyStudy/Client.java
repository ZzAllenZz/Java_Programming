package practice.ProxyStudy;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args){
        testStatic();
        System.out.println("");
        System.out.println("");
        testDynamic();
    }

    private static void testDynamic() {

        LogHandler logHandler = new LogHandler();
        UserManagerImpl userManagerImpl = new UserManagerImpl();
        UserManager userManager = (UserManager) logHandler.newProxyInstance(userManagerImpl);
        userManager.addUser("1111", "张三");
        String a = userManager.findUser("1111");
        System.out.println(a);
    }

    private static void testStatic() {
        UserManager userManager=new UserManagerImplProxy(new UserManagerImpl());
        userManager.addUser("1111", "张三");
    }
}
