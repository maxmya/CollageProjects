import java.util.Scanner;
public class Q10
{
    
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the decimal value");
        int decimal = input.nextInt();
        
        System.out.println("The binary value is " + decimalToBinary(decimal));
        
    }
    
    public static String decimalToBinary(int value)
    {
        
        String binary = "";
        while(value > 1)
        {
            binary += value%2;
            value /= 2;
        }
        
        return binary;
    }
}
