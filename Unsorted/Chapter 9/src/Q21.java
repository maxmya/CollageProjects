import java.io.FileNotFoundException;
public class Q21 
{
    
    public static void main(String[]args) throws FileNotFoundException
    {
        
        if (args.length != 4) 
        {
             System.out.println(
                    "Usage: java ReplaceText sourceFile targetFile oldStr newStr");
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
        String newWords = "";
        while(input.hasNextLine())
        {
            String words[] = input.nextLine().split(" ");
            for(int i = 0 ; i < words.length ; i++)
            {
                if(words[i].equals(args[1]))
                    words[i] = "";
                
                newWords += words[i]+" " ;
            }			
        }
        file.delete(); 
        
        java.io.File file2 = new java.io.File(args[0]);
        java.io.PrintWriter output = new java.io.PrintWriter(file2);
        output.print(newWords);
        
        input.close();
        output.close();
    }
}
