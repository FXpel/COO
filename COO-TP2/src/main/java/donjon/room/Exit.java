package donjon.room;

/**
 * A class for Exit Room
 *
 * @see donjon.room.Room
 */
public class Exit extends Room{

    /**
     * Create an Exit room object
     * @param name the name of the room
     */
    public Exit(String name){
        super(name);
    }

    /**
     * Say if the room is the exit or not
     * @return the boolean true
     */
    public boolean isExit(){
        return true;
    }
}
