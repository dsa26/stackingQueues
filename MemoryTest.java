import org.openjdk.jmh.annotations.*;

// import java.lang.foreign.MemorySegment.Scope;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
public class MemoryTest {
    @Setup(Level.Invocation)
    public static void main(String[] args) {

    }

    @Benchmark
    public static String[] myMethod() {
        // Your method logic here, which might create objects
        String[] largeArray = new String[30000000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = new String("Example String " + i);
        }
        return largeArray;
    }
}
