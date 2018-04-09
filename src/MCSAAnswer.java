//Name: Nathan He
//Netid: nhe3
//Date: 4/8/18
//Class: CS342
//HW #4

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

//Multiple Choice Single Answer Answer
public class MCSAAnswer extends MCAnswer{

    //Constructor
    public MCSAAnswer(String text, double creditIfSelected){
        super(text, creditIfSelected);
        return;
    }

    public MCSAAnswer (Scanner keyboard){
        super("", 0.0);
    }

    //returns the right amount of credit for given answer
    public double getCredit(Answer rightAnswer){
        return super.getCredit(rightAnswer);
    }
}
