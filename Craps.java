import java.util.*;  
/**
 * Driver class
 * Rolls 2 dice until someone wins craps
 *
 * @author LCH and Sacha
 * @version 19/2/21
 */
public class Craps 
{
    /**
    * This class rolls 2 dice objects and declares a winner *cont*
    * as per the usual rules of street craps 
    * 
    * @param args
    */
    public static void main(String[] args) 
    {
        Dice myDice = new Dice();
        Dice myDice1 = new Dice();        
        final int LOSS1 = 2;
        final int LOSS2 = 3;
        final int LOSS3 = 12;
        final int OUT = 7;
        final int WIN = 11;
        final int FACES = 6;   
        int face;
        int face1;
        int loop = 1;
        String newBet;
        String newPlayer;
        while (loop == 1)
        {
            int target = 0;
            int won = 0;
            int firstroll = 1;
            int total = 0;
            
            while (won == 0) 
            {
                if (firstroll == 1) 
                {      
                   firstroll = 0;
                   face = myDice.roll(FACES);
                   face1 = myDice1.roll(FACES);
                   total = face + face1;           
                   if (total == LOSS1 || total == LOSS2 || total == LOSS3)
                   {
                       System.out.println("The shooter loses as they rolled " + total); 
                       break;
                   }else if (total == OUT || total == WIN)
                   {
                       System.out.println("The shooter wins as they rolled " + total);
                       won = 1;
                       break;
                   }else
                   {
                       System.out.println("The shooters' target is now " + total);
                       target = total;
                       total = 0;
                   }    
                }
                face = myDice.roll(FACES);
                face1 = myDice1.roll(FACES);
                total = face + face1;           
                if (won == 0)
                {
                    if (total == target)
                    {
                        System.out.println("The shooter wins as they rolled " + total);
                        won = 1;
                    }else if (total == OUT)
                    {
                        System.out.println("The shooter loses as they rolled an out " + OUT);
                        break;
                    }else
                    {
                        System.out.println("The shooter rolled " + total);
                    }
                }
            }
            Scanner sc= new Scanner(System.in);
            System.out.print("Do you wish to continue? ");
            loop = sc.nextInt();
        }
    } 
}