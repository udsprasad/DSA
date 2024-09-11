package DataStructures.GeeksForGeeks;

import java.util.Arrays;
import java.util.List;

// Move all zeroes to end of array
public class Problem3 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0);
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != 0) {
                list.set(count++, list.get(i));
            }
        }
        for(int i = count; i< list.size();i++ ){
            list.set(i,0);
        }
        System.out.println(list);
    }
}
