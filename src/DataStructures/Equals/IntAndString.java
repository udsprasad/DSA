package DataStructures.Equals;

public class IntAndString {
    public static void main(String args[]){
        int a = 1;
        int b = a;
        System.out.println(a==b);

        a= 2;
        System.out.println(a==b);

        String one = "one";
        String two = one;

        System.out.println(one==two);

        one = "two";
        System.out.println(one==two);
    }
}
