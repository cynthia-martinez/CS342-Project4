import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Name: Cynthia Martinez, Nathan He
 * Username: cmartine, nhe, favila
 * NetID: cmarti65, nhe3, favila6
 */

public abstract class Answer {

    protected Answer() {
    }

    protected Answer( Scanner sc ){

    }
    public abstract void print();   //prints the Answer

    public abstract double getCredit(Answer compAnswer);  //determines credit given for an answer

    public abstract void save(PrintWriter pr);



}
