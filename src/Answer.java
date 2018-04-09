//Name: Nathan He
//Netid: nhe3
//Date: 4/8/18
//Class: CS342
//HW #4

import java.io.PrintWriter;
import java.util.Scanner;

//Abstract answer class
public abstract class Answer {
    protected Answer(){
        return;
    }

    public Answer(Scanner A){
        //TODO:
    }

    public abstract void print();

    protected abstract double getCredit(Answer rightAnswer);

    public void save(PrintWriter A){
        //TODO:
    }

}
