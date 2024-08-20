package ex2;

/**
 *
 * @author Sheldon Cerejo
 */
public class Ex2 {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) 
    {
        if(args.length == 1) 
        {
        if (args[0].equals("1"))
        System.out.println(isPalindrome(null));
        else if (args[0].equals("2"))
        System.out.println(isPalindrome(""));
        else if (args[0].equals("3"))
        System.out.println(isPalindrome("deed"));
        else if (args[0].equals("4"))
        System.out.println(isPalindrome("abcd"));
        }
    }
    //Requires: a valid string a, not null and where a value occurs
    //Modifies: none
    //Effects: i such that if a[i] = a[a.length - 1 - i] returns true 
    //otherwise returns false || if a is empty or null  
public static boolean isPalindrome(String a) 
    {
        //write the code for isPalindrome
        if(a == null) 
        {
            return false;
        }
        for(int i = 0; i < a.length(); i++)
        {
            if(a.charAt(i) == a.charAt(a.length()-(1+i)))
            {
                return true;
            }
        }
        return false;
    }
}
