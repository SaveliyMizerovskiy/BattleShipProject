public class Board {
    private String[][] board;
    private boolean isClear;
    private int count;

    public Board() {
        board = new String[10][10];
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                board[row][column] = "~";
            }
        }
    }

    public String[][] getBoard() {
        return board;
    }

    public void printBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                System.out.print("[" + board[row][column] + "]");
            }
            System.out.println();
        }
    }

    public void registerHit(String point){
        int row = Integer.parseInt(point.substring(point.indexOf("(") + 1, point.indexOf(","))) - 1;
        int column = Integer.parseInt(point.substring(point.indexOf(",") + 1, point.indexOf(")"))) -1;
        if (checkHit(point)){
            board[row][column] = "*";
        } else {
            board[row][column] = "0";
        }
    }

    public boolean checkHit(String point){
        int row = Integer.parseInt(point.substring(point.indexOf("(") + 1, point.indexOf(","))) - 1;
        int column = Integer.parseInt(point.substring(point.indexOf(",") + 1, point.indexOf(")"))) -1;
        if (!board[row][column].equals("~")){
            return true;
        }
        return false;
    }

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

    public boolean isClear(){
        return isClear;
    }

    public int getCount() {
        return count;
    }
}
