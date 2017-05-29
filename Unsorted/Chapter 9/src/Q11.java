import java.util.Scanner;
public class Q11
{
    
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the string");
        String s = input.next();
        
        System.out.println("the string after sorting is: " + sort(s));
    }
    
    public static String sort(String s)
    {
        
        Character firstChar;
        Character nextChar;
        
        for(int i=0 ; i<s.length()-1 ; i++)
        {
            firstChar = new Character(s.charAt(i));
            nextChar = new Character(s.charAt(i+1));
           
            if(firstChar.compareTo(nextChar) > 0)
            {
                s = s.replace(firstChar, nextChar);
                String x = s.substring(0, i+1);
                s = s.substring(i+1,s.length());
                s = s.replace(nextChar, firstChar);
                s = x + s;
                i = 0;
            }
        }
        
        return s;
    }
}
