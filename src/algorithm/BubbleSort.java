package algorithm;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {4,7,9,8,1,16,9};
        bubbleSort(array);
        for(int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }

    }

    public static void bubbleSort(int[] array){
        int flag = 1; //用来判断数组元素的位置是否发生变化

        for(int i = 0;i<array.length-1 && flag == 1;i++ ){ //比较n-1轮
            flag = 0;
            for(int j = 0;j<array.length-i-1;j++){ // 每轮比较n-i-1次

                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = 1;
                }
            }
        }
    }
}
