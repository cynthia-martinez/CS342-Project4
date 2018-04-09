import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

/**
 * Name: Cynthia Martinez
 * Username: cmartine
 * NetID: cmarti65
 */

public class ExamTester {
    public static void main(String[] args) {

        System.out.println("Name: Cynthia\nNetID: cmarti65\n");

        File fRead = new File("exam.txt");
        File fWrite = new File("reorderedExam.txt");
        File fAns = new File("studAns.txt");

        try {
            Scanner sc = new Scanner(fRead);
            PrintWriter pr = new PrintWriter(fWrite);

            Exam test = new Exam(sc);
            test.print();

            sc.close();

            test.reorderQuestions();

            System.out.println("----------------------------------");
            System.out.println("REORDERED AND SAVED TO EXTERNAL FILE");
            System.out.println("----------------------------------");

            test.print();

            test.save(pr);
            pr.flush();


            System.out.println("----------------------------------");
            System.out.println("STUDENT ANSWERS");
            System.out.println("----------------------------------");

            test.getAnswerFromStudent(-1);

//            pr = new PrintWriter(fAns);
//            test.saveStudentAnswers(pr);
//            pr.flush();
           pr.close();

            test.reportQuestionValues();

            sc.close();


        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
