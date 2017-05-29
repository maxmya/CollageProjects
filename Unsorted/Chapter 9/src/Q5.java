import static java.lang.Character.isDigit;
import java.util.Scanner;
public class Q5 
{
    
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the string");
        String s = input.next();
        int[] count = count(s);
        for(int i=0 ; i<=count.length-1 ; i++)
        {
            if(count[i]==1 || count[i]==0)
                System.out.println(i + " apears " + count[i] + " time");
            else
                System.out.println(i + " apears " + count[i] + " times");
        }
    }
    
    public static int[] count(String s)
    {
        
        int[] count = new int[10];
        for(int i=0 ; i<= s.length()-1; i++)
        {
            if(isDigit(s.charAt(i)))
                count[(int)s.charAt(i) - 48]++;
        }
        return count; 
    }
}
