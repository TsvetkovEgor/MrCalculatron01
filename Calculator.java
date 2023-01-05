package MrCalculatron01;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scan = new Scanner (System.in);
        System.out.print("Введите выражение без пробелов: ");
        String n = scan.nextLine();
        Main.calc(n);
        }
    }





