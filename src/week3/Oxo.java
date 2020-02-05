import java.io.*;

class Oxo {



    public static void main (String[] args){
        Board board = new Board();
        Display display = new Display();
        display.printBoard(board);

        Player playerO = new Player("O ");

        Player playerX = new Player("X ");

        System.out.println(playerO.type.equals("O "));
        System.out.println(playerX.type.equals("X "));


        System.out.println("input a string");
        String str = display.receiveInput();
        display.printString(str);
        System.out.println(board.checkValidInput("a1"));
        System.out.println(board.isValid("b2"));
        System.out.println(board.isDiagonalWin());
        System.out.println(board.isStraightLineWin());
        System.out.println(board.isWin());
        System.out.println(board.isDraw());
    }


}