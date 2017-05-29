public class Exercise9_14b 
{
    
    public static void main(String[]args)
    {
        
        if(args.length != 1)
        {
            System.out.println("There is an error, Check it again");
            System.exit(0);
        }
        
        String[] s = args[0].split(" ");
        int[] no = new int[s.length];
        int sum = 0;
        for(int i=0 ; i<=s.length-1 ; i++)
        {
            no[i] = Integer.parseInt(s[i]);
            sum += no[i];
        }
        System.out.println("The Total is " + sum);
        
    }
}
