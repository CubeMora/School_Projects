
/**
 *
 * @author CubeMora
 */
import java.util.Scanner;

public class Automata3 {
  private static final int Qp = 0;
  private static final int Qpp = 1;
  
  
  
  public static void main(String[] args) {
    int[][] transition = {{Qp, Qp, Qp}, {Qpp, Qp, Qp}};
    int currentState = Qp;
    
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
    
    if (currentState == Qpp) {
      System.out.println("Accept");
    } else {
      System.out.println("Reject");
    }
  }
}