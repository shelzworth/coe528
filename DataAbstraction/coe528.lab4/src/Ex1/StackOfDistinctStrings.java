package Ex1;
/**
 *
 * @author Sheldon Cerejo
 */
import java.util.ArrayList;
public class StackOfDistinctStrings 
{
// Overview: StacksOfDistinctStrings are mutable, bounded
// collection of distinct strings that operate in
// LIFO (Last-In-First-Out) order.
//
// The abstraction function is:
// a) AF(c) = string stack s such that s[0] is the bottom of the stack.
//    While s[s.size() - 1] is the top of the stack that supports n number of elements
//
//
//
// The rep invariant is:
// b) RI(c) = c.items != null && all elements are unique && !null
//
//
//
//
//
private ArrayList<String> items;
// constructor
public StackOfDistinctStrings() 
{
// EFFECTS: Creates a new StackOfDistinctStrings object
items = new ArrayList<String>();
}
public void push(String element) throws Exception 
{
// MODIFIES: this
// EFFECTS: Appends the element at the top of the stack
// if the element is not in the stack, otherwise
// does nothing.
if(element == null) throw new Exception();
if(false == items.contains(element))
items.add(element);
}
public String pop() throws Exception 
{
// MODIFIES: this
// EFFECTS: Removes an element from the top of the stack
if (items.isEmpty()) throw new Exception();
return items.remove(items.size()-1);
}
public boolean repOK() 
{
    // EFFECTS: Returns true if the rep invariant holds for this
    // object; otherwise returns false
    if (items == null)
    {
        return false;
    }
    for(int i = 0; i< items.size(); i++)
    {
        if(items.get(i) == null)
        {
            return false;
        }
        for(int j = i + 1; j < items.size(); j++)
        {
            if(items.get(i).equals(items.get(j)))
            {
                return false;
            }
        }
    }
    return true;
}
@Override
public String toString() 
{
// EFFECTS: Returns a string that contains the strings in the
// stack and the top element. Implements the
// abstraction function.
    return "StackOfDistinctStrings: " + items.toString();
}
}
