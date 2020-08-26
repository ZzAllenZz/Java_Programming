package algorithm;


import static algorithm.QuickSort.quickSort;

//求前k大的数
public class TopK_quicksort {
    public static void main(String[] args) {
        int[] array = {5, 38, 65, 97, 100, 22, 76, 1, 5, 8, 97, 0, -1, 22 };
        int k = 3;
        int index = topK(array,0,array.length-1, array.length-1-k);
        quickSort(array,index+1,array.length-1);
        for(int i = index+1;i<array.length;i++){
            System.out.println(array[i]);
        }
    }

    private static int topK(int[] array, int left, int right, int k) {
        int index = getIndex(array,left,right);
        while(index != k){
            if(index<k) index = getIndex(array,index+1,right);
            else index = getIndex(array,left,index-1);
        }
        return index;


    }

    private static int getIndex(int[] array, int left , int right){
        int privot = array[left];
        while(left<right){
            while(left<right && array[right]>=privot){
                right--;
            }
            array[left] = array[right];
            while(left<right&& array[left]<= privot){
                left++;
            }
            array[right] = array[left];
        }
        array[left] = privot;
        return left;
    }
}
