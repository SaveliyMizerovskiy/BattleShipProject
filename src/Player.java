import java.util.ArrayList;

public class Player {
    public static int playerCount = 0;
    private int playerNum = 0;
    private Board home;
    private ArrayList<String> missed;
    private ArrayList<String> hit;
    private String name = "";

    public Player(String name) {
        home = new Board();
        missed = new ArrayList<String>();
        hit = new ArrayList<String>();
        playerCount++;
        playerNum = playerCount;
        this.name = name;
    }

    public ArrayList<String> getHit() {
        return hit;
    }

    public ArrayList<String> getMissed() {
        return missed;
    }

    public Board getHome() {
        return home;
    }

    public String getName() {
        return name;
    }

}
