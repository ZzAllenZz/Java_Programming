package algorithm;

public class ShellSort {


    public static void main(String[] args) {
        int[] array = {4,7,9,8,1,16,9,5,100,72};
        shellSort(array);
        for(int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }

    }

    public static void shellSort(int[] array){

        int gap = array.length/2;

        while(gap>=1){
            for(int i = gap;i<array.length;i++){
                if(array[i]<array[i-gap]){
                    int temp = array[i];
                    for(int j = i;j>=0;j = j-gap){
                        if(j-gap >= 0 && array[j-gap]>temp){
                            array[j] = array[j-gap];
                        }
                        else{
                            array[j] = temp;
                            break;
                        }
                    }
                }
            }
            gap = gap/2;
        }
        

    }

}
