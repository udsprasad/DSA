package JavaBasics.LatestJava17features;

public interface Stepfunction {
    default void submit(){
        System.out.println("submit");
    }

    void sentToStepFunction();
}
