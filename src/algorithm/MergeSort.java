package algorithm;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {5, 38, 65, 97, 100, 22, 76, 1, 5, 8, 97, 0, -1, 22 };
        mergeSort(array,0,array.length-1);
        for(int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }

    }

    public static void mergeSort(int[] array, int left, int right){
        int m;
        if(left<right){
            m = (left+right)/2;
            mergeSort(array,left,m);
            mergeSort(array,m+1,right);
            merging(array,left,m,right);
        }

    }

    public static void merging(int[] array, int left,int m,  int right){


        int i = left;
        int j = m+1;
        int d = left;
        int[] temp = new int[array.length];

        while(i<=m&&j<=right){
            if(array[i]<array[j]){
                temp[d++]= array[i++];
            }
            else{
                temp[d++] = array[j++];
            }
        }

        while(i<= m){
            temp[d++]= array[i++];
        }

        while(j<=right){
            temp[d++] = array[j++];
        }


        for(int k = left; k<=right;k++){
            array[k] = temp[k];
        }


    }
}
