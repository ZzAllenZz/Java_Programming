import java.io.*;

// Class to convert unit marks to grades
class GradeConverter
{
    // Converts a numerical mark (0 to 100) into a textual grade
    // Returns "Invalid" if the number is invalid
    String convertMarkToGrade(int mark)
    {
        if(mark == -1){
            return "Invalid";
        }else if (mark >=0 && mark < 50){
            return "Fail";
        }else if (mark < 60){
            return "Pass";
        }else if (mark <70){
            return "Merit";
        }else if (mark <= 100){
            return "Distinction";
        }else{
            return "Invalid";
        }


    }

    // Reads a mark from a String and returns the mark as an int (0 to 100)
    // Returns -1 if the string is invalid
    int convertStringToMark(String text)
    {
/*        try{
            int a = Integer.parseInt(text);
            return a;
        }catch (NumberFormatException e){
            e.printStackTrace();
            return -1;
        }*/
        int mark =0,label = 0;
        for(int i = 0; i <text.length();i++){
            char temp = text.charAt(i);
            int flag = convertCharToInt(temp);
            if(flag == -1||(i==0 && flag==0 && text.length()!=1)){
                return -1;
            }else if (flag == 10){
                label++;
                continue;
            }else if(flag == 11 && i != text.length()-1){
                return -1;
            }else if (flag == 11){
                return mark;
            }
            if(label==0){
                mark =  mark * 10 +flag;
            }else if (label >0){
                if(flag >= 5){
                    mark++;
                }
                break;
            }

        }
        if(mark >100|| label>1||text.length()==0){
            return -1;
        }
        return mark;
    }

    // Convert a single character to an int (0 to 9)
    // Returns -1 if char is not numerical
    int convertCharToInt(char c)
    {
        switch (c){
            case '0': return 0;
            case '1': return 1;
            case '2': return 2;
            case '3': return 3;
            case '4': return 4;
            case '5': return 5;
            case '6': return 6;
            case '7': return 7;
            case '8': return 8;
            case '9': return 9;
            case '.': return 10;
            case '%': return 11;
            default:  return -1;
        }
    }

    public static void main(String[] args) throws IOException
    {
        GradeConverter converter = new GradeConverter();
        while(true) {
            System.out.print("Please enter your mark: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            int mark = converter.convertStringToMark(input);

            String grade = converter.convertMarkToGrade(mark);
            System.out.println("A mark of " + input + " is " + grade);
        }
    }
}
