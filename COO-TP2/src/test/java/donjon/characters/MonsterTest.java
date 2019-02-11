package donjon.characters;

import donjon.room.Room;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for monster
 *
 * @author Adeniss Karti François-Xavier Pelage
 */
public class MonsterTest {

    /**
     * Test method for the constructor of the monster
     */
    @Test
    public  void constTest(){
        Monster m1 =new Monster(10,3,10,"monstre 1");
        assertEquals(m1.getPv(),10);
    }

    /**
     * Test the die method for the monster
     */
    @Test
    public void die(){
        Monster m1 =new Monster(10,3,10,"DEVIL");
        Room r1=new Room("HELL");

        r1.addMonster(m1);
        assertEquals(r1.hasMonsters(),true);
        m1.die(r1);
        assertEquals(r1.hasMonsters(),false);

    }

}
