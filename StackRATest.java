public class StackRATest {
    public static void main(String[] args) {
        System.out.println("Testing StackRA Implementation");
        System.out.println("===============================");

        // Run all tests
        testEmptyStack();
        testPushAndPeek();
        testPushAndPop();
        testMultipleOperations();
        testSize();
        testMixedDataTypes();
        testEdgeCases();

        System.out.println("\nAll tests completed!");
    }

    /**
     * Test 1: Empty stack operations
     */
    public static void testEmptyStack() {
        System.out.println("\n--- Test 1: Empty Stack Operations ---");
        StackRA<String> stack = new StackRA<>();

        // Test isEmpty on empty stack
        assert stack.isEmpty() : "Empty stack should return true for isEmpty()";
        System.out.println("✓ isEmpty() works on empty stack");

        // Test size on empty stack
        assert stack.size() == 0 : "Empty stack should have size 0";
        System.out.println("✓ size() returns 0 for empty stack");

        // Test peek on empty stack (should throw exception)
        try {
            stack.peek();
            System.out.println("✗ peek() should throw exception on empty stack");
        } catch (Exception e) {
            System.out.println("✓ peek() correctly throws exception on empty stack");
        }

        // Test pop on empty stack (should throw exception)
        try {
            stack.pop();
            System.out.println("✗ pop() should throw exception on empty stack");
        } catch (Exception e) {
            System.out.println("✓ pop() correctly throws exception on empty stack");
        }
    }

    /**
     * Test 2: Push and peek operations
     */
    public static void testPushAndPeek() {
        System.out.println("\n--- Test 2: Push and Peek Operations ---");
        StackRA<Integer> stack = new StackRA<>();

        // Push single element
        stack.push(42);
        assert !stack.isEmpty() : "Stack should not be empty after push";
        assert stack.size() == 1 : "Stack size should be 1 after one push";
        assert stack.peek() == 42 : "Peek should return the pushed element";
        System.out.println("✓ Single push and peek works");

        // Push multiple elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assert stack.size() == 4 : "Stack size should be 4 after 4 pushes";
        assert stack.peek() == 30 : "Peek should return the most recently pushed element";
        System.out.println("✓ Multiple pushes and peek works");
    }

    /**
     * Test 3: Push and pop operations
     */
    public static void testPushAndPop() {
        System.out.println("\n--- Test 3: Push and Pop Operations ---");
        StackRA<String> stack = new StackRA<>();

        // Push elements
        stack.push("first");
        stack.push("second");
        stack.push("third");

        // Test LIFO behavior
        assert stack.pop().equals("third") : "First pop should return 'third'";
        assert stack.size() == 2 : "Stack size should be 2 after one pop";
        System.out.println("✓ First pop works correctly");

        assert stack.pop().equals("second") : "Second pop should return 'second'";
        assert stack.size() == 1 : "Stack size should be 1 after two pops";
        System.out.println("✓ Second pop works correctly");

        assert stack.pop().equals("first") : "Third pop should return 'first'";
        assert stack.isEmpty() : "Stack should be empty after all pops";
        assert stack.size() == 0 : "Stack size should be 0 after all pops";
        System.out.println("✓ Third pop works correctly");
    }

    /**
     * Test 4: Multiple operations in sequence
     */
    public static void testMultipleOperations() {
        System.out.println("\n--- Test 4: Multiple Operations Sequence ---");
        StackRA<Integer> stack = new StackRA<>();

        // Push some elements
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Peek without removing
        assert stack.peek() == 3 : "Peek should return 3";
        assert stack.size() == 3 : "Size should still be 3 after peek";
        System.out.println("✓ Peek doesn't remove elements");

        // Pop one element
        assert stack.pop() == 3 : "Pop should return 3";

        // Push more elements
        stack.push(4);
        stack.push(5);

        // Check current state
        assert stack.peek() == 5 : "Peek should return 5";
        assert stack.size() == 4 : "Size should be 4";
        System.out.println("✓ Mixed push/pop operations work");

        // Pop all remaining elements
        assert stack.pop() == 5 : "Pop should return 5";
        assert stack.pop() == 4 : "Pop should return 4";
        assert stack.pop() == 2 : "Pop should return 2";
        assert stack.pop() == 1 : "Pop should return 1";
        assert stack.isEmpty() : "Stack should be empty";
        System.out.println("✓ All elements popped correctly");
    }

    /**
     * Test 5: Size method
     */
    public static void testSize() {
        System.out.println("\n--- Test 5: Size Method ---");
        StackRA<Character> stack = new StackRA<>();

        // Test size on empty stack
        assert stack.size() == 0 : "Empty stack should have size 0";
        System.out.println("✓ Empty stack size is 0");

        // Test size after pushes
        stack.push('A');
        assert stack.size() == 1 : "Stack with 1 element should have size 1";

        stack.push('B');
        stack.push('C');
        assert stack.size() == 3 : "Stack with 3 elements should have size 3";
        System.out.println("✓ Size calculation works for pushes");

        // Test size after pops
        stack.pop();
        assert stack.size() == 2 : "Stack should have size 2 after one pop";

        stack.pop();
        stack.pop();
        assert stack.size() == 0 : "Stack should have size 0 after all pops";
        System.out.println("✓ Size calculation works for pops");
    }

    /**
     * Test 6: Different data types
     */
    public static void testMixedDataTypes() {
        System.out.println("\n--- Test 6: Different Data Types ---");

        // Test with Integer
        StackRA<Integer> intStack = new StackRA<>();
        intStack.push(100);
        intStack.push(200);
        assert intStack.pop() == 200 : "Integer stack should work correctly";
        System.out.println("✓ Integer stack works");

        // Test with String
        StackRA<String> stringStack = new StackRA<>();
        stringStack.push("Hello");
        stringStack.push("World");
        assert stringStack.pop().equals("World") : "String stack should work correctly";
        System.out.println("✓ String stack works");

        // Test with Double
        StackRA<Double> doubleStack = new StackRA<>();
        doubleStack.push(3.14);
        doubleStack.push(2.71);
        assert doubleStack.pop() == 2.71 : "Double stack should work correctly";
        System.out.println("✓ Double stack works");
    }

    /**
     * Test 7: Edge cases
     */
    public static void testEdgeCases() {
        System.out.println("\n--- Test 7: Edge Cases ---");
        StackRA<String> stack = new StackRA<>();

        // Test with null values
        stack.push(null);
        assert stack.size() == 1 : "Stack should handle null values";
        assert stack.peek() == null : "Peek should return null for null value";
        assert stack.pop() == null : "Pop should return null for null value";
        System.out.println("✓ Null values handled correctly");

        // Test with empty strings
        stack.push("");
        stack.push(" ");
        assert stack.pop().equals(" ") : "Should handle empty strings";
        assert stack.pop().equals("") : "Should handle empty strings";
        System.out.println("✓ Empty strings handled correctly");

        // Test with very long strings
        String longString = "a".repeat(1000);
        stack.push(longString);
        assert stack.pop().equals(longString) : "Should handle very long strings";
        System.out.println("✓ Long strings handled correctly");
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