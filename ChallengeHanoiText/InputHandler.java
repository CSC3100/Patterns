

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class handles user input through the terminal
 * It checks if the input is a number and returns the number
 * @author Brian Kwong
 * @author Colin McDonald
 * @version 1.0
 */

public class InputHandler {

  private final Scanner in = new Scanner(System.in);

  public int[] getUserMove(View view) {
    try {
      view.print("Please enter the peg you would like to move from: 1|2|3 or 0 for the computer's help");
      int fromPeg = in.nextInt();
      if(fromPeg == 0){
        return new int[] {0, 0}; // 0, 0 is asking for computer's help
      }
      view.print("Please enter the peg you would like to move to: 1|2|3");
      int toPeg = in.nextInt();
      return new int[] {fromPeg, toPeg};
    } catch (InputMismatchException e) {
      view.print("Input is not a number!");
      in.next();
      return null;
    }
  }

  public int getNumberOfDisks(View view) {
    while (true) {
      try {
        view.print("Please enter the number of disk you would like to play with: ");
        int numberOfDisks = in.nextInt();
        if (numberOfDisks < 0 || numberOfDisks > 9) {
          view.print("Disk number not available, please only enter a number between 1 and 9");
        } else {
          return numberOfDisks;
        }
      } catch (InputMismatchException e) {
        in.next();
        view.print("Invalid input, please only enter a number between 1 and 10");
      }
    }
  }
}
