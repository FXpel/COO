package donjon.UI;

import donjon.action.Action;
import donjon.characters.Monster;
import donjon.item.Item;
import donjon.room.Direction;
import donjon.room.Room;

import java.util.List;
import java.util.Map;

/**
 * A class too display the game information
 */
public class Interact {

    /**
     * Create a interact object
     */
    public Interact(){}

    /**
     * Ask the player to chose an action
     *
     * @param listAction the list of possible actions
     * @return the index of the choosen action
     */
    public String actions(Map<String,Action> listAction){
        int i =0;
    	String answer;
        System.out.println("What action do you want to do ?");
        for (Map.Entry<String, Action> entry : listAction.entrySet()) {
			System.out.println(i + " - " + entry.getValue());
            i++;
        }
        System.out.println("Answer for example by move or attack.");
        answer = Input.readString();
        System.out.println(listAction);

        if(listAction.containsKey(answer)) {
        	return answer;
        }
        else {

        	return actions(listAction);
        }
    }

    /**
     * Ask the player to chose an direction
     *
     * @param list the list of possible direction
     * @return the choosen direction
     */
    public Direction move(Map<Direction,Room> listdir){

        Direction answer = null;
        System.out.println("Where do your want to go?");
        System.out.println("Select one of the direction above!");
        for (Map.Entry<Direction,Room> entry : listdir.entrySet()) {
			System.out.println(entry.getKey());

        }
        System.out.println("Answer by a direction .");
        while(answer == null){
            answer = this.stringToDirection(Input.readString());
            if (!listdir.containsKey(answer)){
            	System.out.println("Sorry you can't go there!");
                return move(listdir);
            }
        }
        return answer;
    }

    /**
     * Convert a string to a direction
     * @param answer the string to convert
     * @return a direction, the result of the conversion
     */
    public Direction stringToDirection(String answer){
        Direction res = null;
        answer = answer.toLowerCase();
        if (answer.equals("north")) {
            res = Direction.North;
        }
        if (answer.equals("south")){
            res = Direction.South;
        }
        if (answer.equals("west")){
            res = Direction.West;
        }
        if(answer.equals("east")){
            res = Direction.East;
        }
        return res;
    }

    /**
     * Ask the player which monster attack
     *
     * @param listMonster the list of monsters in the room
     * @return the index of the monster in the monsters list
     */
    public int attack(List<Monster> listMonster){
        int i = 1;
        int answer = -1;
        System.out.println("What monster do you want to attack ?");
        for(Monster a : listMonster){
            System.out.println(i + " - " + a.toString() + ", strength : " + a.getForce() + ", life : " + a.getPv());
            i++;
        }
        System.out.println("Answer by an number.");
        while(answer == -1){
            try {
                answer = Input.readInt();
                if (answer > listMonster.size()){
                    answer = -1;
                }
            }
            catch (java.io.IOException e){
                System.out.println("Bad monster selection");
                answer = -1;
            }
        }
        return answer - 1;
    }

    /**
     * Ask the player which items use
     *
     *@param listItem the list of items in the room
     * @return the index of the items
     */
    public int use(List<Item> listItem){
        int i = 1;
        int answer = -1;
        System.out.println("Which item do you want to use ?");
        for(Item a : listItem){
            System.out.println(i + " - " + a.toString());
            i++;
        }
        System.out.println("Answer by an number.");
        while(answer == -1){
            try {
                answer = Input.readInt();
                System.out.println(answer);
                if (answer -1 > listItem.size()){
                	answer -=1;
                }
                if (answer > listItem.size()){
                	return use(listItem);
                }
            }
            catch (java.io.IOException e){
                System.out.println("Bad item selection");
                return use(listItem);
            }
        }
        return answer-1;
    }

    public String namePlayer(){
        boolean ok = false;
        String n = "";
        while(!ok){
            System.out.println("What's your name ?");
            n = Input.readString();
            System.out.println("Are you sure ? (yes/no)");
            String ans = Input.readString().toUpperCase();
            if (ans.equals("YES")){
                ok = true;
            }
        }
        return n;
    }

    public boolean interBandit(int playerGolds, int cost){
        boolean use = false;
        if (playerGolds < cost){
            System.out.println("Sorry but you don't have enougth money");
        }
        else{
            boolean ok = false;
            while (!ok){
                System.out.println("Do you want to use one armed bandit ? (random effect)(yes/no)");
                String ans = Input.readString().toUpperCase();
                if (ans.equals("YES")){
                    ok = true;
                    use = true;
                }
                else if(ans.equals("NO")){
                    ok = true;
                }
            }
        }
        return use;
    }

}
