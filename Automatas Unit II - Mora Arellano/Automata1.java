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

public class Automata1 {
  private static final int Q0 = 0;
  private static final int Q1 = 1;
  private static final int Q2 = 2;
  private static final int Q3 = 3;
  private static final int Q4 = 4;
  private static final int Q5 = 5;
 
  
  
  public static void main(String[] args) {
    int[][] transition = {{Q1}, {Q1, Q2}, {Q2, Q3}, {Q4}, {Q4, Q5}};
    int currentState = Q0;
    
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter a string from the alphabet {0, 1}: ");
    String input = scan.nextLine();
    
    for (int i = 0; i < input.length(); i++) {
      char symbol = input.charAt(i);
      if (symbol == '0') {
        currentState = transition[currentState][0];
          
      }
      
      else if (symbol == '1') {
        currentState = transition[currentState][1];
      } else {
        System.out.println("Invalid symbol: " + symbol);
        break;
      }
      System.out.println("Current state: " + currentState);
    }
    
    if (currentState == Q5) {
      System.out.println("Accept");
    } else {
      System.out.println("Reject");
    }
  }
}
