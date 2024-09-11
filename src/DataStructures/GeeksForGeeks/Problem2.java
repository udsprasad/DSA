package DataStructures.GeeksForGeeks;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

//Find Second largest element in an array
public class Problem2 {
    public static void main(String[] args){
        Integer[] array =new Integer[]{12, 35, 1, 10, 34, 1};
        usingSortingUsingpreDefinedMethod(array);
    }
    static void usingSortingUsingpreDefinedMethod(Integer[] array){
        Arrays.sort(array, Collections.reverseOrder());
        System.out.println(array[1]);
    }
}
