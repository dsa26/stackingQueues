package src.main.java.bench;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)

@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 2)
@Fork(1)

public class PopBench {
    private static StackLL<String> bigStackLL;
    private static StackRA<String> bigStackRA;
    private static QueueLL<String> bigQueueLL;
    private static QueueRA<String> bigQueueRA;

    @Setup(Level.Trial)
    public static void setup() {
        bigStackLL = new StackLL<>();
        bigStackRA = new StackRA<>();
        bigQueueLL = new QueueLL<>();
        bigQueueRA = new QueueRA<>();
        for (int i = 0; i < 10000; i++) {
            bigStackLL.push("Starting Element No. " + i);
            bigStackRA.push("Starting Element No. " + i);
            bigQueueLL.enqueue("Starting Element No. " + i);
            bigQueueRA.enqueue("Starting Element No. " + i);
        }
    }

    @Benchmark
    public static void BigStackRA() {
        for (int i = 0; i < 10000; i++) {
            bigStackRA.pop();
        }
    }

    @Benchmark
    public static void BigStackLL() {
        for (int i = 0; i < 10000; i++) {
            bigStackLL.pop();
        }
    }

    @Benchmark
    public static void BigQueueRA() {
        for (int i = 0; i < 10000; i++) {
            bigQueueRA.dequeue();
        }
    }

    @Benchmark
    public static void BigQueueLL() {
        for (int i = 0; i < 10000; i++) {
            bigQueueLL.dequeue();
        }
    }
}
