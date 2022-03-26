import java.util.ArrayList;

public class Player {
    public static int playerCount = 0;
    private int playerNum = 0;
    private Board home;
    private ArrayList<String> missed;
    private ArrayList<String> hit;
    private String name = "";
    private Board enemy;

    public Player(String name) {
        home = new Board();
        missed = new ArrayList<String>();
        hit = new ArrayList<String>();
        enemy = new Board();
        playerCount++;
        playerNum = playerCount;
        this.name = name;

    }

    public void addEnemyHit(String str){
        home.registerHit(str);

    }

    public void addMiss(String str){
        missed.add(str);
        enemy.registerHit(str);
    }

    public void addHit(String str){
        hit.add(str);
        enemy.registerHit(str);
    }

    public ArrayList<String> getHit() {
        return hit;
    }

    public void getMissed() {
        int ifunny = 0;
        System.out.println("The missed shots are ");
        for (int i = 0; i < missed.size() - 1; i++) {
            System.out.println(missed.get(i) + ", ");
            ifunny = i;
        }
        System.out.println(missed.get(ifunny + 1) + ".");
    }

    public Board getBoard() {
        return home;
    }

    public String getName() {
        return name;
    }

    public Board getEnemy() {
        return enemy;
    }

    public boolean isHasBoat4() {
        return home.checkBoat(4,4);
    }

    public boolean isHasBoat1() {
        return home.checkBoat(1,2);
    }

    public boolean isHasBoat2() {
        return home.checkBoat(2,3);
    }

    public boolean isHasBoat3() {
        return home.checkBoat(3,3);
    }

    public boolean isHasBoat5() {
        return home.checkBoat(5,5);
    }
}
