package coe528.lab2;

/**
 *
 * @author Sheldon Cerejo
 */
public class AnagramChecker 
{
    public static void main(String[] args) 
    {
        if(args.length == 1) 
        {
            if (args[0].equals("1"))
            System.out.println(areAnagrams("listen", "silent"));
            else if (args[0].equals("2"))
            System.out.println(areAnagrams("Hello", "World"));
            else if (args[0].equals("3"))
            System.out.println(areAnagrams("Dormitory", "Dirty room"));
        }
    }
    
    //Requires: str1 and str2 to be a string that is not null
    
    //Modifies: local variables str1 and str2 by replaceAll() on white space
    
    //Effects: str1 and str2 by replacing whitespace, 
    //i and j such that if str1.charAt[i] != any charAt[j] for str2 then the loops 
    //are broken and false is returned otherwise if the loop is not broken it is true.
    
    public static boolean areAnagrams(String str1, String str2)
    {
        str1.replaceAll("\\s","");
        str2.replaceAll("\\s","");
        if(str1.length() == str2.length())
        {
            for(int i = 0; i < str1.length() -1; i++)
            {
                for(int j = 0; j < str2.length() - 1; j++)
                {
                    if(str1.charAt(i) != str2.charAt(j))
                    {
                        break;
                    }
                    else
                    {
                        return true;
                    }
                }
            }
        }
        return false;

    }
}
