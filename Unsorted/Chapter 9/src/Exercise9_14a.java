public class Exercise9_14a 
{
    
    public static void main(String[]args)
    {
        
        if(args.length < 1)
        {
            System.out.println("There is an error, Check it again");
            System.exit(0);
        }
        
        int[] no = new int[args.length];
        int sum = 0;
        for(int i=0 ; i<=args.length-1 ; i++)
        {
            no[i] = Integer.parseInt(args[i]);
            sum += no[i];
        }
        System.out.println("The Total is " + sum);
    }
}
