
import java.lang.Math;


class Triangle
{
    private int firstLength;
    private int secondLength;
    private int thirdLength;
    private TriangleType type;

    // Class to represent trinagles
    Triangle(int first, int second, int third)
    {
        firstLength = first;
        secondLength = second;
        thirdLength = third;
        type = identifyTriangleType(first, second, third);
    }

    // Returns the (previously indentified) type of this triangle
    TriangleType getType()
    {
        return type;
    }



    // Returns a printable string that describes this triangle
    public String toString()
    {
        return "(" + firstLength + "," + secondLength + "," + thirdLength + ")";
    }

    // Works out what kind of triangle this is !
    static TriangleType identifyTriangleType(int first, int second, int third)
    {
        double doubleFirst = (double) first;
        double doublesSecond = (double) second;
        double doubleThrid = (double) third;

        if(doubleFirst+doublesSecond >Integer.MAX_VALUE||doubleFirst+doubleThrid >Integer.MAX_VALUE
                || doublesSecond+doubleThrid>Integer.MAX_VALUE){
            return TriangleType.Scalene;
        }
        if(Math.pow(doubleFirst,2)+Math.pow(doublesSecond,2) >Integer.MAX_VALUE
                ||Math.pow(doubleFirst,2)+Math.pow(doubleThrid,2) >Integer.MAX_VALUE
                || Math.pow(doublesSecond,2)+Math.pow(doubleThrid,2)>Integer.MAX_VALUE){
            return TriangleType.Scalene;
        }



        if(first<=0 || second<= 0 || third<= 0){
            return TriangleType.Illegal;
        }
        else if(first+second<third||first+third<second || second+third<first ){
            return TriangleType.Impossible;
        }
        else if(first+second==third||first+third==second||second+third==first){
            return TriangleType.Flat;
        }
        else if(Math.pow(first,2)+Math.pow(second,2)==Math.pow(third,2)){
            return TriangleType.Right;
        }
        else if(Math.pow(first,2)+Math.pow(third,2)==Math.pow(second,2)){
            return TriangleType.Right;
        }
        else if(Math.pow(second,2)+Math.pow(third,2)==Math.pow(first,2)){
            return TriangleType.Right;
        }
        else if(first==second&&first!=third){
            return TriangleType.Isosceles;
        }
        else if(first==third&&first!=second){
            return TriangleType.Isosceles;
        }
        else if(third==second&&first!=third){
            return TriangleType.Isosceles;
        }
        else if(first==second && first==third){
            return TriangleType.Equilateral;
        }
        else{
            return TriangleType.Scalene;
        }

    }


}
