package algorithm;

public class InsertSort {


    public static void main(String[] args) {
        int[] array = {4,7,9,8,1,16,9,5,100,72};
        insertSort(array);
        for(int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }

    }

    public static void insertSort(int[] array){
        //将一个记录插入到已排好序的序列中
        //下标从1到len-1;
        for(int i =1 ; i<array.length;i++){

            if(array[i]<array[i-1]){
                int curr = array[i];
                //以j为起点,看看j-1的值，
//                for(int j = i;j>=0;j--){
//                    //j>0是关键，j==0意味着到头了，那么curr是最小的， array[0] = curr;
//                    //否则到不了j==0，就会break。边界的处理要好好想一想。
//                    if(j>0 && array[j-1]>curr){
//                        array[j] = array[j-1];
//                    }
//                    else{
//                        array[j] = curr;
//                        break;
//                    }
                int index = i-1; //记录j的位置;
                for(int j = i-1;j>=0&&array[j]>curr;j--) {
                    array[j+1] = array[j];
                    index  = j-1;
                }
                array[index+1] = curr;
            }


        }

    }



}
