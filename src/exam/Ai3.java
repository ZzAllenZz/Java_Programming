package exam;

import java.util.*;



public class Ai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(isValid(str)) System.out.println("True");
        else System.out.println("False");

    }


    public static boolean isValid(String str){
        if(str.equals("")) return true;
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0;i<str.length();i++){
            char temp = str.charAt(i);
            if(temp=='('||temp=='['||temp=='{'){
                stack.push(temp);
                continue;
            }

            if(stack.isEmpty()) return false;

            char pop = stack.pop();
            if(temp==')'&& pop!='(') return false;
            if(temp=='}'&& pop!='{') return false;
            if(temp==']'&& pop!='[') return false;
        }
        if(stack.isEmpty()) return true;
        else return false;

    }

}


