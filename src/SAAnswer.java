//Name: Nathan He
//Netid: nhe3
//Date: 3/12/18
//Class: CS342
//HW #3

import java.io.PrintWriter;
import java.util.Scanner;

//Short Answer Answer
public class SAAnswer extends Answer{
    protected String text;

//    public SAAnswer(){
//        super();
//        return;
//    }

    public SAAnswer(String text){
        super();
        this.text = text;
        return;
    }

    public SAAnswer(Scanner keyboard){
        //TODO:
        super();

        String saanswer = keyboard.nextLine();
        this.text = saanswer;

        return;
    }


    //prints short answer
    //@Override
    public void print() {
        System.out.println(text);
        return;
    }

    //gets credit of the answer
    //@Override
    protected double getCredit(Answer rightAnswer){
        if (rightAnswer instanceof SAAnswer) {
            return (text.equalsIgnoreCase( ( (SAAnswer) rightAnswer).text)) ? 1.0 : 0.0;
        }else{
            return 0.0;
        }
    }

    public void save(PrintWriter A){
        //TODO:
    }


}
