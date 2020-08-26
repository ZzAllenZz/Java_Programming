package practice.IntegerRelated;

public class NewInteger {
    public static void main(String[] args) {
//        Integer i01 = -128;
//        int i02 = -128;
//        Integer i03 = Integer.valueOf(-128);
//        Integer i04 = new Integer(-128);
//        System.out.println(i02 == i04); //因为包装类Integer和基本数据类型int比较时，java会自动拆包装为int，然后进行比较，实际上就变为两个int变量的比较
//        System.out.println(i03 == i04);
//        System.out.println(i01 == i02);//因为包装类Integer和基本数据类型int比较时，java会自动拆包装为int，然后进行比较，实际上就变为两个int变量的比较
//        System.out.println(i01 == i03);


        Integer a = 300;
        Integer b = Integer.valueOf(300);
        int c = 300;
        System.out.println(a == b); //false  // 只有-128-127放在方法区的常量池中
        System.out.println(a == c); //true
        System.out.println(b == c); //true

        String s = new String("xyz");
    }
}
