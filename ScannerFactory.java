import java.util.Scanner;

/**
 * Name: Cynthia Martinez, Nathan He
 * Username: cmartine, nhe, favila
 * NetID: cmarti65, nhe3, favila6
 */

public class ScannerFactory {
    private static Scanner keyboardScanner;

    public static Scanner getKeyboardScanner(){
        if(keyboardScanner == null){
            keyboardScanner = new Scanner(System.in);
        }

        return keyboardScanner;

    }

}
