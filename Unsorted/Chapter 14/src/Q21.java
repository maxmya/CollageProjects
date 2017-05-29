public class Q21 
{
    public static void main(String[]args)
    {
        java.util.Scanner input = new java.util.Scanner(System.in);
        
        System.out.print("Enter the first complex number: ");
        double a1 = input.nextDouble();
        double b1 = input.nextDouble();
        Complex first = new Complex(a1, b1);
        System.out.print("Enter the second complex number: ");
        double a2 = input.nextDouble();
        double b2 = input.nextDouble();
        Complex second = new Complex(a2, b2);
        System.out.println(first.toString() + " + " + second.toString() + " = "
            + first.add(second).toString());
        System.out.println(first.toString() + " - " + second.toString() + " = "
            + first.subtract(second).toString());   
        System.out.println(first.toString() + " * " + second.toString() + " = "
            + first.multiply(second).toString());
        System.out.println(first.toString() + " / " + second.toString() + " = "
            + first.divide(second).toString());
        System.out.println("| " + first.toString() + " |  = "
            + first.abs());
    }
}
