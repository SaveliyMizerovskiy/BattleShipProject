/**
 * logic for the game board
 * @author Saveliy Mizerovskiy
 */
public class Board {
    /** A 2D Array of all the point on the board */
    private String[][] board;
    /** A boolean that represents if the space is clear for the boat */
    private boolean isClear;
    /** Counts to check if enough space is left for the boat */
    private int count;
    /** Constructor for the Board */
    public Board() {
        board = new String[10][10];
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                board[row][column] = "~";
            }
        }
    }
    /** Returns the board array
     * @return the 2d array */
    public String[][] getBoard() {
        return board;
    }
    /** prints the board */
    public void printBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                System.out.print("[" + board[row][column] + "]");
            }
            System.out.println();
        }
    }
    /** Plugs in the right value for hit into the board 2d array
     * @param point point where to plug in the value in the array */
    public void registerHit(String point){
        int row = Integer.parseInt(point.substring(point.indexOf("(") + 1, point.indexOf(","))) - 1;
        int column = Integer.parseInt(point.substring(point.indexOf(",") + 1, point.indexOf(")"))) -1;
        if (checkHit(point)){
            board[row][column] = "*";
        } else {
            board[row][column] = "0";
        }
    }
    /** Checks if the hit is valid by checking if there is just water or an actual ship there
     * @param point point where to check*/
    public boolean checkHit(String point){
        int row = Integer.parseInt(point.substring(point.indexOf("(") + 1, point.indexOf(","))) - 1;
        int column = Integer.parseInt(point.substring(point.indexOf(",") + 1, point.indexOf(")"))) -1;
        if (!board[row][column].equals("~")){
            return true;
        }
        return false;
    }
    /** Checks if the boat is still in the 2d array
     * @param boatLength the length of the boat
     * @param boatNum the number that represents the boat
     * @return Returns if the boat is there
     * */
    public boolean checkBoat(int boatNum, int boatLength){
        int count = 0;
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if(board[row][column].equals("" + boatNum)){
                    count++;
                }
            }
        }
        if (count == boatLength){
            return true;
        }
        return false;
    }
    /** Places down the ship
     * @param boat the number that represents the boat as a string
     * @param direction string that shows if the boat is vertical or horizontal
     * @param endPoint the point where the boat stops or the closest to it
     * @param length the length of the boat
     * @param startPoint the point where the boat is supposed to start
     * @return if the ship setup was successful
     *
     * */
    public boolean setUpShip(int length, String startPoint, String endPoint, String direction, String boat) {
        int startRow = Integer.parseInt(startPoint.substring(startPoint.indexOf("(") + 1, startPoint.indexOf(","))) - 1;
        int startColumn = Integer.parseInt(startPoint.substring(startPoint.indexOf(",") + 1, startPoint.indexOf(")"))) -1;
        int endRow = Integer.parseInt(endPoint.substring(endPoint.indexOf("(") + 1, endPoint.indexOf(","))) - 1;
        int endColumn = Integer.parseInt(endPoint.substring(endPoint.indexOf(",") + 1, endPoint.indexOf(")"))) - 1;
        isClear = false;
        count = 0;


        if (direction.equals("h")) {
            if (startColumn < endColumn) {
                for (int i = 0; i < length; i++) {
                    if (board[startRow][startColumn + i].equals("~")) {
                        count++;
                    }
                }
            } else {
                for (int i = 0; i < length; i++) {
                    if (board[endRow][endColumn + i].equals("~")) {
                        count++;
                    }
                }
            }
        } else if (direction.equals("v")) {
            if (startRow < endRow) {
                for (int i = 0; i < length; i++) {
                    if (board[startRow + i][startColumn].equals("~")) {
                        count++;
                    }
                }
            } else {
                for (int i = 0; i < length; i++) {
                    if (board[endRow + i][endColumn].equals("~")) {
                        count++;
                    }
                }
            }
        }
        if (count == length) {
            isClear = true;
        }
        if (isClear) {
            if (direction.equals("h")) {
                if (startColumn < endColumn) {
                    for (int i = 0; i < length; i++) {
                        board[startRow][startColumn + i] = boat;
                    }
                    return true;
                } else {
                    for (int i = 0; i < length; i++) {
                        board[endRow][endColumn + i] = boat;
                    }
                    return true;
                }
            } else if (direction.equals("v")) {
                if (startRow < endRow) {
                    for (int i = 0; i < length; i++) {
                        board[startRow + i][startColumn] = boat;
                    }
                    return true;
                } else {
                    for (int i = 0; i < length; i++) {
                        board[endRow + i][endColumn] = boat;
                    }
                    return true;
                }
            }
        }
        return false;
    }
    /** Returns the clear status
     * @return isClear */
    public boolean isClear(){
        return isClear;
    }

    /** Returns the count for if the boat could fit
     * @return the count of spaces available for boat in its way */
    public int getCount() {
        return count;
    }
}
