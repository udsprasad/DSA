package JavaBasics.LatestJava17features;

public interface SQS {

    default void run() {
        System.out.println("running");
    }

    void sendTOSQS();
}
