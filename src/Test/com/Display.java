package Test.com;
import java.util.Scanner;

class Display{


    void printBoard(Board board){
        for(int i = 0 ; i <board.length;i++){
            for (int j = 0 ;j<board.length;j++){
                System.out.print(board.table[i][j]);
            }
            System.out.println();
        }
    }

    String receiveInput(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        return str;
    }

    void printString(String str){
        System.out.println(str);
    }
}