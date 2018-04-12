import java.util.Scanner;
/**
 * NAME : Fernando Avila
 * NETID: favila6
 */
public class ScannerFactory
{
    private static Scanner keyboardScanner;
    
    public static Scanner getKeyboardScanner()
    {
        if(keyboardScanner == null)
        {
            keyboardScanner = new Scanner(System.in);
        }
        return keyboardScanner;
    }
}