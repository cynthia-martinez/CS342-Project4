import java.util.Scanner;

/**
 * Name: Cynthia Martinez, Nathan He
 * Username: cmartine, nhe, favila
 * NetID: cmarti65, nhe3, favila6
 */

public class ExamBuilder {
    private Exam test1;
    private String userInput;

    public ExamBuilder(){
        Scanner reader = new Scanner(System.in);

        System.out.println("Menu Options:");
        System.out.println("1. Create Exam");
        System.out.println("2. Remove Exam");
        System.out.println("3. Save Exam");

        userInput = reader.nextLine();

        if (userInput.equalsIgnoreCase("1")){
            //Create Exam
            System.out.println("Creating Exam...");
            System.out.println("Exam Name? ");

            //get user input for exam name
            userInput = reader.nextLine();

            //create exam with name
            test1 = new Exam(userInput);

            //add questions
            System.out.println("Options");
            System.out.println("1. Add MCSA Question");
            System.out.println("2. Add SA Question");

            userInput = reader.nextLine();

            if (userInput.equalsIgnoreCase("1")){
                //create question
            }

        }else if (userInput.equalsIgnoreCase("2")){
            //Remove Exam
            System.out.println("Removing Exam...");

            if (test1 == null){
                System.out.println("No saved exam to remove");
            }else{
                //actually remove the exam
            }

        }else{
            //Save Exam
            System.out.println("Saving Exam...");

        }

        reader.close();
    }



}
