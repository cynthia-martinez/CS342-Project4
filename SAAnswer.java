import java.io.PrintWriter;
import java.util.Scanner;

public class SAAnswer extends Answer {
    protected String text;

    /**
     * Constructor for SAAnswer
     *
     * @param t the question
     */
    public SAAnswer(String t) {
        text = t;
    }

    SAAnswer(Scanner sc) {


        text = sc.nextLine();

    }

    /**
     * Prints out the answer
     */
    public void print() {
        System.out.println(text);
    }

    /**
     * compares current answer to the correct answer.Not case-sensitive
     *
     * @param rightAns the correct answer
     * @return 1.00 for full credit, 0.00 for no credit, Anything in between is partial credit
     */
    public double getCredit(Answer rightAns) {

        // checks if answer passed in is a multiple choice answer
        if (rightAns instanceof SAAnswer) {
            SAAnswer ans = (SAAnswer) rightAns;
            //checks if answer matches right answer (ignoring case)
            if (text.equalsIgnoreCase(ans.text)) {
                return 1.00;
            }
        }
        return 0;


    }

    public void save(PrintWriter pr) {

        pr.println(this.text);

    }

}
