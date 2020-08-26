package week7;

public class Plalindrome {

    public static void main(String[] args) {
        Plalindrome p = new Plalindrome();
        System.out.println(p.isPalindrome(121));
    }
/*    public boolean isPalindrome(int x) {
        if(x<0){return false;}
        if(x==0){return true;}
        StringBuffer temp = new StringBuffer(x+"");
        String temp2 = temp.reverse().toString();
        return temp2.equals(x+"");
    }*/
    public boolean isPalindrome(int x){
        if(x<0||(x%10==0&&x!=0)){return false;}
        int div = 1;
        while(x/div>=10){ div *=10;}
        while(x>0){
            int left = x/div;
            int right = x%10;
            if(left!=right){return false;}
            x = (x%div)/10;
            div /=100;
        }
        return true;
    }
}
