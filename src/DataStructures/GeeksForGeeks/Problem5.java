package DataStructures.GeeksForGeeks;

import java.util.Arrays;

/*Rearrange an array in maximum minimum form using Two Pointer Technique*/
public class Problem5 {
    public static void main(String[] args){
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        int small = 0, n=array.length, large = n-1;
        int[] temp = new int[n];
        boolean flag = true;
        for (int i=0;i<n; i++){
            if (flag) {
                temp[i] = array[large--];
            } else {
                temp[i] = array[small++];
            }
            flag = !flag;
        }
        System.out.println(Arrays.toString(temp));
    }
}
