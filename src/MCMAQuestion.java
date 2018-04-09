//Name: Nathan He
//Netid: nhe3
//Date: 4/8/18
//Class: CS342
//HW #4

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//Multiple Choice with Single Answer class
public class MCMAQuestion extends MCQuestion{
    //protected studentAnswer arrayList

    //public double baseCredit
    public double baseCredit;

    //Second constructor for MCSA Question (takes in only string text)
    public MCMAQuestion(String text, double questionworth, double baseCredit){
        super(text, questionworth);
        this.baseCredit = baseCredit;
        return;
    }

    public MCMAQuestion(Scanner A){
        super("",0.0);
        //TODO:
    }

    //getNewAnswer ( ) : Answer – This method creates and returns a new Answer object, suitably matched to the Question type of the object through which this method is called. Note that it is abstract in the Question class, and overridden in concrete classes to return the appropriate kind of Answer. ( SAQuestion.getNewAnswer( ) returns a new SAAnswer, etc. ) This mechanism is an example of the Factory Method design pattern.
    public Answer getNewAnswer(){
        MCSAAnswer ans = new MCSAAnswer("", 0.0);
        return ans;
    }

    //getNewAnswer 2
    public MCSAAnswer getNewAnswer(String text, double creditifselected){
        MCSAAnswer ans = new MCSAAnswer(text, creditifselected );
        return ans;
    }

    //getNewAnswerFromStudent( ) : void – This also creates a new Answer of the appropriate type, similar to getNewAnswer. The differences are that this method gets the answer from the student/ keyboard, and the answer is stored in the studentAnswer field of the class instead of being returned.
    public void getAnswerFromStudent(){
        print();

        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        char c = Character.toUpperCase(userInput.charAt(0));
        int choice = c - 'A';

        if (choice < 0 || choice >= answers.size()){
            return;
        }

        studentAnswer = answers.get(choice);

        for (int i = 0; i < answers.size(); i++){
            //answers.get(i).setSelected(false);
        }
        //answers.get(choice).setSelected(true);
    }

    //getValue( void ) : double – Get the number of points that this question contributes to the exam score, based on the maxValue of the question and evaluation of the current student answer. ( Answer classes have a getCredit( ) method which return a value from 0.0 to 1.0 )
    public double getValue(){
        double sum = 0;
        for (int i = 0; i < answers.size(); i++){
            //sum += answers.get(i).getCredit(null);
        }
        return Math.min(1.0, sum) * questionWorth;
    }

    public void save(PrintWriter A){
        //TODO:
    }

    public void saveStudentAnswer(PrintWriter A){
        //TODO:
    }

    public void restoreStudentAnswer(PrintWriter A){
        //TODO:
    }
}
