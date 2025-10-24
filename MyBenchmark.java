import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class MyBenchmark {
    int x;

    @Setup(Level.Iteration)
    public void setup() {
        x = 0;
    }

    @Benchmark
    public int inc() {
        return ++x;
    }
}
