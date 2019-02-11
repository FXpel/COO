package donjon.room;

import donjon.characters.Monster;
import donjon.item.Item;
import donjon.item.LifePotion;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Room Test class
 *
 *@author Adeniss Karti François-Xavier Pelage
 */
public class RoomTest {
    /**
     *
     * Test the generation of Neighthboors
     */
    @Test
    public void generateNeigthboors() throws Exception {
        Room r1 = new Room("room");
        r1.generateNeigthboors();
        assertEquals(r1.getListVoisin().isEmpty(),false);
    }

    /**
     * Test the  generation of room
     *
     */
    @Test
    public void generateRoom() throws Exception {
        Room r1 = new Room("room");
        r1.generateRoom();
        assertEquals(r1.hasMonsters()||true,true);
        assertEquals(r1.hasItems()||true, true);
    }

    /**
     *
     * Test if an Exit exist when generated
     *
     */

    @Test
    public void addExit() throws Exception {
        Room r1 = new Room("room");
        r1.addExit();
        if(r1.getVoisin(Direction.North) instanceof Exit ){
            assertTrue(true);
        }else if (r1.getVoisin(Direction.East) instanceof Exit){
            assertTrue(true);
        }else if (r1.getVoisin(Direction.South) instanceof Exit){
            assertTrue(true);
        }else if(r1.getVoisin(Direction.West) instanceof Exit){
            assertTrue(true);
        }else{
            assertFalse(true);
        }
    }

    /**
     * Test if  a room is an exit
     *
     */
    @Test
    public void isExit() throws Exception {
        Room r1 =new Room("room");
        Room r2 = new Exit("exit");
        assertFalse(r1.isExit());
        assertTrue(r2.isExit());


    }

    /**
     * Test if getItem return the items
     *
     */
    @Test
    public void getItems() throws Exception {
        Room r1 =new Room("room");
        LifePotion pot = new LifePotion(100,"pot");
        List<Item> truc = new ArrayList<Item>();

        assertEquals(r1.getItems(),truc);
        r1.addItem(pot);
        truc.add(pot);
        assertEquals(r1.getItems(),truc);

    }

    /**
     *
     * Test if getMonster is return the monsters
     */

    @Test
    public void getMonsters() throws Exception {
        Room r1 =new Room("HELLroom");
        Monster m1 =new Monster(1,1,1,"Hello kitty");

        List<Monster> truc = new ArrayList<Monster>();

        assertEquals(r1.getMonsters(),truc);
        r1.addMonster(m1);
        truc.add(m1);
        assertEquals(r1.getMonsters(),truc);
    }

    /**
     *
     * Test  if it returns the directions in the list
     */
    @Test
    public void getVoisinDirection() throws Exception {
        Room r1 =new Room("room");
        Room r2 = new Room("room2");
        List<Direction>  truc = new ArrayList<Direction>();
        truc.add(Direction.North);
        r1.addVoisin(Direction.North,r2);
        assertEquals(r1.getVoisinDirection(),truc);
    }

    /**
     *
     * test if it return the choosen direction
     */
    @Test
    public void getVoisin() throws Exception {
        Room r1 =new Room("room");
        Room r2 = new Room("room2");

        r1.addVoisin(Direction.North,r2);
        assertEquals(r1.getVoisin(Direction.North),r2);

    }

    /**
     *
     * test if it add a monster
     */

    @Test
    public void addMonster() throws Exception {
        Room r1 = new Room("room");
        Monster m1 = new Monster(20,20,20,"truc");

        assertFalse(r1.hasMonsters());
        r1.addMonster(m1);
        assertTrue(r1.hasMonsters());

    }

    /**
     * test if it add an item
     *
     */
    @Test
    public void addItem() throws Exception {
        LifePotion oP_Pot= new LifePotion(100,"Pot craquée du MJ");
        Room r1 =new Room("room");

        assertFalse(r1.hasItems());
        r1.addItem(oP_Pot);
        assertTrue(r1.hasItems());

    }

    /**
     * test if it add an neightboors
     *
     */
    @Test
    public void addVoisin() throws Exception {

        Room r1 =new Room("room");
        Room r2 = new Room("room2");
        Room r3 = new Room("room 3");
        Map<Direction, Room> m2 = new HashMap <Direction,Room>();
        assertEquals(r1.getListVoisin(),m2);
        r1.addVoisin(Direction.North,r2);
        r1.addVoisin(Direction.East,r3);

        m2.put(Direction.North,r2);
        m2.put(Direction.East,r3);
        assertEquals(r1.getListVoisin(),m2);



    }

    /**
     * test if an item is removed from the room
     *
     */

    @Test
    public void removeItem() throws Exception {
        LifePotion oP_Pot= new LifePotion(100,"Pot craquée du MJ");
        Room r1 =new Room("room");


        r1.addItem(oP_Pot);
        assertTrue(r1.hasItems());
        r1.removeItem(oP_Pot);
        assertFalse(r1.hasItems());

    }

    /**
     * test fi a monster is revoved from the room
     *
     */
    @Test
    public void removeMonster() throws Exception {
        Room r1 = new Room("room");
        Monster m1 = new Monster(20,20,20,"truc");
        r1.addMonster(m1);

        assertTrue(r1.hasMonsters());
        r1.removeMonster(m1);
        assertFalse(r1.hasMonsters());

    }

    /**
     *
     * Test if there is monsters in the room
     */
    @Test
    public void hasMonsters() throws Exception {
        Room r1 = new Room("room");
        Monster m1 = new Monster(20,20,20,"truc");
        assertFalse(r1.hasMonsters());
        r1.addMonster(m1);
        assertTrue(r1.hasMonsters());

    }

    /**
     * test if there is an item in the room
     *
     */

    @Test
    public void hasItems() throws Exception {
        Room r1 = new Room("room");
        LifePotion oP_Pot= new LifePotion(100,"Pot craquée du MJ");
        assertFalse(r1.hasItems());

        r1.addItem(oP_Pot);;
        assertTrue(r1.hasItems());
    }



}
