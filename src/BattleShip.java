import java.util.Scanner;

public class BattleShip {
    Player player1;
    Player player2;
    boolean isRunning = true;
    public BattleShip(){}
    Player currentPlayer;
    Player otherPlayer;
    int currentPlayerTurn;

    public void run(){
        System.out.println("Welcome to The Battle Chips");
        System.out.println("*Definitely NOT Ships*");
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Player 1 Name: ");
        player1 = new Player(scan.nextLine());
        System.out.println();
        System.out.print("Enter Player 2 Name: ");
        player2 = new Player(scan.nextLine());
        currentPlayer = player1;
        otherPlayer = player2;
        currentPlayerTurn = 1;
        System.out.println();
        setUp();
        System.out.println("Wow that was sure a lot of set up but now you can play the game.......\nWOOOOOOOO");
        System.out.println("Here is the menu");
        while (isRunning){
            menu();
        }


    }


    public void menu(){
        int option = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("@--^-^--MENU--^-^--@");
        System.out.println("  1. Make a Play");
        System.out.println("  2. Show Hit Board");
        System.out.println("  3. Switch Player");
        System.out.println("  4. Show Misses");
        System.out.println("  5. Show Rules");
        System.out.println("  6. Reset Game");
        System.out.println("  7. Quit game");
        System.out.println("@--^-^--(**)--^-^--@");
        System.out.println();
        System.out.print("Enter Option: ");
        option = scan.nextInt();
        scan.nextLine();
        if (option == 1){
            if (currentPlayerTurn > 0) {
                System.out.println();
                System.out.print("Please make guess(row,column): ");
                currentPlayerTurn--;
                String guess = scan.nextLine();
                if (otherPlayer.getBoard().checkHit(guess)) {
                    System.out.println("HIT!");
                    player1.addHit(guess);
                } else {
                    System.out.println("miss...");
                    player1.addMiss(guess);
                }
            } else {
                System.out.println("You already had your turn, please switch players");
            }

            if(lost()){
                System.out.println(otherPlayer.getName() + " lost, better luck next time");
                System.out.println("Do you want to play again (y/n)? ");
                String play = scan.nextLine();
                if (play.equals("y")){
                    run();
                }
                System.out.println("Game Ending");
                System.out.println("Hope You Had Fun, and ");
                System.out.print("See You Space Cowboy(s)");
                System.out.print(".");
                System.out.print(".");
                System.out.println(".");
                System.out.print("(Cool Reference)");
                isRunning = false;
            }

        }else if (option == 2){
            player1.getEnemy().printBoard();

        }else if (option == 3){
            if (currentPlayer == player1){
                currentPlayer = player2;
                otherPlayer = player1;
            } else if (currentPlayer == player2){
                currentPlayer = player1;
                otherPlayer = player2;
            }
            currentPlayerTurn = 1;
            System.out.println("Current player is " + currentPlayer.getName());

        } else if (option == 4){
            currentPlayer.getMissed();

        } else if (option == 5){
            System.out.println("#-_____-----------_____-----------Rules-----------_____-----------_____-#");
            System.out.println("Player's take turns guessing by calling(typing) out the coordinates where");
            System.out.println("they think enemy chips(not ships) are. They system will tell you if you ");
            System.out.println("hit or miss the enemy ships. (Tip: Try to shoot around confirmed hits to ");
            System.out.println("get a whole ship. The game will not tell you what type of ship it was so ");
            System.out.println("you will have to guess the length of the ship. (Tip: length can't be lower");
            System.out.println("than 2 and larger than 5. Hits would be a \" * \" and misses be \" 0 \" on");
            System.out.println("the enemy/hit board. The game ends when one player looses all ships, or on");
            System.out.println("the quit button press. That's all folks, have fun :)");
            System.out.println("#_____-----------_____-----------___-___-----------_____-----------_____#");

        } else if (option == 6){
            run();

        } else if (option == 7){
            isRunning = false;
            System.out.println("Hope You Had Fun, and ");
            System.out.print("See You Space Cowboy(s)");
            System.out.print(".");
            System.out.print(".");
            System.out.println(".");
            System.out.print("(Cool Reference)");
        } else {
            System.out.println("Incorrect input, please input just the numbers: 1,2,3,4,5, or 6");
        }

    }

