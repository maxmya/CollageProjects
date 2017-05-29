import java.util.Scanner;
public class Q10 
{
    
     public static void main(String[]args)
     {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the numbers of a, b, c, of the equation");
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        
        QuadraticEquation eq = new QuadraticEquation(a, b, c);
        
        System.out.println("The discriminant = " + eq.getDiscriminant());
        
        if(eq.getDiscriminant() == 0)
            System.out.println("The only root = " + eq.getRoot1());
        else
            System.out.println("The roots = " + eq.getRoot1() + ", " + 
                    eq.getRoot2());
        
    } 
}
