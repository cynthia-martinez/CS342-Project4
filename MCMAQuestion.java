import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * NAME : Fernando Avila
 * NETID: favila6
 */
public class MCMAQuestion extends MCQuestion 
{
    protected ArrayList<Answer> studentAnswer;
    public double baseCredit;

    /**
     * Constructor for MCSA Question
     *
     * @param t      the question
     * @param maxVal credit for the question
     */
    public MCMAQuestion(String t, double maxVal, double baseCred) 
    {
        super(t, maxVal);
        baseCredit = baseCred;
        studentAnswer = new ArrayList<Answer>(1);
    }

    public MCMAQuestion(Scanner sc) 
    {
        super(sc);
        baseCredit = Double.parseDouble(sc.nextLine());
        studentAnswer = new ArrayList<Answer>(1);
        int numAns = Integer.parseInt(sc.nextLine()); // # of answers
        int count = 0;
        while(count < numAns)
        {
            String s = sc.nextLine();
            String num = s.substring(0,s.indexOf(" "));
            String t = s.substring(s.indexOf(" ")+1);
            double credit = Double.parseDouble(num);
            MCAnswer a = new MCSAAnswer(t,credit);

            this.addAnswer(a);

            count++;
        }
    }

    /**
     * Creates and returns a new Answer object with null values
     *
     * @return an Answer
     */
    public Answer getNewAnswer() 
    {
        MCMAAnswer ans = new MCMAAnswer(null, 0.0);
        return ans;
    }

    /**
     * Creates an Answer object with given text and credit
     *
     * @param t      answer text
     * @param credit credit for answer
     * @return an answer object
     */
    public Answer getNewAnswer(String t, double credit) 
    {
        MCMAAnswer ans = new MCMAAnswer(t, credit);
        return ans;
    }

    /**
     * Gets answer from student input
     */
    public void getAnswerFromStudent() 
    {
        // get user input for answer
        ScannerFactory in = new ScannerFactory();
        Scanner input = in.getKeyboardScanner();
        System.out.println("Please enter number of answers you will select: ");
        int numAns = Integer.parseInt(input.nextLine());
        int count = 0;
        while(count < numAns) 
        {
            System.out.println("Please enter your answer: ");
            String studAns = input.nextLine();

            // dependent on the answer will get appropriate answer for answer arraylist
            if(studAns.equalsIgnoreCase("A")) 
            {
                studentAnswer.add(answers.get(0));
            } 
            else if(studAns.equalsIgnoreCase("B")) 
            {
                studentAnswer.add(answers.get(1));
            } 
            else if(studAns.equalsIgnoreCase("C")) 
            {
                studentAnswer.add(answers.get(2));
            } 
            else if(studAns.equalsIgnoreCase("D")) 
            {
                studentAnswer.add(answers.get(3));
            } 
            else if(studAns.equalsIgnoreCase("E")) 
            {
                studentAnswer.add(answers.get(4));
            } 
            else 
            {
                System.out.println("Invalid Input");
            }

            count++;
        }
    }

    /**
     * Calculates the number of points a question contributes based on
     * answer selected
     *
     * @return value sum of points earned for a question + base credit
     */
    public double getValue() 
    {
        double sum = baseCredit;
        for(Answer a : studentAnswer) 
        {
            sum += super.getValue((MCAnswer) a);
        }
        return sum * maxValue;
    }

    public void restoreStudentAnswers(Scanner sc) 
    {
        int i = 0;
        if(sc.nextLine().equalsIgnoreCase("MCMAQuestion")) 
        {
            int numAns = Integer.parseInt(sc.nextLine());
            while(i < numAns) 
            {
                MCMAAnswer temp = new MCMAAnswer(sc.nextLine(), 0.00);
                studentAnswer.add(temp);
                i++;
            }
        }
    }

    public void save(PrintWriter pr) 
    {
        pr.println("MCMAQuestion");
        super.save(pr);
        pr.println(this.baseCredit);
        if(answers.size() <= 5) 
        {
            pr.println(answers.size());
        } 
        else 
        {
            pr.println("5");
        }
        
        for(Answer a : answers) 
        {
            a.save(pr);
        }
    }
}