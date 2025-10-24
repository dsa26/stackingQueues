package src.main.java.bench;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)

@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 2)
@Fork(1)

public class PushBench {
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
        }
    }

    @Benchmark
    public static void SmallStackRA() {
        StackRA<String> stackRA = new StackRA<>();
        for (int i = 0; i < 10000; i++) {
            stackRA.push("Element No. " + i);
        }
    }

    @Benchmark
    public static void BigStackRA() {
        for (int i = 0; i < 10000; i++) {
            bigStackRA.push("Element No. " + i);
        }
    }

    @Benchmark
    public static void SmallStackLL() {
        StackLL<String> stackLL = new StackLL<>();
        for (int i = 0; i < 10000; i++) {
            stackLL.push("Element No. " + i);
        }
    }

    @Benchmark
    public static void BigStackLL() {
        for (int i = 0; i < 10000; i++) {
            bigStackLL.push("Element No. " + i);
        }
    }

    @Benchmark
    public static void SmallQueueLL() {
        QueueLL<String> queueLL = new QueueLL<>();
        for (int i = 0; i < 10000; i++) {
            queueLL.enqueue("Element No. " + i);
        }
    }

    @Benchmark
    public static void BigQueueLL() {
        for (int i = 0; i < 10000; i++) {
            bigQueueLL.enqueue("Element No. " + i);
        }
    }
}
