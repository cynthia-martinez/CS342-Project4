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

public class Exam {
    private String examTitle;
    private ArrayList<Question> questionsList;

    //Exam( String ) – A constructor for creating the Exam object. New Exams do not have Questions until they are added. The input parameter is the title / header of the exam, to be printed before the questions. ( Note that the title / header may consist of multiple lines. )
    public Exam(String titleOfExam){
        this.examTitle = titleOfExam;
        this.questionsList = new ArrayList<Question>();
        return;
    }

//    //opens the file
//    public void openFile(String filename){
//        try{
//            x = new Scanner(new File(filename));
//        }catch(Exception e){
//            System.out.println("Can't find file");
//        }
//    }
//
//    //close the file
//    public void closeFile(){
//        x.close();
//    }

    //Exam contructor that takes in scanner keyboard as parameter
    public Exam(Scanner keyboard){
        //TODO:
        String line;

        //get file name to open it
        this.examTitle = keyboard.nextLine();
        System.out.println(examTitle);

        //keyboard.nextLine();
        //sampleExamData.txt

        //sampleExamData.txt
        while (keyboard.hasNext()){
            //grab next line
            line = keyboard.nextLine();

            if (line.equals("MCSAQuestion")){
                //System.out.println("third");

                //make MCSAQuestion with scanner constructor
                MCSAQuestion mcsaq = new MCSAQuestion(keyboard);

                //add question
//                questionsList.add(mcsaq);

            }else if (line.equals("MCMAQuestion")){
                //System.out.println("second");

                //make MCMAQuestion with scanner constructor
                MCMAQuestion mcmaq = new MCMAQuestion(keyboard);

                //add question
//                questionsList.add(mcmaq);

            }else if (line.equals("SAQuestion")){
                //sampleExamData.txt
                //System.out.println("third");

                //make SAQuestion with scanner constructor
                SAQuestion saq = new SAQuestion(keyboard);

                //System.out.println(saq.text);

                //add question
                //questionsList.add(saq);
            }else{
                //System.out.println("fourth");
            }

        }

        System.out.println("Done reading and closed file.");
    }

    //print( void ) : void – Prints the exam to the screen, along with all of its questions.
    public void print(){
        System.out.println(examTitle);
        System.out.println();

        //for each question in the exam print it
        for (int i = 0; i < questionsList.size(); i++){
            System.out.print((i + 1) + ". ");
            questionsList.get(i).print();
        }
        return;
    }

    //AddQuestion( Question ) – Add a Question to an Exam. By default new questions are added to the end of the existing list.
    public void addQuestion(Question question){
        questionsList.add(question);
        return;
    }

    //reorderQuestions( void ) : void – Randomly reorders the Questions within the Exam.
    public void reorderQuestions(){
        for (int i = 0; i < 4; i++){
            Collections.shuffle(questionsList);
        }
    }

    //reorderMCAnswers( position : int ) : void – For multiple choice questions only, this method reorders the answers of the question. If the position parameter is negative, then all MC questions get their answers reordered. Otherwise the position indicates which Question should have its answers reordered, provided that that Question is a MC type question.
    public void reorderMCAnswers(int pos){
        MCQuestion mcq;

        if (pos >= 0 && pos < questionsList.size() && questionsList.get(pos) instanceof MCQuestion){
            mcq = (MCQuestion)questionsList.get(pos);

            //mcq = reorderAnswers();

        }else if (pos < 0){
            for (int i = 0; i < questionsList.size(); i++){
                if (!(questionsList.get(i) instanceof  MCQuestion))
                    continue;
                mcq = (MCQuestion) questionsList.get(i);
                mcq.reorderAnswers();
            }
        }else{
            //position was positive, but out range or not a MC Question
            //really should throw an Exception here
        }
        return;
    }

    //getAnswerFromStudent( position : int ) : void – See previous explanation of “position”.
    public void getAnswerFromStudent(int pos){
        if (pos >= 0 && pos < questionsList.size()){
            questionsList.get(pos).getAnswerFromStudent();
        } else if (pos < 0) {
            for (int i = 0; i < questionsList.size(); i++){
                questionsList.get(i).getAnswerFromStudent();
            }
        }else {
            //position positive but out of range - throw Exception here
        }
    }

    //getValue( void ) : double – Get the overall value ( score ) of the exam. This method should work regardless of how many ( if any ) of the Questions have been answered.
    public double getValue(){
        double sum = 0;
        for (int i = 0; i < questionsList.size(); i++){
            sum += questionsList.get(i).getValue();
        }
        return sum;
    }

    //reportQuestionValues( ) : void – This method produces a table of the values of each Question on the Exam, and the total.
    public void reportQuestionValues() {
        System.out.println("\n  Question   |   Score");
        System.out.println("-----------------------");
        for (int i = 0; i < questionsList.size();i++){
            System.out.println("      " + (i+1) + "   |   " + questionsList.get(i).getValue());
        }
        System.out.println("-----------------------");
        System.out.println("    Total   |    " + getValue());
    }

    public void save(PrintWriter A){
        //TODO:
    }

    public void saveStudentAnswers(PrintWriter A){
        //TODO:
    }

    public void restoreStudentAnswers(PrintWriter A){
        //TODO:
    }


}