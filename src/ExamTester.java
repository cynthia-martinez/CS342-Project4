//Name: Nathan He
//Netid: nhe3
//Date: 4/8/18
//Class: CS342
//HW #4

import java.io.File;
import java.util.Scanner;

public class ExamTester {

    public static void printHeading(){
        System.out.println("Name: Nathan He");
        System.out.println("Netid: nhe3");
        System.out.println();
    }

    public static void main(String[] args) {
        //print student heading
        printHeading();

        String [] questionTexts = {"What?", "Where?", "When?", "Why?", "Who?"};
        String [] answerTexts = { "Whatever!", "Over There.", "Sometime", "Why Not?", "First Basemen"};

        //Create Sample Exam 1
        Exam exam1 = new Exam("Sample Exam 1 (Spring 2018)");
        MCSAQuestion q;
        MCAnswer a;

        //loops to create MCSAQuestions and Answers, then add to exam
        //Credit if selected is set to 1.0 when i == j, or 0.0 otherwise
        for (int i= 0; i < questionTexts.length; i++){
            //Assume each qeustion is worth 5 points
            q = new MCSAQuestion(questionTexts[i], 5.0);

            for (int j = 0; j < answerTexts.length; j++){
                a = (MCAnswer)q.getNewAnswer(answerTexts[j], i == j ? 1.0 : 0.0);
                q.addAnswer(a);

            }
            exam1.addQuestion(q);
        }

        //Now to add short answer questions to the exam, worth 5 points
        SAQuestion saq = new SAQuestion("What is the answer to life, the universe, and everything?", 5.0 );
        SAAnswer saa = (SAAnswer)saq.getNewAnswer( "Forty Two");
        saq.setRightAnswer(saa);
        exam1.addQuestion(saq);

        //print exam
        //exam1.print();

        //reorder the questions and the MC Answers
        exam1.reorderQuestions();
        exam1.reorderMCAnswers(-1);

        //Take the test
        //System.out.println();

        //System.out.println("Take the Test");
        //exam1.getAnswerFromStudent(-1);

        //----------------------------------------------------
        //sampleExamData.txt

        Scanner reader = new Scanner(System.in);

        //name of exam file
        System.out.print("Enter filename: ");
        String filename = reader.nextLine();

        Scanner x;
        try {
            x = new Scanner(new File(filename));

            Exam exam2 = new Exam(x);

        }catch(Exception e){
            System.out.println("Can't find file");
        }


        //exam1.reportQuestionValues();
        //System.out.println();


        return;
    }
}
