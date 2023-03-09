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

public class Automata7 {

    private static final int Q0 = 0;
    private static final int Q1 = 1;
    private static final int Q2 = 2;
    private static final int Q3 = 3;
    private static final int Q4 = 4;
    private static final int Q5 = 5;
    private static final int Q6 = 6;
    private static final int Q7 = 7;
    private static final int Q8 = 8;
    private static final int Q9 = 9;
    private static final int Q10 = 10;

    public static void main(String[] args) {
        int[][] transition = {{Q1, 0}, {Q2, 0}, {Q3, 0}, {0, Q4}, {0, Q5}, {Q6, 0}, {Q6, Q7}, {0, Q8}, {0, Q9}, {0, Q10}, {Q10, Q10}};
        int currentState = Q0;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a string from the alphabet {0, 1}: ");
        String input = scan.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol == 'a') {
                currentState = transition[currentState][0];

            } else if (symbol == 'b') {
                currentState = transition[currentState][1];
            } else if (symbol == ' ' && currentState == Q2) {
                currentState = Q1;
            } else if (symbol == ' ' && currentState == Q4) {
                currentState = Q3;
            }
            else if (symbol == ' ' && currentState == Q8) {
                currentState = Q0;
            }
            else {
                System.out.println("Invalid symbol: " + symbol);
                break;
            }
            System.out.println("Current state: " + currentState);
        }

        if (currentState == Q10) {
            System.out.println("Accept");
        } else {
            System.out.println("Reject");
        }
    }
}
