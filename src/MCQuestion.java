//Name: Nathan He
//Netid: nhe3
//Date: 4/8/18
//Class: CS342
//HW #4

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public abstract class MCQuestion extends Question{
    protected ArrayList<Answer> answers;

    //First constuctor
    protected MCQuestion(String text, double questionWorth){
        super(text, questionWorth);
        answers = new ArrayList<Answer>();
        return;
    }

    protected MCQuestion(Scanner A){
        super("", 0.0);
    }


    public void print() {
        super.print();

        for (int i = 0; i < answers.size(); i++){
            System.out.print("      " + (char)('A' + i) + ". ");
            answers.get(i).print();
        }
        return;
    }

    //Add an answer to the multiple choice single answer question
    public void addAnswer(MCAnswer answer) {
        this.answers.add(answer);
    }

    //reorderAnswers( void ) : void – Randomly reorders the Answers within the Question.
    public void reorderAnswers(){
        for (int i = 0; i < 4; i++){
            Collections.shuffle(answers);
        }
        return;
    }


    public double getValue(MCAnswer ans){
        //TODO:
        return 0;
    }

    public void save(PrintWriter A){
        //TODO:
    }

}
