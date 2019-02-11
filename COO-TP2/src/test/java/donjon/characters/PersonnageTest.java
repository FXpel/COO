package donjon.characters;

import donjon.AdventureGame;
import donjon.room.Room;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for the character
 *
 * @author Adeniss Karti François-Xavier Pelage
 */
public class PersonnageTest {

    /**
     * Test the get name method for the character
     */
    @Test
    public void getNameTest(){
        int force = 5;
        int pv=15;
        int po=0;
        String name="truc";
        Personnage monMien=new Player(pv,force,po,name);
        assertEquals(monMien.getName(),"truc");
    }

    /**
     * Test the get life point method
     */
    @Test
    public void getPvTest(){
        int force = 5;
        int pv=15;
        int po=0;
        String name="truc";
        Personnage monMien=new Player(pv,force,po,name);

        assertEquals(monMien.getPv(),15);
    }

    /**
     * Test the get strength method for the character
     */
    @Test
    public void getForceTest(){
        int force = 5;
        int pv=15;
        int po=0;
        String name="truc";
        Personnage monMien=new Player(pv,force,po,name);

        assertEquals(monMien.getForce(),5);

    }

    /**
     * Test the get golds method
     */
    @Test
    public void getPoTest() throws Exception {
        int force = 5;
        int pv=15;
        int po=0;
        String name="truc";
        Personnage monMien=new Player(pv,force,po,name);

        assertEquals(monMien.getPo(),0);
    }

    /**
     * Test the get game method for the character
     */
    @Test
    public void getGameTest() throws Exception {
        int force = 5;
        int pv=15;
        int po=0;
        String name="truc";
        Personnage monMien=new Player(pv,force,po,name);
        Room r = new Room("TestRoom");
        AdventureGame game = new AdventureGame(r);
        monMien.addToGame(game);
        assertEquals(game,monMien.getGame());

    }

    /**
     * Test the set method for the character
     */
    @Test
    public void addToGameTest(){
        int force = 5;
        int pv=15;
        int po=0;
        String name="truc";
        Player monMien=new Player(pv,force,po,name);

        Room start =new Room("start");

        AdventureGame celle_ci = new AdventureGame(start);

        monMien.addToGame(celle_ci);

        assertEquals(monMien.getGame(),celle_ci);


    }

    /**
     * Test the change life points method
     */
    @Test
    public void changePvTest(){
        int force = 5;
        int pv=15;
        int po=0;
        String name="truc";
        Personnage monMien=new Player(pv,force,po,name);

       monMien.changePv(5);
        assertEquals(monMien.getPv(),20);
        monMien.changePv(-10);
        assertEquals(monMien.getPv(),10);

    }

    /**
     * Test the change strength points method
     */
    @Test
    public void changeForceTest(){
        int force = 5;
        int pv=15;
        int po=0;
        String name="truc";
        Personnage monMien=new Player(pv,force,po,name);

        monMien.changeForce(5);
        assertEquals(monMien.getForce(),10);
        monMien.changeForce(-10);
        assertEquals(monMien.getForce(),0);

    }

    /**
     * Test the method to change the golds of a character
     */
    @Test
    public void changePoTest(){
        int force = 5;
        int pv=15;
        int po=0;
        String name="truc";
        Personnage monMien=new Player(pv,force,po,name);

        monMien.changePo(100);
        assertEquals(monMien.getPo(),100);
        monMien.changePo(-10);
        assertEquals(monMien.getPo(),90);
    }

    /**
     * Test the method to know if he is alive or not
     */
    @Test
    public void isDead(){
        int force = 5;
        int pv=15;
        int po=0;
        String name="truc";
        Personnage monMien=new Player(pv,force,po,name);
        assertFalse(monMien.isDead());
        monMien.changePv(-15);
        assertTrue(monMien.isDead());
        monMien.changePv(-30);
        assertTrue(monMien.isDead());
    }
}
