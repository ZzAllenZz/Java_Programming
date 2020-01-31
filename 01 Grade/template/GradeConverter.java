import java.io.*;

// Class to convert unit marks to grades
class GradeConverter
{
    // Converts a numerical mark (0 to 100) into a textual grade
    // Returns "Invalid" if the number is invalid
    String convertMarkToGrade(int mark)
    {
        return "Invalid";
    }

    // Reads a mark from a String and returns the mark as an int (0 to 100)
    // Returns -1 if the string is invalid
    int convertStringToMark(String text)
    {
        return -1;
    }

    // Convert a single character to an int (0 to 9)
    // Returns -1 if char is not numerical
    int convertCharToInt(char c)
    {
        return -1;
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
