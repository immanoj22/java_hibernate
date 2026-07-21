package org.example.CommonHooks;

import java.util.Scanner;

public class InputHooks {
    public static Scanner getScanner(){
        return new Scanner(System.in);
    }

    public static int getInputValue(String message){
        System.out.print(message+" : ");
        return getScanner().nextInt();
    }

    public static String getStringValue(String message){
        System.out.print(message+" : ");
        return getScanner().nextLine();
    }
}
