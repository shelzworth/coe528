package Ex2;
import java.util.LinkedList;
/**
 * 
 * @author Sheldon Cerejo
 * @param <T> 
 */
public class QADT<T> 
{
// Overview: QADT(Queue Abstract Data Type) is a collection of elements 
// following FIFO (First-In-First-Out) order.
// 
//
// The abstraction function is:
// a) AF(c) = queue q that supports generic types such that q[0] is the first in the queue.
//    While s[q.size() - 1] is the last of the queue that supports n number of elements
//
//
// The rep invariant is:
// b) RI(c) = c.List != null
    private LinkedList<T> List = new LinkedList<>();
    
    //enqueue
    public void enqueue(T element)
    {   
        //MODIFIES: LinkedList List
        //EFFECTS: Adds(Enqueues) an element to the bottom(Last) of the queue
        List.addLast(element);
    }
    //dequeue
    public T dequeue()
    {
        //MODIFIES: LinkedList List
        //EFFECTS: Checks if the list is empty and throws an error 
        //otherwise removes the top element of the queue
        if (isEmpty())
        {
            throw new IllegalStateException("Empty queue.");
        }
        return List.removeFirst();
    }
    
    //isEmpty
    public boolean isEmpty()
    {
        //EFFECTS: Checks List, if List is empty returns true otherwise returns false
        return List.isEmpty();
    }
    //Rep invariant check
    public boolean repOK()
    {
        //EFFECTS: Checks List, if List is not null returns true otherwise returns false 
        return List != null;
    }
    //toString
    @Override
    public String toString()
    {
        // EFFECTS: Returns the elements in the queue as a string
        return List.toString();
    }
}
