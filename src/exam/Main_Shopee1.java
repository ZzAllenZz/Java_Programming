package exam;

import java.util.*;

public class Main_Shopee1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        sc.close();
        if(str.length()<=1) System.out.println(str);
        else {
            int max =1;
            char[] chars = str.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                if (map.containsKey(chars[i])) {
                    int count = map.get(chars[i]) + 1;
                    map.put(chars[i], count);
                    max = Math.max(max,count);
                } else map.put(chars[i], 1);
            }
            HashMap<Integer, ArrayList<Character>> map2 = new HashMap<>();
            for(Character key:map.keySet()){
                if(!map2.containsKey(map.get(key))){
                    ArrayList<Character> list = new ArrayList<>();
                    list.add(key);
                    map2.put(map.get(key),list);
                }else{
                    map2.get(map.get(key)).add(key);
                }
            }
            StringBuilder ans = new StringBuilder();
            for(int i = 1;i<=max;i++){
                if(map2.containsKey(i)){
                    Collections.sort(map2.get(i));
                    for(Character c : map2.get(i)){
                        for(int j =0;j<i;j++) ans.append(c);
                    }
                }
            }
            System.out.println(ans.toString());
        }
    }
}


//        int n1 = sc.nextInt();
//        int n2= sc.nextInt();
//        int[] array1 = new int[n1];
//        int[] array2 = new int[n2];
//
//        for(int i = 0;i<n1;i++){
//            array1[i] = sc.nextInt();
//        }
//        for(int i = 0;i<n2;i++){
//            array2[i] = sc.nextInt();
//        }