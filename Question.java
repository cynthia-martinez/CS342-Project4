import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Name: Cynthia Martinez
 * Username: cmartine
 * NetID: cmarti65
 */

public abstract class Question {
    protected String text; // string holding the question
    protected Answer rightAnswer;
    protected Answer studentAnswer;
    protected double maxValue;

    /**
     * Constructor for Question class
     *
     * @param t      the question
     * @param maxVal maximum credit for a question
     */
    protected Question(String t, double maxVal) {
        text = t;
        maxValue = maxVal;
        rightAnswer = null;
        studentAnswer = null;
    }

    public Question(Scanner sc) {
        try {
            maxValue = Double.parseDouble(sc.nextLine());
        }
        catch(NumberFormatException e){
            e.printStackTrace();
        }
        text = sc.nextLine();
        rightAnswer = null;
        studentAnswer = null;

    }

    /**
     * prints the question to the screen
     */
    public void print() {
        System.out.println(text);
    }

    /**
     * Sets the right answer
     *
     * @param ans the right answer
     */
    public void setRightAnswer(Answer ans) {
        rightAnswer = ans;
    }

    public abstract Answer getNewAnswer(); //returns new Answer object

    public abstract void getAnswerFromStudent(); //gets answer from student

    public abstract double getValue(); // gets number of points question contributes

    public abstract void save(PrintWriter pr);

    public void saveStudentAnswer(PrintWriter pr) {
        studentAnswer.save(pr);
    }

    public abstract void restoreStudentAnswers(Scanner sc);


}
