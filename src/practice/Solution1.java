package practice;

import java.util.Arrays;
import java.util.Comparator;

class Solution1 {

    private class LargestNumberComparator implements Comparator<String>{
        @Override
        public int compare(String a, String b){
            String order1 = a+b;
            String order2 = b+a;
            return order2.compareTo(order1);
        }
    }
    public String largestNumber(int[] nums) {
        if(nums.length==1) return Integer.valueOf(nums[0]).toString();


        String[] str = new String[nums.length];
        for(int i =0; i<nums.length;i++){
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str,(String a, String b)->{
            String order1 = a+b;
            String order2 = b+a;
            return order2.compareTo(order1);
        });
        if(str[0].equals("0")) return "0";
        StringBuilder strb = new StringBuilder();
        for(String a:str){
            strb.append(a);
        }
        return strb.toString();
    }
}