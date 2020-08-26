package algorithm;

public class binarySearch {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,8,9,18,21,30,56,60,70,100};
        int target = 60;

        int index = getBinaryIndex(arr1,0,arr1.length-1,target);
        System.out.println(index);

    }
    private static int getBinaryIndex(int[] arr1,int left, int right, int target){

        if(arr1[left]==target) return left;
        if(arr1[right]==target) return right;
        int index = (left+right)/2;
        if(arr1[index]==target) return index;
        if(right-left<2) return -1;

        if(target<arr1[index]) return getBinaryIndex(arr1,left+1,index-1,target);
        else return getBinaryIndex(arr1,index+1,right-1,target);
    }
}
