package algorithm;

public class KMP {
    public static void main(String[] args) {
        String text = new String("aabaabaaa");
        String pattern = new String("abaa");

        Integer[] nextArray = findNextArray(pattern);
        for(int i =0;i<nextArray.length;i++){
            System.out.println(nextArray[i]);
        }

        int indexOfText = 0;
        int indexOfPattern = 0;
        while (indexOfText < text.length() && indexOfPattern<pattern.length()){
            if(text.charAt(indexOfText) == pattern.charAt(indexOfPattern)){
                indexOfText++;
                indexOfPattern++;
            }
            else{
                if(indexOfPattern>0) indexOfPattern = nextArray[indexOfPattern-1];
                if(text.charAt(indexOfText) != pattern.charAt(indexOfPattern)){
                    indexOfText++;
                }
            }
        }

        if(indexOfPattern== pattern.length()) System.out.println("index of start char is "+(indexOfText-indexOfPattern));
        else System.out.println(-1);

    }

    public static Integer[] findNextArray(String pattern){
        Integer[] nextArray = new Integer[pattern.length()];
        for(int i=0;i<nextArray.length;i++){
            nextArray[i]=0;
        }

        int j = 0;


        for(int i = 1;i<pattern.length();){
            if(pattern.charAt(i)==pattern.charAt(j)){
                nextArray[i++] = ++j;
            }
            else{
                System.out.println("i:"+i);
                System.out.println("j:"+j);
                System.out.println("pattern.charAt(i):"+pattern.charAt(i));
                System.out.println("pattern.charAt(j):"+pattern.charAt(j));
                System.out.println("nextArray[j]:"+nextArray[j]);

                while(pattern.charAt(i) != pattern.charAt(j)   && nextArray[j]!=0 ){
                    j = j-1;
                }
                nextArray[i] = nextArray[j];
                j = nextArray[j];
                i++;
            }
        }
        return nextArray;
    }
}
