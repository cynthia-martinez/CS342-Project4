import java.io.PrintWriter;
import java.util.Scanner;

public class SAQuestion extends Question {

    /**
     * Constructor for SAQuestion
     *
     * @param t   the question
     * @param max max credit given
     */
    SAQuestion(String t, double max) {
        super(t, max);
    }

    public SAQuestion(Scanner sc) {
        super(sc);

        rightAnswer = new SAAnswer(sc.nextLine());

    }

    /**
     * creates and returns a new Answer object w/ null values
     *
     * @return an Answer
     */
    public Answer getNewAnswer() {
        SAAnswer ans = new SAAnswer(" ");
        return ans;
    }

    /**
     * creates a new Answer object w/ given text and credit of 0.0
     *
     * @param t answer text
     * @return an Answer
     */
    public Answer getNewAnswer(String t) {
        SAAnswer ans = new SAAnswer(t);
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
        String studAns = input.nextLine();

        // sets up student answer
        studentAnswer = getNewAnswer(studAns);
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
        pr.println("SAQuestion");
        pr.println(maxValue);
        pr.println(this.text);
        rightAnswer.save(pr);

    }

    public void restoreStudentAnswers(Scanner sc) {
        if (sc.nextLine().equalsIgnoreCase("SAAnswer")) {
            studentAnswer = new SAAnswer(sc.nextLine());
        }
    }
}
