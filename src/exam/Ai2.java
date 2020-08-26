package exam;

import java.util.*;



public class Ai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  str = sc.nextLine();

        if (isInteract(str)) System.out.println("True");
        else System.out.println("False");


    }

    public static boolean isInteract (String str){
        HashSet<Location> hashSet = new HashSet<Location>();
        int[] arr = {0,0};
        hashSet.add(new Location(arr[0],arr[1]));


        for(int i=0;i<str.length();i++){

            switch (str.charAt(i)){
                case 'N':
                    arr[0] = arr[0]-1;
                    break;
                case 'S':
                    arr[0] = arr[0]+1;
                    break;
                case 'W':
                    arr[1] = arr[1]-1;
                    break;
                case 'E':
                    arr[1] = arr[1]+1;
                    break;
            }
            if(hashSet.contains(new Location(arr[0],arr[1]))) return true;
            else{
                hashSet.add(new Location(arr[0],arr[1]));
            }
        }

        return false;


    }

}

class Location{
    int i, j;
    public Location(int i ,int j){
        this.i=i;
        this.j=j;
    }

    @Override
    public int hashCode(){
        return i+j;
    }

    @Override
    public boolean equals(Object o){
        Location second = (Location) o;
        if(i==second.i&&j==second.j) return true;
        else return false;

    }
}