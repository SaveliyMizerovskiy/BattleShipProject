import java.util.ArrayList;
/**
 *Logic for each player in the game
 * @author Saveliy Mizerovskiy
 */
public class Player {
    /** Keeps count of the number player */
    public static int playerCount = 0;
    /** current player number */
    private int playerNum = 0;
    /** current players game board */
    private Board home;
    /** An arraylist of the missed shots */
    private ArrayList<String> missed;
    /** An arraylist of shots that hit */
    private ArrayList<String> hit;
    /** Name of the player */
    private String name = "";
    /** Other players board */
    private Board enemy;

    /**
     *  Constructor for each player
     * @param name name of player
     *  */
    public Player(String name) {
        home = new Board();
        missed = new ArrayList<String>();
        hit = new ArrayList<String>();
        enemy = new Board();
        playerCount++;
        playerNum = playerCount;
        this.name = name;

    }
    /** Registers other players hit
     * @param str point where the hit occurred */
    public void addEnemyHit(String str){
        home.registerHit(str);

    }
    /** register a miss
     * @param str point where the shot was */
    public void addMiss(String str){
        missed.add(str);
        enemy.registerHit(str);
    }
    /** registers a hit
     * @param str point where the shot was*/
    public void addHit(String str){
        hit.add(str);
        enemy.registerHit(str);
    }
    /** Return an arraylist of hits
     * @return array of hits */
    public ArrayList<String> getHit() {
        return hit;
    }
    /** Prints out the misses */
    public void getMissed() {
        int ifunny = 0;
        System.out.println("The missed shots are ");
        for (int i = 0; i < missed.size() - 1; i++) {
            System.out.println(missed.get(i) + ", ");
            ifunny = i;
        }
        System.out.println(missed.get(ifunny + 1) + ".");
    }
    /** Returns players board
     * @return players board */
    public Board getBoard() {
        return home;
    }
    /** Return name of player
     * @return name of player
     * */
    public String getName() {
        return name;
    }
    /** Returns the hits board
     * @return the hits board */
    public Board getEnemy() {
        return enemy;
    }
    /** Gets status of boat 4
     * @return true of boat is still there */
    public boolean isHasBoat4() {
        return home.checkBoat(4,4);
    }
    /** Gets status of boat 1
     * @return true of boat is still there */
    public boolean isHasBoat1() {
        return home.checkBoat(1,2);
    }
    /** Gets status of boat 2
     * @return true of boat is still there */
    public boolean isHasBoat2() {
        return home.checkBoat(2,3);
    }
    /** Gets status of boat 3
     * @return true of boat is still there */
    public boolean isHasBoat3() {
        return home.checkBoat(3,3);
    }
    /** Gets status of boat 5
     * @return true of boat is still there */
    public boolean isHasBoat5() {
        return home.checkBoat(5,5);
    }
}
