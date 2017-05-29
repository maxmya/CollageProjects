public class Q7 
{
    public static void main(String[]args){
        java.util.Scanner input =new java.util.Scanner(System.in);
         
        Account[] account = new Account[10];
        for(int i=0 ;i<=account.length-1 ; i++)
        {
            account[i] = new Account(i,100);
        }
        while(true)
        {
            System.out.print("\nEnter an id: ");
            int id = input.nextInt();
            if(!isCorrect(account, id))
            {
                System.out.println("There is no account with this id");
                System.exit(0);
            }
               
            while(true)
            {
                System.out.println("\nMain menu\n" +
                        "1: check balance\n" +
                        "2: withdraw\n" +
                        "3: deposit\n" +
                        "4: exit");
                
                System.out.print("Enter a choice: ");
                int choice = input.nextInt();
                if(choice == 1)
                    System.out.println("The balance is " + account[id].getBalance());
                else if(choice == 2)
                {
                    System.out.print("Enter an amount to withdraw: ");
                    int withdraw = input.nextInt();
                    account[id].withdraw(withdraw);
                }
                else if(choice == 3)
                {
                    System.out.print("Enter an amount to deposit: ");
                    int deposit = input.nextInt();
                    account[id].deposit(deposit);
                }
                else if(choice == 4)
                    break;
                else
                    System.out.println("Check your choice again");
            }
        }
    }
     
    public static boolean isCorrect(Account[] x ,int id)
    {
        boolean correct = false;
        for(int i=0 ; i<=x.length-1 ; i++)
        {
            if(id == x[i].getId())
                correct = true;
        }
        return correct;
    }
}
