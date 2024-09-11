package JavaBasics.LatestJava17features;


import java.util.ArrayList;

public class PracticeInstanceof implements SQS, Stepfunction{
    public static void main(String[] args){
        Object obj = new Person(15,"raju");
        if(obj instanceof Person(int age, String name)){
            System.out.println(name);
        }
    }

    @Override
    public void sendTOSQS() {

    }

    @Override
    public void sentToStepFunction() {

    }
}
record Person(int age, String name){}

