

public class Main {
    public static void main(String[] args) {

        // Example program of printing the towers
        int numberOfDisks;
        View view = new View();
        InputHandler inputHandler = new InputHandler();
        Node start;
        Node next;
        int count = 0;
        double optimalMoves = 0;
        int[] userMoves = null;

        numberOfDisks = inputHandler.getNumberOfDisks(view);


        GameLogic gameLogic = new GameLogic();
        GameState gameState = new GameState(numberOfDisks);
        boolean hasWon = false;
        view.drawBoard(gameState.currentState.left(),
                gameState.currentState.middle(),
                gameState.currentState.right(), numberOfDisks);
        while (!hasWon) {
            while (true) {
                userMoves = inputHandler.getUserMove(view);
                if (userMoves == null) {
                    continue;
                }
                else if(userMoves[0] == 0 && userMoves[1] == 0){
                    next = gameState.getComputerMove(numberOfDisks);
                }
                else{
                    next = gameLogic.convertStringToNodeMove(gameState.currentState, userMoves[0], userMoves[1]);
                }
                if (gameLogic.checkIfValidMove(gameState.gameGraph, gameState.currentState, next)) {
                    start = next;
                    hasWon = GameLogic.hasWon(start, numberOfDisks);
                    count++;
                    break;
                } else {
                    view.print("Invalid move, please try again");
                }
            }
            gameState.updateCurrentState(start);
            view.drawBoard(start.left(), start.middle(), start.right(), numberOfDisks);
        }
        optimalMoves = Math.pow(2, numberOfDisks) - 1;
        view.print(
                "Congratulations, you have completed the game in "
                        + count
                        + " moves which is "
                        + (count - optimalMoves)
                        + " moves away from the optimal solution");
    }
}
