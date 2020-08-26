package week5;
import java.lang.Math;
public class Test4 {
    public static void main(String[] args) {


    System.out.println(Solution.fLR("FFR"));

    }

}

class Solution {
    public static int fLR(String input) {
        // Your code goes here
        int x = 0;
        int y = 0;
        int xStep = 0;
        int yStep = 1;

        for(int i = 0; i<input.length();i++){
            char temp = input.charAt(i);
            if(temp =='L'){
                //for left
                if(xStep==0){
                    xStep = 0 - yStep;
                    yStep = 0;
                }
                else{
                    yStep = xStep;
                    xStep = 0;
                }
            }
            else if(temp == 'R') {
                //for right;
                if(xStep==0){
                    xStep = yStep;
                    yStep = 0;
                }
                else {
                    yStep = 0 - xStep;
                    xStep = 0;
                }
            }
            else if (temp == 'F'){
                //for forward
                x = x+xStep;
                y = y+yStep;
            }
        }
            if(x == 0 && y == 0) return 0;

            int res = Math.abs(x)+Math.abs(y);

            if(xStep == -1){
                if(x>0&&y!=0) return res+1;
                else if (x>0 && y==0) return res;
                else if (x==0) return res+1;
                else if (x<0) return res+2;
            }

            if(xStep == 1){
                if(x>0) return res+2;
                else if (x==0) return res+1;
                else if (x<0 && y !=0) return res+1;
                else if (x<0 && y ==0) return res;
            }

            if(yStep == -1){
                if(y>0&&x!=0) return res+2;
                else if (y>0&& x ==0) return res;
                else if (y==0) return res+1;
                else if (y<0) return res+2;

            }
            if(yStep == 1){
                if(y>0) return res+2;
                if(y==0) return res+1;
                if(y<0 && x != 0) return res+1;
                if(y<0 && x == 0 ) return res;
            }
            return  res;
        }
}
