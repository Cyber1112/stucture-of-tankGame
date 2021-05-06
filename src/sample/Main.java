package sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidMapException {
        Scanner input = new Scanner(System.in);
        String className = input.nextLine();
        if (className.equals("Position")) {
            Position p1 = new Position(input.nextInt(), input.nextInt());
            System.out.println(p1);
            p1.setX(5);
            p1.setY(2);
            System.out.println(p1.getX());
            Position p2 = new Position(5, 10);
            System.out.println(p1.equals(p2));
        } else if (className.equals("Map")) {
            try {
                Map map = new Map(input);
                map.print();
                int size = map.getSize();
                System.out.println(size);
                System.out.println(map.getValueAt(size, size));
            } catch (Exception var8) {
            }
        } else {
            MyPlayer player;
            if (className.equals("Player")) {
                player = new MyPlayer();
                System.out.println(Player.class.isInterface());
                System.out.println(player instanceof Player);
                System.out.println(player instanceof MyPlayer);
            } else if (className.equals("Exception")) {
                try {
                    throw new InvalidMapException("Some message");
                } catch (InvalidMapException var9) {
                    System.out.println(var9.getMessage());
                }
            } else if (className.equals("Game")) {
                player = new MyPlayer();
                Game game = new Game(new Map(input));
//                Game.addPlayer(player);
                String moves = input.next();

                for(int i = 0; i < moves.length(); ++i) {
                    char move = moves.charAt(i);
                    switch(move) {
                        case 'D':
                            player.moveDown();
                            break;
                        case 'L':
                            player.moveLeft();
                            break;
                        case 'R':
                            player.moveRight();
                            break;
                        case 'U':
                            player.moveUp();
                    }
                }

                Position playerPosition = player.getPosition();
                System.out.println("Player final position");
                System.out.println("Row: " + playerPosition.getY());
                System.out.println("Col: " + playerPosition.getX());
            }
        }

    }


}