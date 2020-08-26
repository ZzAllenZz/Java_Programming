package week7;

public class narnumber {

    public static void main(String[] args) {
        for(int i = 100;i<1000;i++){
            printOut(i);
        }
    }
    public static void printOut(int num){
        int first = num%10;
        int second= (num/10)%10;
        int third = num/100;
        boolean res = (int)(Math.pow(first,3)+Math.pow(second,3)+Math.pow(third,3))==num;
        if(res){System.out.println(num);}

    }
}
