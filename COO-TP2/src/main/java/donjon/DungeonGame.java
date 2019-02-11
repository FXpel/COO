package donjon;

import donjon.UI.Interact;
import donjon.action.AttackAction;
import donjon.action.MoveAction;
import donjon.action.Use;
import donjon.characters.Player;
import donjon.room.Room;

/**
 * The main class of the project
 */
public class DungeonGame
{
    public static void main( String[] args )
    {
        Room start = new Room("Room");
        start.generateRoom();
        Interact i = new Interact();
        String name = i.namePlayer();
        Player player = new Player(100,50,0,name);
        player.BasicMove();
        AdventureGame game = new AdventureGame(start);
        player.addToGame(game);
        game.play(player);
    }
}