    public boolean lost(){
        if (otherPlayer.isHasBoat5() && otherPlayer.isHasBoat4() && otherPlayer.isHasBoat3() && otherPlayer.isHasBoat2() && otherPlayer.isHasBoat1()){
            return false;
        }
        return  true;
    }

    public void setUp(){
        String startPoint = "";
        String endPoint = "";
        boolean ship11 = false, ship12 = false, ship13 = false, ship14 = false, ship15 = false;
        boolean ship21 = false, ship22 = false, ship23 = false, ship24 = false, ship25 = false;


        String direction = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("First off, let's setup the chips......(not ships)");
        System.out.println("There are 5 chips, setup will start with the largest one. Also first player sets up first");
        System.out.println("Please only put ships vertically or horizontally and so that none overlap or get put of the board\nAlso input values in this format: (row,column) with no space\nStarts at (1,1) and ends at (10,10)");
        System.out.println();
        player1.getBoard().printBoard();
        System.out.println(player1.getName() + "'s turn:");
        while(!ship15){
            System.out.print("Select start point(length 5): ");
            startPoint = scan.nextLine();
            System.out.print("Select end point:");
            endPoint = scan.nextLine();
            System.out.print("Vertical or Horizontal (h or v): ");
            direction = scan.nextLine();
            if(player1.getBoard().setUpShip(5, startPoint, endPoint, direction, "5")){
                System.out.println("Ship set up successfully");
                ship15 = true;
            } else {System.out.println("Ship wasn't set up, try again with correct values now ");}
        }
        System.out.println();
        System.out.println(player1.getName() + "'s board:");
        player1.getBoard().printBoard();
        while(!ship14){
            System.out.print("Select start point(length 4): ");
            startPoint = scan.nextLine();
            System.out.print("Select end point:");
            endPoint = scan.nextLine();
            System.out.print("Vertical or Horizontal (h or v): ");
            direction = scan.nextLine();
            if(player1.getBoard().setUpShip(4, startPoint, endPoint, direction, "4")){
                System.out.println("Ship set up successfully");
                ship14 = true;
            } else {System.out.println("Ship wasn't set up, try again with correct values now ");}
        }
        System.out.println();
        System.out.println(player1.getName() + "'s board:");
        player1.getBoard().printBoard();
        while(!ship13){
            System.out.print("Select start point(length 3): ");
            startPoint = scan.nextLine();
            System.out.print("Select end point:");
            endPoint = scan.nextLine();
            System.out.print("Vertical or Horizontal (h or v): ");
            direction = scan.nextLine();
            if(player1.getBoard().setUpShip(3, startPoint, endPoint, direction, "3")){
                System.out.println("Ship set up successfully");
                ship13 = true;
            } else {System.out.println("Ship wasn't set up, try again with correct values now ");}
        }
        System.out.println();
        System.out.println(player1.getName() + "'s board:");
        player1.getBoard().printBoard();
        while(!ship12){
            System.out.print("Select start point(length 3): ");
            startPoint = scan.nextLine();
            System.out.print("Select end point:");
            endPoint = scan.nextLine();
            System.out.print("Vertical or Horizontal (h or v): ");
            direction = scan.nextLine();
            if(player1.getBoard().setUpShip(3, startPoint, endPoint, direction, "2")){
                System.out.println("Ship set up successfully");
                ship12 = true;
            } else {System.out.println("Ship wasn't set up, try again with correct values now ");}
        }
        System.out.println();
        System.out.println(player1.getName() + "'s board:");
        player1.getBoard().printBoard();
        while(!ship11){
            System.out.print("Select start point(length 2): ");
            startPoint = scan.nextLine();
            System.out.print("Select end point:");
            endPoint = scan.nextLine();
            System.out.print("Vertical or Horizontal (h or v): ");
            direction = scan.nextLine();
            if(player1.getBoard().setUpShip(2, startPoint, endPoint, direction, "1")){
                System.out.println("Ship set up successfully");
                ship11 = true;
            } else {System.out.println("Ship wasn't set up, try again with correct values now ");}
        }
        System.out.println();
        System.out.println(player1.getName() + "'s board:");
        player1.getBoard().printBoard();

        System.out.println();
        System.out.println("Ok, now it's " + player2.getName() + " turn, " + player1.getName() + " please look away");
        System.out.println("There are 5 chips(not ships), setup will start with the largest one. Also first player sets up first");
        System.out.println("Please only put ships vertically or horizontally and so that none overlap or get put of the board\nAlso input values in this format: (row,column) with no space\nStarts at (1,1) and ends at (10,10)");
        System.out.println();
        System.out.println(player2.getName() + "'s turn:");
        player2.getBoard().printBoard();
        while(!ship25){
            System.out.print("Select start point(length 5): ");
            startPoint = scan.nextLine();
            System.out.print("Select end point:");
            endPoint = scan.nextLine();
            System.out.print("Vertical or Horizontal (h or v): ");
            direction = scan.nextLine();
            if(player2.getBoard().setUpShip(5, startPoint, endPoint, direction, "5")){
                System.out.println("Ship set up successfully");
                ship25 = true;
            } else {System.out.println("Ship wasn't set up, try again with correct values now ");}
        }
        System.out.println();
        System.out.println(player2.getName() + "'s board:");
        player2.getBoard().printBoard();
        while(!ship24){
            System.out.print("Select start point(length 4): ");
            startPoint = scan.nextLine();
            System.out.print("Select end point:");
            endPoint = scan.nextLine();
            System.out.print("Vertical or Horizontal (h or v): ");
            direction = scan.nextLine();
            if(player2.getBoard().setUpShip(4, startPoint, endPoint, direction, "4")){
                System.out.println("Ship set up successfully");
                ship24 = true;
            } else {System.out.println("Ship wasn't set up, try again with correct values now ");}
        }
        System.out.println();
        System.out.println(player2.getName() + "'s board:");
        player2.getBoard().printBoard();
        while(!ship23){
            System.out.print("Select start point(length 3): ");
            startPoint = scan.nextLine();
            System.out.print("Select end point:");
            endPoint = scan.nextLine();
            System.out.print("Vertical or Horizontal (h or v): ");
            direction = scan.nextLine();
            if(player2.getBoard().setUpShip(3, startPoint, endPoint, direction, "3")){
                System.out.println("Ship set up successfully");
                ship23 = true;
            } else {System.out.println("Ship wasn't set up, try again with correct values now ");}
        }
        System.out.println();
        System.out.println(player2.getName() + "'s board:");
        player2.getBoard().printBoard();
        while(!ship22){
            System.out.print("Select start point(length 3): ");
            startPoint = scan.nextLine();
            System.out.print("Select end point:");
            endPoint = scan.nextLine();
            System.out.print("Vertical or Horizontal (h or v): ");
            direction = scan.nextLine();
            if(player2.getBoard().setUpShip(3, startPoint, endPoint, direction, "2")){
                System.out.println("Ship set up successfully");
                ship22 = true;
            } else {System.out.println("Ship wasn't set up, try again with correct values now ");}
        }
        System.out.println();
        System.out.println(player2.getName() + "'s board:");
        player2.getBoard().printBoard();
        while(!ship21){
            System.out.print("Select start point(length 2): ");
            startPoint = scan.nextLine();
            System.out.print("Select end point:");
            endPoint = scan.nextLine();
            System.out.print("Vertical or Horizontal (h or v): ");
            direction = scan.nextLine();
            if(player2.getBoard().setUpShip(2, startPoint, endPoint, direction, "1")){
                System.out.println("Ship set up successfully");
                ship21 = true;
            } else {System.out.println("Ship wasn't set up, try again with correct values now ");}
        }
        System.out.println();
        System.out.println(player2.getName() + "'s board:");
        player2.getBoard().printBoard();

    }
}
