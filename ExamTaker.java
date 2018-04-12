import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Date;
import java.util.Scanner;

/**
 * Name: Cynthia Martinez, Nathan He, Fernando Avila
 * Username: cmartine
 * NetID: cmarti65, nhe3, favila6
 */

public class ExamTaker {
    public static void main(String[] args) {


        System.out.println("Name: Cynthia\nNetID: cmarti65\n");
        System.out.println("Name: Fernando\nNetID: favila6\n");
        System.out.println("Name: Nathan\nNetID: nhe3\n");

        File fRead = new File("exam.txt");
        File fAns = new File("studAns.txt");

        try {
            Scanner sc = new Scanner(fRead);
            Scanner in = new Scanner(System.in);
            PrintWriter pr = new PrintWriter(fAns);

            Exam test = new Exam(sc);
            test.print();

            System.out.println("----------------------------------");
            System.out.println("STUDENT ANSWERS");
            System.out.println("----------------------------------");
            System.out.println("What is your name?");
            String student = in.nextLine();

            test.getAnswerFromStudent(-1);
            int pos = 0;
            while(true) {
                System.out.println("Would you like to go back ot redo an answer? Y for yes N fo N.");

                String redo = in.nextLine();

                if (redo.equalsIgnoreCase("Y")) {
                    System.out.println("Which question would you like to go back to?");
                    pos = in.nextInt();
                    test.getAnswerFromStudent(pos-1);
                }
                else{
                    break;
                }
            }


            Date date=java.util.Calendar.getInstance().getTime();

            pr.println(student);
            pr.println(date);
            test.saveStudentAnswers(pr);
            pr.flush();
            pr.close();

            test.reportQuestionValues();

            sc.close();


        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
