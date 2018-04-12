import java.io.PrintWriter;
import java.util.Scanner;

public class NumQuestion extends Question {

    protected double tolerance;
    /**
     * Constructor for SAQuestion
     *
     * @param t   the question
     * @param max max credit given
     */
    NumQuestion(String t, double max, double tol) {
        super(t, max);
        label = "NumQuestion";
        tolerance = tol;
    }

    public NumQuestion(Scanner sc) {
        super(sc);
        label = "NumQuestion";
        rightAnswer = new NumAnswer(sc.nextDouble());
        tolerance = sc.nextDouble();
    }

    /**
     * creates and returns a new Answer object w/ null values
     *
     * @return an Answer
     */
    public Answer getNewAnswer() {
        NumAnswer ans = new NumAnswer(0);
        return ans;
    }


    /**
     * gets answer from student input
     */
    public void getAnswerFromStudent() {
        // get user input for answer
        ScannerFactory in = new ScannerFactory();
        Scanner input = in.getKeyboardScanner();
        System.out.println("Please enter your answer: ");
        Double studAns = input.nextDouble();

        // sets up student answer
        studentAnswer = new NumAnswer(studAns);
    }

    /**
     * calculates the number of points a question contributes based on
     * answer selected
     *
     * @return value sum of points earned for a question
     */
    public double getValue() {

        //  checks if answer gets credit
        if (studentAnswer.getCredit(rightAnswer) == 1.00) {
            return maxValue; // returns value if credit received
        }

        return 0;  // returns 0 if value not received

    }

    public void save(PrintWriter pr) {
        pr.println(this.label);
        pr.println(maxValue);
        pr.println(this.text);
        rightAnswer.save(pr);

    }

    public void restoreStudentAnswers(Scanner sc) {
        if (sc.nextLine().equalsIgnoreCase("NumAnswer")) {
            studentAnswer = new NumAnswer(sc.nextDouble());
        }
    }
}
