package algorithm;

import java.util.*;

public class topFrequencyK2 {
    public static void main(String[] args) {
        int[] array = {123,123,1,1,1,1,7,7,7,8,9,10,18,20,90,100};
        List<Integer> list = topFrequentK(array,10);
        System.gc();
        for(int a:list) System.out.println(a);
        System.gc();


    }

    public static List<Integer> topFrequentK(int[] arr, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        //存到map中,key是element,value是出现次数
        for(int a:arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a,b)->{
            return map.get(a)-map.get(b);
        });
        for(int a:map.keySet()){
            queue.offer(a);
            if(queue.size()>k) queue.poll();
        }
        List<Integer> res = new ArrayList<>(k);
        while(!queue.isEmpty()) res.add(queue.poll());
        Collections.reverse(res);
        return res;
    }

    public List<Integer> topK(int[] nums, int k) {
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        // keep k top frequent elements in the heap
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // build output list
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
            top_k.add(heap.poll());
        Collections.reverse(top_k);
        return top_k;
    }


}
