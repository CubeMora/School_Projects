
/**
 *
 * @author CubeMora
 */
import java.util.Scanner;

public class Automata2 {
  private static final int Qp = 0;
  private static final int Q0 = 1;
  private static final int Q5 = 2;
  private static final int Q1 = 3;
  private static final int Q4 = 4;
  
  
  public static void main(String[] args) {
    int[][] transition = {{Q5, Q5, Q5}, {Q4, Q5, Q1}, {Q5, Q5, Q5}, {Q5, Q5, Qp}, {Q4, Qp, Q1}};
    int currentState = Q0;
    
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter a string from the alphabet {a, b, c}: ");
    String input = scan.nextLine();
    
    for (int i = 0; i < input.length(); i++) {
      char symbol = input.charAt(i);
      if (symbol == 'a') {
        currentState = transition[currentState][0];
      } else if (symbol == 'b') {
        currentState = transition[currentState][1];
      } else if (symbol == 'c') {
        currentState = transition[currentState][2];
      } else {
        System.out.println("Invalid symbol: " + symbol);
        break;
      }
	System.out.println("Current state: " + currentState);
    }
    
    if (currentState == Qp) {
      System.out.println("Accept");
    } else {
      System.out.println("Reject");
    }
  }
}
