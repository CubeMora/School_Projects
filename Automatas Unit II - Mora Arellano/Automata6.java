/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Automatas;

/**
 *
 * @author CubeMora
 */
import java.util.Scanner;

public class Automata6 {

    private static final int Q0 = 0;
    private static final int Q1 = 1;
    private static final int Q2 = 2;
    private static final int Q3 = 3;
    private static final int Q4 = 4;
    private static final int Q5 = 5;
    private static final int Qf = 6;

    public static void main(String[] args) {
        int[][] transition = {{Q1}, {Q2}, {Q3}, {Q4}, {Q5}, {Qf}};
        int currentState = Q0;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a string from the alphabet {0, 1}: ");
        String input = scan.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol == 'a') {
                currentState = transition[currentState][0];

            } else if (symbol == 'b') {
                currentState = transition[currentState][0];
            } else if (symbol == ' ' && currentState == Q2) {
                currentState = Q0;
            } else if (symbol == ' ' && currentState == Q4) {
                currentState = Q2;
            } else {
                System.out.println("Invalid symbol: " + symbol);
                break;
            }
            System.out.println("Current state: " + currentState);
        }

        if (currentState == Qf) {
            System.out.println("Accept");
        } else {
            System.out.println("Reject");
        }
    }
}
