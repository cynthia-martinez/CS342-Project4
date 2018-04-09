import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Name: Cynthia Martinez
 * Username: cmartine
 * NetID: cmarti65
 */

public class Exam {
    private ArrayList<Question> questions;   // list of Questions
    private String text;   // title/header of the exam

    /**
     * Constructor for the Exam class
     * Instance variables are initialed to desired values
     */
    public Exam(String t) {
        text = t;
        questions = new ArrayList<Question>(); // Exam has no questions until added

    }

    public Exam(Scanner sc) {
        questions = new ArrayList<Question>();
        Question temp;
        String debug = " ";
        try {
            if (sc.hasNextLine()) {
                text = sc.nextLine();
                debug = sc.nextLine();
            }

            while (sc.hasNextLine()) {
                debug = sc.nextLine();

                if (debug.equalsIgnoreCase("SAQuestion")) {
                    temp = new SAQuestion(sc);
                    this.addQuestion(temp);
                } else if (debug.equalsIgnoreCase("MCSAQuestion")) {
                    temp = new MCSAQuestion(sc);
                    this.addQuestion(temp);
                } else if(debug.equalsIgnoreCase("MCMAQuestion")) {
                    temp = new MCMAQuestion(sc);
                    this.addQuestion(temp);
                }

                debug = sc.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds question to Exam; new questions added to the end of the list
     *
     * @param q the question to be added
     */
    public void addQuestion(Question q) {
        questions.add(q);
    }

    /**
     * Prints exam to the screen; including questions and answer
     */
    public void print() {
        System.out.println(text);
        int count = 1;

        // iterates through questions to print questions & corresponding answers
        for (Question q : questions) {
            System.out.print(count + ". ");
            q.print();
            count++;
        }
    }


    /**
     * Randomly reorders the questions within the exama
     */
    public void reorderQuestions() {
        int len = questions.size() - 1; // number of elements in ansArr(0 based)
        int pos;    //  position of the question to remove
        Question removed; // question that was removed
        int i = 0;  // counter for the while loop

        /* iterates 3 time
           during each iteration:
           1. randomize position integer
           2. remove the question from the random position
           3. add the removed question to the back of the list
         */
        while (i < 3) {
            pos = (int) (Math.random() * (len + 1));
            removed = questions.remove(pos);
            questions.add(removed);
            i++;    // updates counter
        }
    }

    /**
     * if position parameter, negative reorders all MCAnswers for MCQuestions
     * else, reorder MCAnswers if question at position parameter is an MCQuestion
     *
     * @param pos position of question
     */
    public void reorderMCAnswers(int pos) {
        if (pos < 0) {
            // iterates through all questions and reorders answers if multiple choice
            for (Question q : questions) {
                if (q instanceof MCQuestion) {
                    ((MCQuestion) q).reorderAnswers();
                }
            }
        } else {
            // reorders answers for specified question if its multiple choice
            if (questions.get(pos) instanceof MCQuestion) {
                ((MCQuestion) questions.get(pos)).reorderAnswers();
            }
        }
    }

    /**
     * Gets answer from student input. if position is negative, asks for all question. Else, asks for
     * that specific question
     *
     * @param pos position of the question
     */
    public void getAnswerFromStudent(int pos) {

        if (pos < 0) {
            // iterates through all questions and gets student answers
            int count = 1;
            for (Question q : questions) {
                System.out.print(count + ". ");
                q.getAnswerFromStudent();
                count++;
            }
        } else {
            // gets student answer from specified question
            System.out.print((pos + 1) + ". ");
            questions.get(pos).getAnswerFromStudent();
        }

    }

    /**
     * Gets the overall score of the exam
     *
     * @return overall score of the exam
     */
    public double getValue() {
        double sum = 0;

        // iterate through each answer and calculate value
        for (Question q : questions) {
            sum += q.getValue();
        }

        return sum;

    }


    /**
     * produces a table of values each question contributes on the exam
     */
    public void reportQuestionValues() {
        int count = 1; //keeps track of questions

        System.out.println("\tSCORE TABLE:");

        //gets value for each question
        for (Question q : questions) {
            System.out.println("Question " + count + ":\t\t" + q.getValue());
            count++;
        }

        System.out.println("Overall Score:\t\t" + getValue());
    }

    public void save(PrintWriter pr) {

        pr.println(text);
        for (Question q : questions) {
            pr.println("\n");
            q.save(pr);
        }

    }

    public void saveStudentAnswers(PrintWriter pr) {
        for (Question q : questions) {
            q.saveStudentAnswer(pr);
        }

    }

    public void restoreStudentAnswers(Scanner sc) {
        try {
            sc.nextLine();
            sc.nextLine();

            for (Question q : questions) {
                q.restoreStudentAnswers(sc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
