package algorithm;
import java.util.Arrays;


public class HeapSort {


    public static void main(String []args){
        int []arr = {9,8,78,6,5,4,3,2,1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        //初始化大顶堆
        for(int i = arr.length/2 -1;i>=0;i--){ //从最小的有子节点的节点开始
            adjustHeap(arr,i,arr.length);
        }

        //将堆顶元素与末尾元素进行交换+ 重新调整大顶堆
        for(int j = arr.length-1;j>=1;j--){
            swap(arr,0,j);
            adjustHeap(arr,0,j);
        }
    }

    private static void adjustHeap(int[] arr, int subroot, int length) {
        int temp = arr[subroot];
        for(int i = 2*subroot+1;i<length;i = i*2+1){
            if(i+1<length&&arr[i]<arr[i+1]){
                i++;
            }
            if(temp>=arr[i]){ //（子）大顶堆完成
                break;
            }
            else{
                //注意， 把现在的子大顶堆根节点的数变为最大的
                //让根节点变为i，进行下一次循环
                arr[subroot] = arr[i];
                subroot = i;
            }
        }
        //subroot名称不恰当
        arr[subroot] = temp;

    }

    private static void swap(int[] arr , int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
