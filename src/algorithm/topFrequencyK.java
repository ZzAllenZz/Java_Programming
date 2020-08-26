package algorithm;

import javax.swing.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class topFrequencyK {
    public static void main(String[] args) {
        int[] array = {123,123,1,1,1,1,7,7,7,8,9,10};
        HashMap<Integer,Integer> map = new HashMap<>();
        //1.record the frequency of each element
        for(int a : array){
            if(map.containsKey(a)){
                int count = map.get(a);
                map.put(a,count+1);
            }else map.put(a,1);
        }

        Map.Entry<Integer, Integer>[] entries = new Map.Entry[map.size()];
        map.entrySet().toArray(entries);


        int k = 3;
        Map.Entry<Integer, Integer>[] res = topFrequencyK(entries,k);

        heapSort(res);
        for(Map.Entry<Integer, Integer> a: res){
            System.out.println(a.getKey());
        }





    }

    private static Map.Entry<Integer,Integer>[] topFrequencyK(Map.Entry<Integer,Integer>[] arr, int k){

        Map.Entry<Integer,Integer>[] res= new Map.Entry[k];

        for(int i = 0 ;i<k;i++){
            res[i] = arr[i];
        }
        //初始化小顶堆
        for(int i = k/2-1;i>=0;i--){
            adjustHeap(res,i,k);
        }

        //将arr的后len-1-k个元素,一次和小顶堆的根节点比较
        for(int i = k;i<arr.length;i++){
            if(arr[i].getValue() > res[0].getValue()){
                res[0] = arr[i];
                adjustHeap(res,0,k);
            }
        }
        return res;
    }

    private static void adjustHeap(Map.Entry<Integer,Integer>[] arr,int targetNode,int length){
        Map.Entry<Integer,Integer> temp = arr[targetNode];

        for(int i = targetNode*2+1; i<length;i = 2*i+1){
            if(i+1<length&&arr[i+1].getValue()<arr[i].getValue()) i++;
            if(temp.getValue() <= arr[i].getValue()) break;
            else{
                arr[targetNode] = arr[i];
                targetNode = i;
            }
        }
        arr[targetNode] = temp;
    }

    private static void heapSort(Map.Entry<Integer, Integer>[] arr){
        for(int j = arr.length-1;j>=1;j--){
            swap(arr,0,j);
            adjustHeap(arr,0,j);
        }

    }

    private static void swap(Map.Entry<Integer, Integer>[] arr, int a ,int b){
        Map.Entry<Integer, Integer> temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }
}
