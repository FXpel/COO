package donjon;

import donjon.room.Room;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * Test an Adventure game
 */
public class AdventureGameTest {
    /**
     * test if the room  from  getCurentRoom is the current room
     */
    @Test
    public void getCurrentRoom(){
        Room r = new Room("test");
        AdventureGame game = new AdventureGame(r);
        assertEquals(r,game.getCurrentRoom());
    }

    /**
     * Test if the current room is changed
     */

    @Test
    public void setCurrentRoom(){
        Room r = new Room("test");
        Room r2 = new Room("test2");
        AdventureGame game = new AdventureGame(r);
        game.setCurrentRoom(r2);
        assertEquals(r2,game.getCurrentRoom());
    }

    /**
     *
     * Test if the game is finished after setEnd
     */
    @Test
    public void setEnd() throws Exception {
        Room r = new Room("test");
        AdventureGame game = new AdventureGame(r);
        game.setEnd();
        assertEquals(game.isTheEnd(),true);
    }

    /**
     *
     * Test is the game is finished
     */

    @Test
    public void isTheEnd() throws Exception {
        Room r = new Room("test");
        AdventureGame game = new AdventureGame(r);
        assertEquals(game.isTheEnd(),false);
    }

}
