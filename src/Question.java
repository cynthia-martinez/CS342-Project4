//Name: Nathan He
//Netid: nhe3
//Date: 3/12/18
//Class: CS342
//HW #3

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public abstract class Question {
    protected String text;
    protected Answer rightAnswer;
    protected Answer studentAnswer;
    protected double questionWorth;

    //abstract getNewAnswer function
    public abstract Answer getNewAnswer();

    //abstract AnswerFromStudent function
    public abstract void getAnswerFromStudent();

    //abstract getValue function
    public abstract double getValue();

    //First contructor
    protected Question(String userInput, double questionWorth){
        this.text = userInput;
        this.questionWorth = questionWorth;
        this.rightAnswer = null;
        this.studentAnswer = null;
        return;
    };

    public Question(Scanner A){
        //TODO:
    }


    public void print() {
        System.out.println(this.text);
        return;
    }

    public void setRightAnswer(Answer ans){
        this.rightAnswer = ans;
    }

    public void save(PrintWriter A){
        //TODO:
    }

    public void saveStudentAnswer(PrintWriter A){
        //TODO:
    }

    public void restoreStudentAnswers(PrintWriter A){
        //TODO:
    }

}
