package algorithm;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {4,7,9,8,1,16,9,5,100,72};
        selectionSort(array);
        for(int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }

    }

    public static void selectionSort(int[] array){
        //核心: 先不急着移动, 先比较一圈,找到最小值/最大值及其下标, 在移动。
        //也是比较n-1轮；
        for(int i = 0 ; i<array.length-1;i++){


            int min = array[i];
            int index = i; //用来记录最小值的下标


            for(int j = i+1;j<array.length;j++){
                if(array[j]<min){
                    min = array[j];
                    index = j;
                }
            }
            int temp = array[i];
            array[i] = min;
            array[index] = temp;

        }
    }
}
