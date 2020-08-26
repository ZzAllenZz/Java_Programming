

public class Board {
    int length = 4;
    String[][] table = new String[length][length];
    public Board(){
        for (int i = 0;i<length;i++){
            table[0][i] = Integer.toString(i)+ Character.toString(' ');
            char temp = (char) (i - 1 + 'a');
            table[i][0] = Character.toString(temp)+ Character.toString(' ');
        }

        table[0][0] = "  ";
        for(int i = 0 ; i<length-1;i++){
            for(int j = 0 ; j<length-1;j++){
                table[i+1][j+1] = ". ";
            }
        }

        table[1][1] = "O ";
        table[1][2] = "O ";
        table[1][3] = "O ";

        table[2][1] = "X ";
        table[2][2] = "X ";
        table[2][3] = "X ";

        table[3][1] = "O ";
        table[3][2] = "O ";
        table[3][3] = "O ";

    }

    boolean isValid(String nextStep){
        if(!checkValidInput(nextStep)){
            return false;
        }
        int row = nextStep.charAt(0)-'a'+ 1;
        int column = nextStep.charAt(1)-'0';
        if(table[row][column].equals("  ")){
            return true;
        }else{
            return false;
        }
    }

    boolean checkValidInput(String nextStep){
        int length = 2;
        char startNumber ='1';
        char finishNumber = '3';
        char startLetter = 'a';
        char finishLetter = 'c';
        if(nextStep.length()!=2){
            return false;
        }
        char temp = nextStep.charAt(0);
        if( temp < startLetter || temp >finishLetter){
            return  false;
        }
        temp = nextStep.charAt(length-1);
        if(temp<startNumber||temp>finishNumber){
            return false;
        }
        return true;

    }

    boolean isWin(){
        if(isStraightLineWin()||isDiagonalWin()){
            return true;
        }else{
            return false;
        }
    }

    boolean isStraightLineWin(){
        int rowFlag = 0;
        int columnFlag = 0;

        for(int i=1;i<length;i++){
            for(int j=1;j<length;j++){
                /*check three rows*/
                if(table[i][i].equals(table[i][j])){
                    rowFlag++;
                }
                /*check three columns*/
                if(table[i][i].equals(table[j][i])){
                    columnFlag++;
                }
            }
            if((rowFlag==length-1||columnFlag==length-1)&&!table[i][i].equals(". ")){
                return true;
            }
/*            if(columnFlag==length-1&&!table[i][i].equals(". ")){
                return true;
            }*/
            rowFlag=0;
            columnFlag=0;
        }
        return false;
    }


    boolean isDiagonalWin(){
        int diagonalFlag = 0;
        int reverseDiagonalFlag = 0;
        for(int i=1;i<length;i++){
            /*check diagonal*/
            if(table[1][1].equals(table[i][i])){
                diagonalFlag++;
            }
            /*check reverse diagonal*/
            if(table[1][length-1].equals(table[i][length-i])){
                reverseDiagonalFlag++;
            }
        }
        if(diagonalFlag==length-1&&!table[1][1].equals(". ")){
            return true;
        }else if (reverseDiagonalFlag==length-1&&!table[1][length-1].equals(". ")){
            return true;
        }else{
            return false;
        }
    }


    boolean isDraw(){
        int flag = 0;
        if(isWin()){
            return false;
        }
        for(int i=1;i<length;i++){
            for(int j=1;j<length;j++){
                if(table[i][j].equals(". ")){
                    flag++;
                }
            }

        }
        if(flag == 0){
            return true;
        }else{
            return false;
        }

    }





}