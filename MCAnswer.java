import java.io.PrintWriter;
import java.util.Scanner;
/**
 * NAME : Fernando Avila
 * NETID: favila6
 */
public abstract class MCAnswer extends Answer 
{
    protected String text;
    protected double creditifSelected;
    /**
     * Constructor for multiple choice answer
     *
     * @param t      the answer
     * @param credit credit if answer is selected
     */
    protected MCAnswer(String t, double credit) 
    {
        text = t;
        creditifSelected = credit;
    }

    /**
     * Should expect a file
     * 
     * @param sc the file
     */
    MCAnswer(Scanner sc)
    {
        try
        {
            while(sc.hasNextLine())
            {
                if(sc.hasNextDouble()) 
                {
                    creditifSelected = Double.parseDouble(sc.nextLine());
                }
                else
                {
                    creditifSelected = 0;
                }
                text = sc.nextLine();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Prints the answer to the screen
     */
    public void print() 
    {
        System.out.println(text);
    }

    /**
     * Compares student answer to the current answer
     *
     * @param compAns the answer to compare to
     * @return the credit the answer was given
     */
    public double getCredit(Answer compAns) 
    {
        // checks if answer passed in is a multiple choice answer
        if(compAns instanceof MCAnswer) 
        {
            MCAnswer ans = (MCAnswer)compAns;
            //checks if current answer is equal to student answer
            if(text.equals(ans.text)) 
            {
                return creditifSelected;    // returns credit earned for the answer
            }
        }
        return 0;
    }

    public void save(PrintWriter pr)
    {
        pr.println(this.creditifSelected + " " + this.text);
    }
}