package org.hibrtnate.hibernate.hooks;

import java.util.Scanner;

public class ScannerHook {
    public static Scanner scanner=ScannerInitalizer.getScanner();
    public static int getNumericScannerValue(String printvalue){
        System.out.print(printvalue+" ");
        return scanner.nextInt();
    }

    public static String getStringScannerValue(String printvalue){
        System.out.print(printvalue+" ");
        return scanner.next();
    }
}
