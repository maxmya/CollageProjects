import static java.lang.Character.isUpperCase;
public class Q15 
{
    
    public static void main(String[]args)
    {
        
        if(args.length<1 || args.length>1)
        {
            System.out.println("There is error, Check it again");
            System.exit(0);
        }
         String s = args[0];
        System.out.println("The nimber of upper letter is " + sumLetter(s));
        
    }
    
    public static int sumLetter(String s)
    {
        
        int sum = 0;
        
        for(int i=0 ; i<s.length() ; i++)
        {
            if(isUpperCase(s.charAt(i)))
                sum++;
        }
        
        return sum;
    }
}
