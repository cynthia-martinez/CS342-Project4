//Name: Nathan He
//Netid: nhe3
//Date: 3/12/18
//Class: CS342
//HW #3

import java.util.Scanner;

public class ScannerFactory {
    private static Scanner keyboardScanner;

    //The only method, getKeyboardScanner( ), first looks to see if its private static variable is null, and if it is, the method calls new     to create a new Scanner connected to System.in. After that it returns the static variable, whether it was newly created or if it had been    created earlier.
    public static Scanner getKeyboardScanner(){
        if (keyboardScanner == null){
            keyboardScanner = new Scanner(System.in);
        }
        return keyboardScanner;
    };


}
