//Name: Nathan He
//Netid: nhe3
//Date: 4/8/18
//Class: CS342
//HW #4

import javafx.print.Printer;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

//Multiple Choice Answer
public class MCAnswer extends Answer{
    protected String text;
    protected Boolean selected;
    protected double creditIfSelected;

    //First Constructor
    protected MCAnswer(String text, double creditIfSelected){
        this.text = text;
        this.creditIfSelected = creditIfSelected;
        this.selected = false;
        return;
    }

    public MCAnswer(Scanner A){
        //TODO:
    }

    public void print(){
        if (selected){
            System.out.print("* ");
        }
        System.out.println(text);
        return;
    }

    //setSelected( Boolean ) : void – An answer is selected ( true ) when a student has selected this answer. It becomes unselected ( false ) if the student changes their mind or selects another answer when only one answer is allowed.
    public void setSelected(Boolean selected){
        this.selected = selected;
        return;
    }

    public double getCredit(Answer answer){
        //TODO:
        return selected ? creditIfSelected : 0.0;
    }

    public void save(PrintWriter A){
        //TODO:
    }

}
