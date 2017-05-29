import java.util.Scanner;
public class Q12 
{
    
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter two String");
        String s1 = input.next();
        String s2 = input.next();
        if(isAnagram(s1, s2))
            System.out.println("the two string is anagram");
        else
            System.out.println("the two string is not anagram");
        
    }
    
    public static boolean isAnagram(String s1, String s2)
    {
        
        Character c1;
        Character c2;
        
        for(int i=0 ; i<=s1.length()-1 ; i++)
        {
            for(int j=0 ; j<=s2.length()-1 ; j++)
            {
                c1 = new Character(s1.charAt(i));
                c2 = new Character(s2.charAt(j));
                if(c1.equals(c2))
                   s2 = s2.replace(s1.charAt(i), ' ');
            }
        }
        
        for(int i=0 ; i<=s2.length()-1 ; i++)
        {
            if(s2.charAt(i) != ' ')
                return false;
        }
        return true;
    }
}
