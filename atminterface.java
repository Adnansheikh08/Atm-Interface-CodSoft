import java.util.Scanner;
class atminterface
{
    Scanner sc=new Scanner(System.in);
    int pin=3721;//preset pin   
     static double balance=1500.00;//preset amount present in the account of the user;
    void menu()
    {
        System.out.println("");
        System.out.println("1.Check Balance");
        System.out.println("2.Withdrawl");
        System.out.println("3.Transfer Balance");
        System.out.println("4.Add Money");
        System.out.println("5.Pin Generation");
        System.out.println("6.Exit");
        System.out.println("Enter Your Choice");
        int ch=sc.nextInt();
        switch(ch)
        {
            case 1:
                Checkbalance();
                break;
                case 2:
                withdrawl();
                break;
                case 3:
                transfer();;
                break;
                case 4:
                addMoney();
                break;
                case 5:
                pinchange();
                break;
                case 6:
                System.out.println("Session Terminated");
                main();
        }
    }
    void Checkbalance()//Function to Check Balance of the user;
    {
        System.out.println("Available Balance :"+balance);
        menu();
    }
    void withdrawl()//Function to allow user withdraw the money
    {
        System.out.println("Enter Amount to be withdrawn");
        double wd=sc.nextDouble();
        if(balance>=wd)
        {
        balance=balance-wd;
        Checkbalance();
        }   
        else
        {
        System.out.println("Insufficient Balance");
        menu();
        }
    }
    void transfer()//Function that allows user to transfer money to any other user;
    {
        System.out.println("Enter Id of Receiver");
        int t=sc.nextInt();
        System.out.println("Enter Money to we withdrawn");
         double wd=sc.nextDouble();
        if(balance>=wd)
        {
        balance=balance-wd;
        System.out.println("Tranferred");
        Checkbalance();
        }   
        else
        {
        System.out.println("Insufficient Balance");
        menu();
        }
    }
     void addMoney()//Function to allow user add money into their Account;
    {
        System.out.println("Enter Amount to be Added");
        double am=sc.nextDouble();
        balance=balance+am;
        Checkbalance();
    }
    void pinchange()//Function to allow user to change the pin;
    {
        
        boolean c1=true;
        while(c1)
        {
             System.out.println("Enter your pin");
             int p=sc.nextInt();
             if(p==pin)
             {
                 System.out.println("Enter your new pin");
                 int p2=sc.nextInt();
                 pin=p2;
                 System.out.println("New Pin= "+pin);
                 main();
             }
             else
             {
                     System.out.println("Relogin");
                     main();
             }
        }
    }
    void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Atm Id");
        int atmid=sc.nextInt();
        System.out.println("Welcome "+atmid+" Enter your pin");
        boolean c=true;
          int count=3;
        while(c)
        {
            int ip=sc.nextInt();
        if(ip==pin)
        {
           System.out.println("Correct Pin");
           menu();
        }
        else
        {
            System.out.println("Invalid Pin");
            --count;
            System.out.println("Tries left "+count);
            System.out.println("");
            System.out.println("Enter Pin Again");
            if(count==0)
            {
                System.out.println("Relogin");
                main();
            }
        }
        }
      }
}