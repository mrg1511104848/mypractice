import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CachedThreadPoolTest {
    public static void main(String[] args) {
        Executor executor = Executors.newCachedThreadPool();
    }
}
