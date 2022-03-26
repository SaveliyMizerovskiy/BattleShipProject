import java.util.Scanner;

public class BattleShip {
    Player player1;
    Player player2;
    boolean isRunning = true;
    public BattleShip(){}

    public void run(){
        System.out.println("Welcome to The Battle Chips");
        System.out.println("*Definitely NOT Ships*");
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Player 1 Name: ");
        player1 = new Player(scan.nextLine());
        System.out.println();
        System.out.print("Enter Player 2 Name: ");
        player2 = new Player(scan.nextLine());
        System.out.println();
        //setUp();
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
        System.out.println("  2. Switch Player");
        System.out.println("  3. Show Misses");
        System.out.println("  4. Show Rules");
        System.out.println("  5. Reset Game");
        System.out.println("  6. Quit game");
        System.out.println("@--^-^--(**)--^-^--@");
        System.out.println();
        System.out.print("Enter Option: ");
        option = scan.nextInt();
        if (option == 1){

        } else if (option == 2){

        } else if (option == 3){

        } else if (option == 4){

        } else if (option == 5){

        } else if (option == 6){
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
        System.out.println(player1.getName() + "'s turn:");
        while(!ship15){
            System.out.print("Select start point(length 5): ");
            startPoint = scan.nextLine();
            System.out.print("Select end point:");
            endPoint = scan.nextLine();
            System.out.print("Vertical or Horizontal (h or v): ");
            direction = scan.nextLine();
            if(player1.getHome().setUpShip(5, startPoint, endPoint, direction, "5")){
                System.out.println("Ship set up successfully");
                ship15 = true;
            } else {System.out.println("Ship wasn't set up, try again with correct values now ");}
        }
        System.out.println();
        System.out.println(player1.getName() + "'s board:");
        player1.getHome().printBoard();
        while(!ship14){
            System.out.print("Select start point(length 4): ");
            startPoint = scan.nextLine();
            System.out.print("Select end point:");
            endPoint = scan.nextLine();
            System.out.print("Vertical or Horizontal (h or v): ");
            direction = scan.nextLine();
            if(player1.getHome().setUpShip(4, startPoint, endPoint, direction, "4")){
                System.out.println("Ship set up successfully");
                ship14 = true;
            } else {System.out.println("Ship wasn't set up, try again with correct values now ");}
        }
        System.out.println();
        System.out.println(player1.getName() + "'s board:");
        player1.getHome().printBoard();
        while(!ship13){
            System.out.print("Select start point(length 3): ");
            startPoint = scan.nextLine();
            System.out.print("Select end point:");
            endPoint = scan.nextLine();
            System.out.print("Vertical or Horizontal (h or v): ");
            direction = scan.nextLine();
            if(player1.getHome().setUpShip(3, startPoint, endPoint, direction, "3")){
                System.out.println("Ship set up successfully");
                ship13 = true;
            } else {System.out.println("Ship wasn't set up, try again with correct values now ");}
        }
        System.out.println();
        System.out.println(player1.getName() + "'s board:");
        player1.getHome().printBoard();
        while(!ship12){
            System.out.print("Select start point(length 3): ");
            startPoint = scan.nextLine();
            System.out.print("Select end point:");
            endPoint = scan.nextLine();
            System.out.print("Vertical or Horizontal (h or v): ");
            direction = scan.nextLine();
            if(player1.getHome().setUpShip(3, startPoint, endPoint, direction, "2")){
                System.out.println("Ship set up successfully");
                ship12 = true;
            } else {System.out.println("Ship wasn't set up, try again with correct values now ");}
        }
        System.out.println();
        System.out.println(player1.getName() + "'s board:");
        player1.getHome().printBoard();
        while(!ship11){
            System.out.print("Select start point(length 2): ");
            startPoint = scan.nextLine();
            System.out.print("Select end point:");
            endPoint = scan.nextLine();
            System.out.print("Vertical or Horizontal (h or v): ");
            direction = scan.nextLine();
            if(player1.getHome().setUpShip(2, startPoint, endPoint, direction, "1")){
                System.out.println("Ship set up successfully");
                ship11 = true;
            } else {System.out.println("Ship wasn't set up, try again with correct values now ");}
        }
        System.out.println();
        System.out.println(player1.getName() + "'s board:");
        player1.getHome().printBoard();

        System.out.println();
        System.out.println("Ok, now it's " + player2.getName() + " turn, " + player1.getName() + " please look away");
        System.out.println("There are 5 chips, setup will start with the largest one. Also first player sets up first");
        System.out.println("Please only put ships vertically or horizontally and so that none overlap or get put of the board\nAlso input values in this format: (row,column) with no space\nStarts at (1,1) and ends at (10,10)");
        System.out.println();
        System.out.println(player2.getName() + "'s turn:");
        while(!ship25){
            System.out.print("Select start point(length 5): ");
            startPoint = scan.nextLine();
            System.out.print("Select end point:");
            endPoint = scan.nextLine();
            System.out.print("Vertical or Horizontal (h or v): ");
            direction = scan.nextLine();
            if(player2.getHome().setUpShip(5, startPoint, endPoint, direction, "5")){
                System.out.println("Ship set up successfully");
                ship25 = true;
            } else {System.out.println("Ship wasn't set up, try again with correct values now ");}
        }
        System.out.println();
        System.out.println(player2.getName() + "'s board:");
        player2.getHome().printBoard();
        while(!ship24){
            System.out.print("Select start point(length 4): ");
            startPoint = scan.nextLine();
            System.out.print("Select end point:");
            endPoint = scan.nextLine();
            System.out.print("Vertical or Horizontal (h or v): ");
            direction = scan.nextLine();
            if(player2.getHome().setUpShip(4, startPoint, endPoint, direction, "4")){
                System.out.println("Ship set up successfully");
                ship24 = true;
            } else {System.out.println("Ship wasn't set up, try again with correct values now ");}
        }
        System.out.println();
        System.out.println(player2.getName() + "'s board:");
        player2.getHome().printBoard();
        while(!ship23){
            System.out.print("Select start point(length 3): ");
            startPoint = scan.nextLine();
            System.out.print("Select end point:");
            endPoint = scan.nextLine();
            System.out.print("Vertical or Horizontal (h or v): ");
            direction = scan.nextLine();
            if(player2.getHome().setUpShip(3, startPoint, endPoint, direction, "3")){
                System.out.println("Ship set up successfully");
                ship23 = true;
            } else {System.out.println("Ship wasn't set up, try again with correct values now ");}
        }
        System.out.println();
        System.out.println(player2.getName() + "'s board:");
        player2.getHome().printBoard();
        while(!ship22){
            System.out.print("Select start point(length 3): ");
            startPoint = scan.nextLine();
            System.out.print("Select end point:");
            endPoint = scan.nextLine();
            System.out.print("Vertical or Horizontal (h or v): ");
            direction = scan.nextLine();
            if(player2.getHome().setUpShip(3, startPoint, endPoint, direction, "2")){
                System.out.println("Ship set up successfully");
                ship22 = true;
            } else {System.out.println("Ship wasn't set up, try again with correct values now ");}
        }
        System.out.println();
        System.out.println(player2.getName() + "'s board:");
        player2.getHome().printBoard();
        while(!ship21){
            System.out.print("Select start point(length 2): ");
            startPoint = scan.nextLine();
            System.out.print("Select end point:");
            endPoint = scan.nextLine();
            System.out.print("Vertical or Horizontal (h or v): ");
            direction = scan.nextLine();
            if(player2.getHome().setUpShip(2, startPoint, endPoint, direction, "1")){
                System.out.println("Ship set up successfully");
                ship21 = true;
            } else {System.out.println("Ship wasn't set up, try again with correct values now ");}
        }
        System.out.println();
        System.out.println(player2.getName() + "'s board:");
        player2.getHome().printBoard();

    }
}
