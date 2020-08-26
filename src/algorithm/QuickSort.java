package algorithm;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {5, 38, 65, 97, 100, 22, 76, 1, 5, 8, 97, 0, -1, 22 };
        quickSort(array,0,array.length-1);
        for(int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }

    }

    public static void quickSort(int[] array, int left, int right){
        if(left<right)
        {
            int index = getIndex(array,left,right);
            quickSort(array,left,index-1); // 不能是  quickSort(array,0,index-1);
            quickSort(array,index+1,right);
        }
    }

    public static int getIndex(int[] array, int left, int right){

        int privot = array[left];

        while(left<right){
            while (left<right && array[right]>= privot) right--; //必须有=，不让死循环；
            array[left] = array[right];
            while (left<right && array[left] <=  privot) left++;
            array[right] = array[left];
        }
        array[left] = privot; // 此时 left = right;
        return left;
    }
}
