package model;
import java.util.List;
import java.util.Queue;
import java.util.*;
public class Game {
    List<Snake> snakeList;
    List<Ladder> laddersList;
    Queue<Player> players;
    int snakeNumber;
    int ladderNumber;
    Board board;
    Dice dice;
    public Game(int minValue,int maxValue,int size,int snakeNumber,int ladderNumber){
        this.snakeList = new ArrayList<>();
        this.laddersList = new ArrayList<>();
        this.board = new Board(size,maxValue,minValue);
        this.snakeNumber = snakeNumber;
        this.ladderNumber = ladderNumber;
        this.players = new ArrayDeque<>();
        this.dice = new Dice(1,6,4);
        setSnakeAndLadderRandVlues(snakeNumber,ladderNumber,minValue,maxValue);
        System.out.println("Checking");
    }
    public void setSnakeAndLadderRandVlues(int snakeNumber,int ladderNumber,int minValue,int maxValue){
        for(int i=0;i<snakeNumber;i++){
            while(true){
                int snakeSt = (int)(Math.random()*(maxValue-minValue+1)+minValue);
                int snaked = (int)(Math.random()*(maxValue-minValue+1)+minValue);
                if(snaked<snakeSt){
                    Snake snake = new Snake(snakeSt,snaked);
                    this.snakeList.add(snake);
                    break;
                }
            }
        }
        for(int i=0;i<ladderNumber;i++){
            while(true){
                int ladderSt = (int)(Math.random()*(maxValue-minValue+1)+minValue);
                int laddered = (int)(Math.random()*(maxValue-minValue+1)+minValue);
                if(ladderSt<laddered){
                    Ladder ladder = new Ladder(ladderSt,laddered);
                    this.laddersList.add(ladder);
                    break;
                }
            }
        }
    }
    public void addPlayer(String name,int curr){
        players.add(new Player(name,curr));
    }
    public void startGame(){
        while(true){
        Player player = players.poll();
        int value = dice.roll();
        int newPos = player.currentPos + value;
        if(players.size()<2)
            break;
        if(newPos > board.endPoint){
            System.out.println("Game Won By: "+player.name);
        }
        else{
            int latestPost = getNewPos(newPos);
            if(latestPost>board.endPoint){
                System.out.println("Game Won By: "+player.name);
            }
            else{
                System.out.println("Step Taken by: "+player.name+" to: "+ latestPost);
                player.currentPos = latestPost;
                players.offer(player);
            }
        }
        if(players.size()<2)
            break;
        }
    }
    int getNewPos(int curr){
        for(int i=0;i<snakeList.size();i++){
            Snake snake = snakeList.get(i);
            if(snake.startPoint == curr){
                return snake.endPoint;
            }
        }
        for(int i=0;i<laddersList.size();i++){
            Ladder ladder = laddersList.get(i);
            if(ladder.startPoint==curr) {
                return ladder.endPoint;
            }
        }
        return curr;
    }
}
