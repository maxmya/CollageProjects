import java.io.*;
import java.util.*;
public class Q17 
{
    
    public static void main(String[]args) throws FileNotFoundException
    {
        File file = new File(args[0]);
        Scanner input = new Scanner(file);
        
        int countChar = 0;
        int countWords = 0;
        int countLine = 0;
        while(input.hasNextLine())
        {
            countLine++;
            String Lines = input.nextLine();
            countChar += Lines.length(); 
            String[] words = Lines.split("[ \t\r\n]");
            countWords += words.length;
            for(int i=0 ; i<=words.length-1 ;i++)
            {
                words[i] = words[i].trim();
                if(words[i].equals(""))
                    countWords--;
            }
        }
        System.out.println(
        "There is " + countChar + " Charcter\n"
        + "And There is " + countWords + " Word\n"
        + "And There is " + countLine + " Line");
        
    }
}
