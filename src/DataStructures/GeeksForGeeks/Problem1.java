package DataStructures.GeeksForGeeks;

//Find the largest three distinct elements in an array
public class Problem1 {
    public static void main(String[] args){
        int[] array = new int[]{10, 4, 3, 50, 23, 90};
        int first, second, third;

        /* There should be atleast three elements */
        if (array.length<3){
            System.out.println( "invalid input");
            return;
        }
        first = second = third = array[0];
        for (int i: array){
            if(first<i){
                third = second;
                second = first;
                first = i;
            }else if(second<i){
                third = second;
                second = i;
            } else if(third>i){
                third =i;
            }
        }
        System.out.println( first + " " + second +" "+ third);
    }
}
