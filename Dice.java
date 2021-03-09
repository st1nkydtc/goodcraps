/**
 * This Class creates a dice object that can be rolled to return a face value
 *
 * @author Sacha & LCH
 * @version 04/03/21
 */
public class Dice
{
    // instance variables - replace the example below with your own
    private final int FACES = 6;
    private int face;
    /**
     * Constructor for objects of class Dice
     */
    public Dice()
    {
        // initialise instance variables
        roll(FACES);
    }
    public int roll(int FACES)
    {
        // put your code here
        face = (int) ((Math.random() * FACES) +1);
        
        return (face);
    }
}
