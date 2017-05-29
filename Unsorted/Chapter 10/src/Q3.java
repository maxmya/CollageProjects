public class Q3 
{
    
    public static void main(String[]args)
    {
        
        MyInteger integer = new MyInteger(5);
        System.out.println("The Value is: " + integer.getValue());
        System.out.println("Is the value is even? " + integer.isEven());
        System.out.println("Is the value is odd? " + integer.isOdd());
        System.out.println("Is the value is prime? " + integer.isPrime());
        System.out.println("Is 4 is even? " + MyInteger.isEven(4));
        System.out.println("Is 5 is odd? " + MyInteger.isOdd(5));
        System.out.println("Is 7 is prime? " + MyInteger.isPrime(7));
        System.out.println("Is object = 4 is even? " 
                + MyInteger.isEven(new MyInteger(4)));
        System.out.println("Is object = 5 is odd? " 
                + MyInteger.isOdd(new MyInteger(5)));
        System.out.println("Is object = 7 is prime? " 
                + MyInteger.isPrime(new MyInteger(7)));
        System.out.println("Is the value is equal 4 ? " + integer.equals(4));
        System.out.println("Is the value is equal object = 4 ? " 
                + integer.equals(new MyInteger(4)));
        char[] x = {'2','8'};
        System.out.println("Convert the array = {'2', '8'} is: " 
                + MyInteger.parseInt(x));
        System.out.println("Convert th string = \"286\" is"
                + MyInteger.parseInt("286"));
    }
}
