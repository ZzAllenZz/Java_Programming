package week3;

public class CloneExample implements Cloneable {
    public int a;
    public int b;
/*    public CloneExample(int a, int b){
        this.a = a;
        this.b = b;
    }*/
    public CloneExample clone () throws CloneNotSupportedException {
        return (CloneExample) super.clone();
    }

    protected void saySomething(){
        System.out.println("balabalabala");
    }
}
