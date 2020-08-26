package week5;

/*例1，三个同在一个包中的类，此段代码是证明子类方法权限可大于父类方法权限；   */
public class Test1 {
    public static void main(String[] args) {
        Father f = new Child();
        f.print();
        Child child1 = new Child();
        child1.eat();
        child1.print();
    }
}

class Father{
    protected void print(){
        System.out.println("This is the Father");
    }
    public void say(){
        System.out.println("say it!");
    }
/*    public String say(){

    }*/
}
class Child extends Father{
    public void print(){    //public > protected > default > private ;

        System.out.println("This is the Child");
    }
    public void eat(){
        System.out.println("Child is eating");
    }
}