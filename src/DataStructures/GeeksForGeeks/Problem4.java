package DataStructures.GeeksForGeeks;

import java.util.Arrays;

/*https://www.geeksforgeeks.org/rearrange-array-such-that-even-positioned-are-greater-than-odd/?ref=lbp
* Rearrange array such that even positioned are greater than odd */
public class Problem4 {
    public static void  main(String[] args){
        int[] array = new int[]{1,2,3,2,1};
        for(int i =1; i< array.length; i=i+2){
            if(array[i-1]>array[i]){
                int temp = array[i-1];
                array[i-1] = array[i];
                array[i]=temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
