package algorithm;

import java.util.Arrays;

import static algorithm.QuickSort.quickSort;

//get top k largest element.
public class topK_heapSort {
    public static void main(String[] args) {
        int[] array = {5,600, 38, 65, 97, 100, 108,500, 22, 76, 1, 5, 8, 700, 0, -1, 22 };
        int k = 3;
        int[] res = topK(array,k);
        //前k大的element,但顺序不一定对
        System.out.println("top k before heap sort");
        for(int a:res) System.out.println(a);
        //
        heapSort(res);
        System.out.println("top k after heap sort");
        for(int a:res) System.out.println(a);


    }

    private static int[] topK(int[] arr, int k){
        int[] res = new int[k];
        for(int i = 0 ;i<k;i++){
            res[i] = arr[i];
        }
        //初始化小顶堆
        for(int i = k/2-1;i>=0;i--){
            adjustHeap(res,i,k);
        }

        //将arr的后len-1-k个元素,一次和小顶堆的根节点比较
        for(int i = k;i<arr.length;i++){
            if(arr[i]> res[0]){
                res[0] = arr[i];
                adjustHeap(res,0,k);
            }
        }
        return res;
    }

    private static void adjustHeap(int[] arr, int targetNode,int length){
        int temp = arr[targetNode];
        for(int i = targetNode*2+1; i<length;i = 2*i+1){
            if(i+1<length&&arr[i+1]<arr[i]) i++;
            if(temp <= arr[i]) break;
            else{
                arr[targetNode] = arr[i];
                targetNode = i;
            }
        }
        arr[targetNode] = temp;
    }

    private static void heapSort(int[] arr){
        for(int j = arr.length-1;j>=1;j--){
            swap(arr,0,j);
            adjustHeap(arr,0,j);
        }

    }

    private static void swap(int[] arr, int a ,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }
}


