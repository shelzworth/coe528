package Ex2;

/**
 *
 * @author Sheldon Cerejo
 */
public class Main 
{
    public static void main(String[] args) 
    {
    // Test the queue implementation
    QADT<Integer> queue = new QADT<>();
    // Enqueue elements
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    // Dequeue elements
    int dequeuedElement1 = queue.dequeue(); // 10
    int dequeuedElement2 = queue.dequeue(); // 20
    // Check if the queue is empty
    boolean isEmpty = queue.isEmpty(); // false
    // Expected output
    System.out.println("Dequeued element 1: " + dequeuedElement1);
    System.out.println("Dequeued element 2: " + dequeuedElement2);
    System.out.println("Is the queue empty? " + isEmpty);
    }
}
