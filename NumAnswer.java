import java.io.PrintWriter;
import java.util.Scanner;

public class NumAnswer extends Answer{
    double num;
    /**
     * Constructor for SAAnswer
     *
     * @param n the number answer
     */
    public NumAnswer(double n) {
        label = "NumAnswer";
        num = n;
    }

    NumAnswer(Scanner sc) {
        label = "NumAnswer";
        num = sc.nextDouble();
    }

    /**
     * Prints out the answer
     */
    public void print() {
        System.out.println(num);
    }

    /**
     * compares current answer to the correct answer.Not case-sensitive
     *
     * @param rightAns the correct answer
     * @return 1.00 for full credit, 0.00 for no credit, Anything in between is partial credit
     */
    public double getCredit(Answer rightAns) {

        // checks if answer passed in is a multiple choice answer
        if (rightAns instanceof NumAnswer) {
            NumAnswer ans = (NumAnswer) rightAns;
            //checks if answer matches right answer (ignoring case)
            if (num == ans.num) {
                return 1.00;
            }
        }
        return 0;


    }

    public void save(PrintWriter pr) {
        pr.println(this.label);
        pr.println(this.num);

    }
}
