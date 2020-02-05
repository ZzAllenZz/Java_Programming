package Test.com;
import java.io.*;
import java.util.*;

class Oxo {



    public static void main (String[] args){
        Board board = new Board();
        Display display = new Display();
        display.printBoard(board);

        Player playerO = new Player("O ");

        Player playerX = new Player("X ");

/*        System.out.println(playerO.type.equals("O "));
        System.out.println(playerX.type.equals("X "));*/

        while(!board.isWin()&&!board.isDraw()){
            System.out.println("playerO move:");
            String str = display.receiveInput();
/*            if(!board.isValid(str)){
                exit(10);
            }*/
            board.drawOnBoard(str,playerO);
            display.printBoard(board);


            System.out.println("playerX move:");
            String str2 = display.receiveInput();

            board.drawOnBoard(str2,playerX);
            display.printBoard(board);

        }




/*        System.out.println(board.checkValidInput("a1"));
        System.out.println(board.isValid("b2"));
        System.out.println(board.isDiagonalWin());
        System.out.println(board.isStraightLineWin());
        System.out.println(board.isWin());
        System.out.println(board.isDraw());*/
    }


}