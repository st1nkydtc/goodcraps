/**
 * Driver class
 * Rolls 2 dice until someone wins craps
 *
 * @author LCH and Sacha
 * @version 19/2/21
 */
public class CrapStats
{
    /**
    * This class plays the craps game 1000 times and records statistics about the game
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
        int loop = 1000;
        int rollcount = 0;
        int firstRollW = 0;
        int firstRollL = 0;
        int pointW = 0;
        int pointL = 0;
        int maxPointW = 0;
        int minPointW = 1000;
        int avgPointW = 0;
        int firstroll = 1;
        int won;
        while (loop > 0)
        {
            int target = 0;
            won = 0;            
            int total = 0;
            firstroll = 1;
            while (won == 0)
            {
                if (firstroll == 1)
                {      
                   face = myDice.roll(FACES);
                   face1 = myDice1.roll(FACES);
                   total = face + face1;
                   firstroll = 0;
                   rollcount += 1;
                   if (total == LOSS1 || total == LOSS2 || total == LOSS3)
                   {
                       firstRollL += 1;
                       break;
                   }else if (total == OUT || total == WIN)
                   {
                       firstRollW += 1;
                       won = 1;                      
                       break;
                   }else
                   {
                       target = total;
                   }
                }                
                if (won == 0)
                {
                    face = myDice.roll(FACES);
                    face1 = myDice1.roll(FACES);
                    total = face + face1;
                    rollcount += 1;
                    if (total == target)
                    {
                        pointW += 1;
                        won = 1;
                        if (rollcount > maxPointW)
                        {
                            maxPointW = rollcount;
                        } else if (rollcount < minPointW)
                        {
                            minPointW = rollcount;
                        }
                    }else if (total == OUT)
                    {
                        pointL += 1;
                    }
                }                                          
            }            
            loop -= 1;
        }
        System.out.println(loop);
        System.out.println(rollcount);        
        System.out.println(firstRollW);
        System.out.println(firstRollL);
        System.out.println(pointW);
        System.out.println(pointL);
        System.out.println(maxPointW);
        System.out.println(minPointW);
    }
}