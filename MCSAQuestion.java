import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MCSAQuestion extends MCQuestion {

    /**
     * Constructor for MCSA Question
     *
     * @param t      the question
     * @param maxVal credit for the question
     */
    public MCSAQuestion(String t, double maxVal) {
        super(t, maxVal);



    }

    public MCSAQuestion(Scanner sc) {
        super(sc);
        int numAns = Integer.parseInt(sc.nextLine()); // # of answers
        int count = 0;
        while( count < numAns ){
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
     * creates and returns a new Answer object w/ null values
     *
     * @return an Answer
     */
    public Answer getNewAnswer() {
        MCSAAnswer ans = new MCSAAnswer(null, 0.0);
        return ans;
    }

    /**
     * creates an Answer object with given text and credit
     *
     * @param t      answer text
     * @param credit credit for answer
     * @return an answer object
     */
    public Answer getNewAnswer(String t, double credit) {
        MCSAAnswer ans = new MCSAAnswer(t, credit);
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

        // dependent on the answer will get appropriate answer for answer arraylist
        if (studAns.equalsIgnoreCase("A")) {
            studentAnswer = answers.get(0);
        } else if (studAns.equalsIgnoreCase("B")) {
            studentAnswer = answers.get(1);
        } else if (studAns.equalsIgnoreCase("C")) {
            studentAnswer = answers.get(2);
        } else if (studAns.equalsIgnoreCase("D")) {
            studentAnswer = answers.get(3);
        } else if (studAns.equalsIgnoreCase("E")) {
            studentAnswer = answers.get(4);
        } else {
            studentAnswer = null;
            System.out.println("Invalid Input");
        }

    }

    /**
     * calculates the number of points a question contributes based on
     * answer selected
     *
     * @return value sum of points earned for a question
     */
    public double getValue() {

        return (super.getValue((MCAnswer) studentAnswer) * maxValue);

    }

    public void restoreStudentAnswers(Scanner sc) {

        if (sc.nextLine().equalsIgnoreCase("MCSAQuestion")) {
            studentAnswer = new MCSAAnswer(sc.nextLine(), 0.00);
        }


    }

    public void save(PrintWriter pr) {
        pr.println("MCSAQuestion");
        super.save(pr);

        if (answers.size() <= 5) {
            pr.println(answers.size());
        } else {
            pr.println("5");
        }

        for (Answer a : answers) {
            a.save(pr);
        }
    }
}
