import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class MCQuestion extends Question {

    protected ArrayList<MCAnswer> answers;  // list of answers

    /**
     * constructor for MCQuestion
     *
     * @param t      question
     * @param maxVal ax value of question
     */
    protected MCQuestion(String t, double maxVal) {
        super(t, maxVal);
        answers = new ArrayList<MCAnswer>(1);
    }

    protected MCQuestion(Scanner sc){
        super(sc);
        answers = new ArrayList<MCAnswer>(1);
    }


    /**
     * Prints the question along with its answers
     */
    public void print() {
        int len = 5;    //number of max answers to appear
        System.out.println(text);  // prints the question

        // iterates through answer arraylist and prints the answer
        for (int i = 0; i < len; i++) {
            switch (i + 1) {
                case 1:
                    System.out.print("\tA. ");
                    answers.get(i).print();
                    break;
                case 2:
                    System.out.print("\tB. ");
                    answers.get(i).print();
                    break;
                case 3:
                    System.out.print("\tC. ");
                    answers.get(i).print();
                    break;
                case 4:
                    System.out.print("\tD. ");
                    answers.get(i).print();
                    break;
                case 5:
                    System.out.print("\tE. ");
                    answers.get(i).print();
                    break;
                default:
                    System.out.println("Invalid Position.");
            }
        }
    }

    /**
     * Adds an answer to a Question
     * Answers are added to the end of a list
     *
     * @param a the answer to be added
     */
    public void addAnswer(MCAnswer a) {
        answers.add(a);
    }

    /**
     * Randomly reorders the answers within the question
     */
    public void reorderAnswers() {
        int len = answers.size() - 1; // number of elements in answers(0 based)
        int pos;    //  position of the answer to remove
        MCAnswer removed; // answer that was removed
        int i = 0;  // counter for the while loop

        /* iterates 3 time
           during each iteration:
           1. randomize position integer
           2. remove the answer from the random position
           3. add the removed answer to the back of the list
         */
        while (i < 3) {
            pos = (int) (Math.random() * (len + 1));
            removed = answers.remove(pos);
            answers.add(removed);
            i++;    // updates counter
        }

    }

    /**
     *  checks the student answer(passed in) against other answers. if a match return credit
     * @param ans the student answer
     * @return credit given for the question
     */
    public double getValue(MCAnswer ans) {

        for(Answer a : answers){
            if( ans.text.equals(((MCAnswer)a).text)){
                return ans.getCredit(a);
            }
        }

        return 0;
    }

    public void save(PrintWriter pr){
        pr.println(maxValue);
        pr.println(this.text);


    }

}
