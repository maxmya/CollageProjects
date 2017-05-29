import java.io.FileNotFoundException;
public class Q20 
{
    
    public static void main(String[]args) throws FileNotFoundException
    {
        
        if (args.length != 3) 
        {
             System.out.println(
                    "Usage: java ReplaceText File oldString newString");
             System.exit(0);
        }
        
        java.io.File file = new java.io.File(args[0]);
        if (!file.exists())
        {
            System.out.println("Source file " + args[0] + " does not exist");      
            System.exit(0); 		
        }
        System.out.println(file.getAbsolutePath());
                
        java.util.Scanner input = new java.util.Scanner(file);
        StringBuilder stringBuilder = new StringBuilder();
        while(input.hasNextLine())	
        {
            String s1 = input.nextLine();
            stringBuilder.append(s1.replaceAll(args[1], args[2]));
            stringBuilder.append("\r\n");
        }
        input.close();
        
        java.io.PrintWriter output = new java.io.PrintWriter(args[0]);
        output.print(stringBuilder.toString());
        output.close();
    }
}
