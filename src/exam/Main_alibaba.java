package exam;


import java.util.Scanner;

public class Main_alibaba {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        for(int i = 0 ;i<len;i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            if(n<=3 || k<=0){
                System.out.println("-1");
            }
            else {
                boolean flag = false;
                for (int first = 1; first * k < n && flag == false; first++) {
                    for (int second = first + 1; (second + first) * k < n && flag == false; second++) {
                        for (int third = second + 1; (third + second + first) * k <= n && flag == false; third++) {
                            int firstNum = first*k;
                            int secondNum = second*k;
                            int thirdNum = third*k;
                            if (firstNum+secondNum+thirdNum == n) {
                                int max1 = 1;
                                for(int f = 2;f<firstNum;f++){
                                    if(firstNum%f==0&& (secondNum%f==0||thirdNum%f==0)){
                                        max1 = f;
                                    }
                                }
                                int max2 = 1;
                                for(int s = 2;s<second*k;s++){
                                    if((second*k)%s==0&&(third*k)%s==0){
                                        max2= s;
                                    }
                                }

                                if(max1>k ||max2>k||((secondNum)%(firstNum)==0&&first!=1)||((thirdNum)%(firstNum)==0&&first!=1)||((thirdNum)%(secondNum)==0)){
                                    continue;
                                }else{
                                    flag = true;
                                    System.out.println(firstNum + " " + secondNum + " " + thirdNum);
                                }
                            }
                        }
                    }
                }
                if (flag == false) System.out.println(-1);
            }
        }
    }
}

