package org.hibrtnate.hibernate.hooks;

import java.util.Scanner;

public class ScannerInitalizer {
    public static Scanner getScanner(){
        return new Scanner(System.in);
    }
}
