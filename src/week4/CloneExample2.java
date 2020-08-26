package week4;
import week3.CloneExample;
public class CloneExample2 extends CloneExample {
/*    public int a;
    public int b;
    *//*    public CloneExample(int a, int b){
            this.a = a;
            this.b = b;
        }*/
    public CloneExample2 clone () throws CloneNotSupportedException {
        return (CloneExample2) super.clone();

    }
}
