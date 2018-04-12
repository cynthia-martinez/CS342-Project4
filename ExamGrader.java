import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.Collections;
/**
 * Used by an instructor to evaluate students' answers and determine scores.
 * 
 * NAME : Fernando Avila
 * NETID: favila6
 */
public class ExamGrader
{
    public static void main(String args[]) throws Exception
    {
        System.out.println("NAME : Fernando Avila");
        System.out.println("NETID: favila6");
        
        //LOAD an examFile + Answer file, make sure they match
        File examFile = new File("");
        Scanner sc = new Scanner(examFile);

        while(sc.hasNextLine())
        {
            System.out.println(sc.nextLine());
        }
        //If(answerFile as CMD-LN ARG)
          //LOAD matching examFile

        //Evaluate answersList

        //print RESULTS to screen
        
        //Store results to CSV file
        Scanner scanner = new Scanner(new File("studAns.csv"));
        scanner.useDelimiter(" ");
        while(scanner.hasNext()){
            System.out.print(scanner.next()+",");
        }
        scanner.close();   
    }
}