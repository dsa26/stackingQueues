package src.main.java.bench;

public class QueueLLTest {
    public static void main(String[] args) {
        System.out.println("Testing QueueLL Implementation");
        System.out.println("==============================");

        // Run all tests
        testEmptyQueue();
        testEnqueueAndDequeue();
        testFIFOBehavior();
        testMultipleOperations();
        testSize();
        testMixedDataTypes();
        testEdgeCases();

        System.out.println("\nAll tests completed!");
    }

    /**
     * Test 1: Empty queue operations
     */
    public static void testEmptyQueue() {
        System.out.println("\n--- Test 1: Empty Queue Operations ---");
        QueueLL<String> queue = new QueueLL<>();

        // Test isEmpty on empty queue
        assert queue.isEmpty() : "Empty queue should return true for isEmpty()";
        System.out.println("✓ isEmpty() works on empty queue");

        // Test size on empty queue
        assert queue.size() == 0 : "Empty queue should have size 0";
        System.out.println("✓ size() returns 0 for empty queue");

        // Test dequeue on empty queue (should return null)
        assert queue.dequeue() == null : "dequeue() should return null on empty queue";
        System.out.println("✓ dequeue() returns null on empty queue");
    }

    /**
     * Test 2: Enqueue and dequeue operations
     */
    public static void testEnqueueAndDequeue() {
        System.out.println("\n--- Test 2: Enqueue and Dequeue Operations ---");
        QueueLL<Integer> queue = new QueueLL<>();

        // Enqueue single element
        queue.enqueue(42);
        assert !queue.isEmpty() : "Queue should not be empty after enqueue";
        assert queue.size() == 1 : "Queue size should be 1 after one enqueue";
        System.out.println("✓ Single enqueue works");

        // Dequeue single element
        assert queue.dequeue() == 42 : "Dequeue should return the enqueued element";
        assert queue.isEmpty() : "Queue should be empty after dequeue";
        assert queue.size() == 0 : "Queue size should be 0 after dequeue";
        System.out.println("✓ Single dequeue works");

        // Enqueue multiple elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assert queue.size() == 3 : "Queue size should be 3 after 3 enqueues";
        System.out.println("✓ Multiple enqueues work");
    }

    /**
     * Test 3: FIFO (First In, First Out) behavior
     */
    public static void testFIFOBehavior() {
        System.out.println("\n--- Test 3: FIFO Behavior ---");
        QueueLL<String> queue = new QueueLL<>();

        // Enqueue elements in order
        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");

        // Test FIFO behavior
        assert queue.dequeue().equals("first") : "First dequeue should return 'first'";
        assert queue.size() == 2 : "Queue size should be 2 after one dequeue";
        System.out.println("✓ First dequeue works correctly");

        assert queue.dequeue().equals("second") : "Second dequeue should return 'second'";
        assert queue.size() == 1 : "Queue size should be 1 after two dequeues";
        System.out.println("✓ Second dequeue works correctly");

        assert queue.dequeue().equals("third") : "Third dequeue should return 'third'";
        assert queue.isEmpty() : "Queue should be empty after all dequeues";
        assert queue.size() == 0 : "Queue size should be 0 after all dequeues";
        System.out.println("✓ Third dequeue works correctly");
    }

    /**
     * Test 4: Multiple operations in sequence
     */
    public static void testMultipleOperations() {
        System.out.println("\n--- Test 4: Multiple Operations Sequence ---");
        QueueLL<Integer> queue = new QueueLL<>();

        // Enqueue some elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Dequeue one element
        assert queue.dequeue() == 1 : "Dequeue should return 1";
        assert queue.size() == 2 : "Size should be 2 after one dequeue";
        System.out.println("✓ First dequeue works");

        // Enqueue more elements
        queue.enqueue(4);
        queue.enqueue(5);

        // Check current state
        assert queue.size() == 4 : "Size should be 4";
        System.out.println("✓ Mixed enqueue/dequeue operations work");

        // Dequeue all remaining elements
        assert queue.dequeue() == 2 : "Dequeue should return 2";
        assert queue.dequeue() == 3 : "Dequeue should return 3";
        assert queue.dequeue() == 4 : "Dequeue should return 4";
        assert queue.dequeue() == 5 : "Dequeue should return 5";
        assert queue.isEmpty() : "Queue should be empty";
        System.out.println("✓ All elements dequeued correctly");
    }

