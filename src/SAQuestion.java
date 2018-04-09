//Name: Nathan He
//Netid: nhe3
//Date: 3/12/18
//Class: CS342
//HW #3

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

//Short Answer Question
public class SAQuestion extends Question{

    public SAQuestion(String text, double a){
        super(text, a);
        return;
    }

    public SAQuestion(Scanner keyboard){
        super("", 0.0);
        //TODO:

        double questionWorth = Double.parseDouble(keyboard.nextLine());
        String saquestion = keyboard.nextLine();
        String saanswer = keyboard.nextLine();

        super.questionWorth = questionWorth;
        super.text = saquestion;
        super.rightAnswer = new SAAnswer(keyboard);

        System.out.println("Worth: " + super.questionWorth);
        System.out.println("Question: " + super.text);
        System.out.println("Answer: " );

        SAAnswer saa = new SAAnswer(keyboard);

        return;
    }

    //getNewAnswer
    public Answer getNewAnswer(){
        SAAnswer ans = new SAAnswer("");
        return ans;
    }

    //getNewAnswer
    public Answer getNewAnswer(String text){
        SAAnswer ans = new SAAnswer(text);
        return ans;
    }

    public void getAnswerFromStudent(){
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        print();

        studentAnswer = new SAAnswer(userInput);
        return;
    }

    public void print() {
        super.print();
        if (studentAnswer != null){
            System.out.print("      Student Answer = \"");
            studentAnswer.print();
            System.out.println("\"");
        }
        return;
    }

    public double getValue(){
        //return 0;
        return (studentAnswer == null) ? 0.0 : (questionWorth * studentAnswer.getCredit(rightAnswer));
    }

    public void save(PrintWriter A){
        //TODO:
    }

}
