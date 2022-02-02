import model.Game;
import model.Player;

public class Main {
    static public void main(String args[]){
        Game game = new Game(1,100,100,5,5);
        game.addPlayer("Akhil",1);
        game.addPlayer("Heeru",1);
        game.addPlayer("Gabbu",1);
        game.addPlayer("Hitesha",1);
        game.addPlayer("Golu Molu",1);
        game.startGame();

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter board Size");
//        int boardSize = scanner.nextInt();
//        System.out.println("Enter number of players");
//        int numberOfPlayers = scanner.nextInt();
//        System.out.println("Enter number of snakes");
//        int numSnakes = scanner.nextInt();
//        System.out.println("Enter number of ladders");
//        int numLadders = scanner.nextInt();
//
//        Game game = new Game(numLadders, numSnakes, boardSize);
//        for (int i = 0; i < numberOfPlayers; i++) {
//            System.out.println("Enter player name");
//            String pName = scanner.next();
//            Player player = new Player(pName);
//            game.addPlayer(player);
//        }
    }
}
