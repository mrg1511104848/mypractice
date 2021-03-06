import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class FixedThreadPoolTest {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(3);
    }
}
