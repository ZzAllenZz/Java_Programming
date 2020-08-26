package practice.StringAndStringBuffer;

public class TestIntern {
    public static void main(String[] args) {
//        String s = new String("1");
//        String s2 = "1";
//        System.out.println(s == s2);
//        System.out.println(s.intern() == s2);
//
//        String s3 = new String("1") + new String("1");
//        s3.intern();
//        String s4 = "11";
//        System.out.println(s3 == s4);

//        String s = new String("1");
//        String s2 = "1";
//        s.intern();
//        System.out.println(s == s2);
//
//        String s3 = new String("1") + new String("1");
//        String s4 = "11";
//        s3.intern();
//        System.out.println(s3 == s4);


//        String str1 = new String("SEU")+ new String("Calvin");
        String str2 = new String("SEU")+ new String("Calvin");
        String str1 = "SEU"+"Calvin";
        String str3 = "SEUCalvin";

        System.out.println(str1.intern() == str1);
        System.out.println(str1 == "SEUCalvin");
        System.out.println(str1 == str2);
        System.out.println(str1.intern() == str2);
        System.out.println(str2=="SEUCalvin");
        System.out.println(str3=="SEUCalvin");

//        String str2 = "SEUCalvin";//新加的一行代码，其余不变
//        String str1 = new String("SEU")+ new String("Calvin");
//        System.out.println(str1.intern() == str1);
//        System.out.println(str1 == "SEUCalvin");
    }
}
