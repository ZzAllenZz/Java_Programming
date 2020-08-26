package week9;
// https://blog.csdn.net/ns_code/article/details/17485221
public class Test{
    public static void main(String[] args){
        System.out.println(Test());
    }

    private static int Test(){
        int num = 10;
        try{
            System.out.println("try");
            num +=50;
            return num;
        }catch(Exception e){
            System.out.println("error");
        }finally{
            if (num > 20){
                System.out.println("num>20 : " + num);
            }
            num = 100;
            System.out.println("finally");

        }
        return num;
    }
}