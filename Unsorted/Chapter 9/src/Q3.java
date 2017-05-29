import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import java.util.Scanner;
public class Q3 
{
    
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter The Password");
        String pass = input.next();
        if(checkPass(pass))
            System.out.println("Valid Password");
        else
            System.out.println("Invalid Password");
    }
    
    public static boolean checkPass(String pass)
    {
               
        if(pass.length() <= 8)
            return false;
        
        boolean is1 = false;
        boolean is2 = false;
        int count = 0;
        for(int i=0; i<=pass.length()-1 ; i++)
        {
            if(isDigit(pass.charAt(i)))
                is1 = true;
                count++;
                
            if(isLetter(pass.charAt(i)))
                is2 = true;           
        }
        if(!is1 && !is2)
            return false;
        else if(count < 2)
            return false;
        
        return true; 
    }
}
