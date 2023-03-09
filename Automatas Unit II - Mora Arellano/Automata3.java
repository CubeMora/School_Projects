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

public class Automata3 {
  private static final int Q0 = 0;
  
  
  public static void main(String[] args) {
    int[][] transition = {{Q0, Q0}};
    int currentState = Q0;
    
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter a string from the alphabet {a, b}: ");
    String input = scan.nextLine();
    
    for (int i = 0; i < input.length(); i++) {
      char symbol = input.charAt(i);
      if (symbol == 'a') {
        currentState = transition[currentState][0];
          
      } else if (symbol == 'b') {
        currentState = transition[currentState][0];
      } else {
        System.out.println("Invalid symbol: " + symbol);
        break;
      }
      System.out.println("Current state: " + currentState);
    }
    
    if (currentState == Q0) {
      System.out.println("Accept");
    } else {
      System.out.println("Reject");
    }
  }
}