    /**
     * Test 5: Size method
     */
    public static void testSize() {
        System.out.println("\n--- Test 5: Size Method ---");
        QueueLL<Character> queue = new QueueLL<>();

        // Test size on empty queue
        assert queue.size() == 0 : "Empty queue should have size 0";
        System.out.println("✓ Empty queue size is 0");

        // Test size after enqueues
        queue.enqueue('A');
        assert queue.size() == 1 : "Queue with 1 element should have size 1";

        queue.enqueue('B');
        queue.enqueue('C');
        assert queue.size() == 3 : "Queue with 3 elements should have size 3";
        System.out.println("✓ Size calculation works for enqueues");

        // Test size after dequeues
        queue.dequeue();
        assert queue.size() == 2 : "Queue should have size 2 after one dequeue";

        queue.dequeue();
        queue.dequeue();
        assert queue.size() == 0 : "Queue should have size 0 after all dequeues";
        System.out.println("✓ Size calculation works for dequeues");
    }

    /**
     * Test 6: Different data types
     */
    public static void testMixedDataTypes() {
        System.out.println("\n--- Test 6: Different Data Types ---");

        // Test with Integer
        QueueLL<Integer> intQueue = new QueueLL<>();
        intQueue.enqueue(100);
        intQueue.enqueue(200);
        assert intQueue.dequeue() == 100 : "Integer queue should work correctly";
        System.out.println("✓ Integer queue works");

        // Test with String
        QueueLL<String> stringQueue = new QueueLL<>();
        stringQueue.enqueue("Hello");
        stringQueue.enqueue("World");
        assert stringQueue.dequeue().equals("Hello") : "String queue should work correctly";
        System.out.println("✓ String queue works");

        // Test with Double
        QueueLL<Double> doubleQueue = new QueueLL<>();
        doubleQueue.enqueue(3.14);
        doubleQueue.enqueue(2.71);
        assert doubleQueue.dequeue() == 3.14 : "Double queue should work correctly";
        System.out.println("✓ Double queue works");
    }

    /**
     * Test 7: Edge cases
     */
    public static void testEdgeCases() {
        System.out.println("\n--- Test 7: Edge Cases ---");
        QueueLL<String> queue = new QueueLL<>();

        // Test with null values
        queue.enqueue(null);
        assert queue.size() == 1 : "Queue should handle null values";
        assert queue.dequeue() == null : "Dequeue should return null for null value";
        System.out.println("✓ Null values handled correctly");

        // Test with empty strings
        queue.enqueue("");
        queue.enqueue(" ");
        assert queue.dequeue().equals("") : "Should handle empty strings";
        assert queue.dequeue().equals(" ") : "Should handle empty strings";
        System.out.println("✓ Empty strings handled correctly");

        // Test with very long strings
        String longString = "a".repeat(1000);
        queue.enqueue(longString);
        assert queue.dequeue().equals(longString) : "Should handle very long strings";
        System.out.println("✓ Long strings handled correctly");

        // Test alternating enqueue/dequeue
        queue.enqueue("A");
        queue.enqueue("B");
        assert queue.dequeue().equals("A") : "Should maintain FIFO order";
        queue.enqueue("C");
        assert queue.dequeue().equals("B") : "Should maintain FIFO order";
        assert queue.dequeue().equals("C") : "Should maintain FIFO order";
        System.out.println("✓ Alternating operations maintain FIFO order");
    }

    /**
     * Test 8: Stress test with many operations
     */
    public static void testStressTest() {
        System.out.println("\n--- Test 8: Stress Test ---");
        QueueLL<Integer> queue = new QueueLL<>();

        // Enqueue many elements
        for (int i = 0; i < 1000; i++) {
            queue.enqueue(i);
        }
        assert queue.size() == 1000 : "Queue should have 1000 elements";
        System.out.println("✓ Enqueued 1000 elements");

        // Dequeue all elements and verify order
        for (int i = 0; i < 1000; i++) {
            assert queue.dequeue() == i : "Dequeue order should be maintained";
        }
        assert queue.isEmpty() : "Queue should be empty after all dequeues";
        System.out.println("✓ Dequeued 1000 elements in correct order");
    }

    /**
     * Helper method to run tests with exception handling
     */
    public static void runTest(String testName, Runnable test) {
        try {
            test.run();
            System.out.println("✓ " + testName + " passed");
        } catch (AssertionError e) {
            System.out.println("✗ " + testName + " failed: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("✗ " + testName + " failed with exception: " + e.getMessage());
        }
    }
}