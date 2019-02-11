package donjon.characters;

import donjon.AdventureGame;
import donjon.action.Action;
import donjon.action.AttackAction;
import donjon.action.MoveAction;
import donjon.item.Purse;
import donjon.room.Room;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for player
 *
 * @author Adeniss Karti François-Xavier Pelage
 */
public class PlayerTest {

    /**
     * Test the constructor of the player
     */
    @Test
    public void constTest(){
        Player p = new Player(0,0,0,"Erwan");
        assertNotNull(p);
    }

    /**
     * Test the adding of an action
     */
    @Test
    public void addAction(){
        Player p1= new Player(20,6,60,"adeniso");
        Action a1 = new AttackAction();
        assertEquals(p1.getAction("Attack"),null);
        p1.addAction(a1);
        assertEquals(p1.getAction("Attack"),a1);

    }

    /**
     * Test the get method for the number of visited room
     */
    @Test
    public void getNbSalleVisite(){
        Player p1= new Player(20,6,60,"adeniso");
        assertEquals(p1.getNbSalleVisite(),0);
    }

    /**
     * Test the get method for player's action
     */
    @Test
    public void getAction(){
        Player p1= new Player(20,6,60,"adeniso");
        Action a1 = new AttackAction();
        Action a2 = new MoveAction();

        p1.addAction(a1);
        p1.addAction(a2);

        assertEquals(p1.getAction("Attack"),a1);
        assertEquals(p1.getAction("Move"),a2);


    }


/*

    /**
     * Test the get method for the possibles action
     */
    /*
    @Test
    public void possibleActions(){
        Player p1= new Player(20,6,60,"adeniso");
        Monster m1 = new Monster(5,2,3,"shitty mob");
        AttackAction a1 = new AttackAction();
        MoveAction a2 = new MoveAction();
        Room r1 =new Room("room");
        r1.addMonster(m1);
        r1.generateNeigthboors();
        p1.addAction(a1);
        p1.addAction(a2);
        AdventureGame ad1 =new AdventureGame(r1);
        p1.addToGame(ad1);
        assertEquals(p1.possibleActions().size(),2);
    }
     */



    /**
     * Test the method for the death of the player
     */
    @Test
    public void die(){
        Room r = new Room("Test");
        AdventureGame game = new AdventureGame(r);
        Player p = new Player(0,0,100,"Jackie");
        p.addToGame(game);
        assertFalse(p.getGame().getCurrentRoom().hasItems());
        p.die(r);
        assertTrue(p.getGame().getCurrentRoom().hasItems());
        assertEquals(p.getGame().getCurrentRoom().getItems().size(),1);
        assertTrue(p.getGame().getCurrentRoom().getItems().get(0) instanceof Purse);
    }




    /*@Test



    /**
     * Test the method for the actions of the player
     */

    /* @Test
    public void act() {
    	Room r = new Room("Test");
    	r.generateRoom();
        AdventureGame game = new AdventureGame(r);
    	Player p = new Player(0,0,100,"Jackie");
    	r.generateItems();
    	r.generateMonsters();
    	p.addToGame(game);
    	p.BasicMove();
    	p.act();
    }
*/

    }
