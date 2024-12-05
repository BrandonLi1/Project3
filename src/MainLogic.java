import java.util.Scanner;


public class MainLogic {
    Scanner scanner = new Scanner(System.in);
    private int cash=0;
    private boolean playing = true;


    public MainLogic () {
        System.out.print("How much cash do you have? ");
        cash = scanner.nextInt();
    }


    public void start() {
        String RED = "\u001B[31m"; //https://www.tutorialspoint.com/how-to-print-colored-text-in-java-console
        String RESET = "\u001B[0m";
        while (playing == true) { //initializes to true, checks if it's still true and lets you play a game if it is
            System.out.print(RED + "DISCLAIMER WE DO NOT CONDONE CHILD GAMBLING" + RESET + "\n");
            System.out.println("WELCOME TO THE MILLIONAIRE ISLAND!!!");
            boolean goodresponse = true;
            while (goodresponse == true) { //checks if response is valid and if it isn't, it asks again
                System.out.println("What game do you wish to play? 1) BlackJack 2) Roulette 3) Slots 4) Spinner Wheel");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    BlackJackRunner();
                    goodresponse = false;
                } else if (choice == 2) {
                    RouletteRunner();
                    goodresponse = false;
                } else if (choice == 3) {
                    SlotsRunner();
                    goodresponse = false;
                } else if (choice == 4) {
                    SpinnerWheel();
                    goodresponse=false;
                }
                else {
                    System.out.println("INVALID RESPONSE");
                    goodresponse = true;
                }
            }
        }
    }


    private void end() {
        System.out.println();
        boolean goodresponse2 = true;
        while(goodresponse2 == true){ //initialized to true and if false it lets you leave the casino at a 70% chance
            System.out.print("Do you wish to stay at the casino (yes /  no): ");
            String Stay = scanner.nextLine();
            if(Stay.equals("yes")) {
                playing =true;
                goodresponse2 = false;
                start();
            } else if(Stay.equals("no")){
                int addiction = (int)((Math.random()* 10) + 1);
                if (addiction == 1 || addiction == 2 || addiction == 3) { //after this is run, because it's still in the "start" loop, it runs start again
                    playing = true;
                    goodresponse2 = false;
                    System.out.println("do you know 90% of gamblers quit before they hit the jackpot???? \n ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⢯⠙⠩⠀⡇⠊⠽⢖⠆⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠱⣠⠀⢁⣄⠔⠁⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⣷⣶⣾⣾⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⢀⡔⠙⠈⢱⡟⣧⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⡠⠊⠀⠀⣀⡀⠀⠘⠕⢄⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⢀⠞⠀⠀⢀⣠⣿⣧⣀⠀⠀⢄⠱⡀⠀⠀⠀\n" +
                            "⠀⠀⡰⠃⠀⠀⢠⣿⠿⣿⡟⢿⣷⡄⠀⠑⢜⢆⠀⠀\n" +
                            "⠀⢰⠁⠀⠀⠀⠸⣿⣦⣿⡇⠀⠛⠋⠀⠨⡐⢍⢆⠀\n" +
                            "⠀⡇⠀⠀⠀⠀⠀⠙⠻⣿⣿⣿⣦⡀⠀⢀⠨⡒⠙⡄\n" +
                            "⢠⠁⡀⠀⠀⠀⣤⡀⠀⣿⡇⢈⣿⡷⠀⠠⢕⠢⠁⡇\n" +
                            "⠸⠀⡕⠀⠀⠀⢻⣿⣶⣿⣷⣾⡿⠁⠀⠨⣐⠨⢀⠃\n" +
                            "⠀⠣⣩⠘⠀⠀⠀⠈⠙⣿⡏⠁⠀⢀⠠⢁⡂⢉⠎⠀\n" +
                            "⠀⠀⠈⠓⠬⢀⣀⠀⠀⠈⠀⠀⠀⢐⣬⠴⠒⠁⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀");
                } else {
                    playing = false;
                    goodresponse2 = false;
                    System.out.println("Come back to the Casino whenever you have money to spare");
                }
            } else {
                System.out.println("INVALID RESPONSE");
                goodresponse2 = true;
            }
        }
    }


    public void BlackJackRunner(){
        System.out.print("Welcome to BlackJack, how much do you want to bet: ");
        String playAgain = "";
        int blackbet = scanner.nextInt();
        BlackJack blackjack = new BlackJack(cash, blackbet);
        BlackJack dealer = new BlackJack(cash);
        blackjack.BlackJackStart();
        System.out.println("The dealer gives you your cards");
        System.out.println("The total value of your cards right now is " + blackjack.getHandValue());
        System.out.print("Do you wish to hit or stay? ");
        scanner.nextLine();
        String hitstay = scanner.nextLine();
        Boolean decisions = true;
        dealer.BlackJackStart();
        while(dealer.getHandValue() < 15 && blackjack.getHandValue()<21) {
            dealer.hit();
        }
        while (hitstay.equals("hit")) {
            blackjack.hit();
            if (blackjack.gameOver()) {
                System.out.println("your new total value of your cards is " + blackjack.getHandValue());
                if (blackjack.getHandValue() == 21) {
                    System.out.println("you won congrats");
                    hitstay = "stay";
                } else {
                    System.out.println("your hand exceeded 21 and you lost your money");
                    hitstay = "stay";
                }
            } else {
                System.out.println("your new total value of your cards is " + blackjack.getHandValue());
                System.out.print("Do you wish to hit or stay? ");
                hitstay = scanner.nextLine();
            }
        }
        System.out.println("Your hand value right now is " + blackjack.getHandValue());
        System.out.println("The dealers hand is " + dealer.getHandValue());
        if (dealer.getHandValue() > 0 && dealer.getHandValue() <= 21) { //checks if dealer hand is within range
            if(dealer.getHandValue() > blackjack.getHandValue() || blackjack.getHandValue()>21){ //checks for player loss
                System.out.println("you lose");
                this.cash -= blackbet;
            } else if(dealer.getHandValue() < blackjack.getHandValue()){ //checks player win
                System.out.println("you win");
                this.cash += blackbet;
            } else { //runs if equal hand value
                System.out.println("It is a tie");
            }
        } else {
            if(dealer.getHandValue() > 21 && blackjack.getHandValue() > 21 ){ //if dealer hand out of bounds but player hand also out
                System.out.println("The dealer also exceeded 21 but since you did first you lost");
                this.cash -= blackbet;
            } else { //only dealer out of bounds
                System.out.println("you win");
                this.cash+=blackbet;
            }
        }
        System.out.println("Your current balance is now $" + this.cash);
        System.out.print("Do you want to play again?(y/n) ");
        playAgain=scanner.nextLine();
        if (playAgain.equals("y")) {
            BlackJackRunner();
        } else {
            this.cash=blackjack.getCash();
            end();
        }
    }


    public void SpinnerWheel() {
        Roulette spinner = new Roulette(this.cash);
        int white=0;
        int red=0;
        int black=0;
        int green=0;
        int blue=0;
        String x="";
        System.out.print("How much money do you want to bet on white(2x)? ");
        white=scanner.nextInt();
        System.out.print("How much money do you want to bet on red(4x)? ");
        red=scanner.nextInt();
        System.out.print("How much money do you want to bet on black(6x)? ");
        black=scanner.nextInt();
        System.out.print("How much money do you want to bet on green(8x)? ");
        green=scanner.nextInt();
        System.out.print("How much money do you want to bet on blue(21x)? ");
        blue=scanner.nextInt();
        spinner.spin(white, red, black, green, blue);

        x="y";
        while (x.equals("y")) {
            System.out.print("Do you want to spin again?(y/n) ");
            scanner.nextLine();
            x=scanner.nextLine();
            if (x.equals("y")) {
                System.out.print("Do you want to change your bets?(y/n) ");
                x=scanner.nextLine();
                if(x.equals("y")) {
                    System.out.print("How much money do you want to bet on white(2x)? ");
                    white=scanner.nextInt();
                    System.out.print("How much money do you want to bet on red(4x)? ");
                    red=scanner.nextInt();
                    System.out.print("How much money do you want to bet on black(6x)? ");
                    black=scanner.nextInt();
                    System.out.print("How much money do you want to bet on green(8x)? ");
                    green=scanner.nextInt();
                    System.out.print("How much money do you want to bet on blue(21x)? ");
                    blue=scanner.nextInt();
                }
                spinner.spin(white, red, black, green, blue);
            }
        }
        this.cash=spinner.getCash();
        end();
    }


    public void SlotsRunner(){
        System.out.println("Welcome to Slots");
        Slots slots = new Slots(this.cash);
        System.out.println("Do you want to spin?(y/n) ");
        scanner.nextLine();
        String x = scanner.nextLine();
        while (x.equals("y")) {
            System.out.println("spinning now");
            System.out.println();
            slots.spin();
            this.cash-=10;
            System.out.println("------row 1------");
            slots.image(slots.getColumn1());
            System.out.println("------row 2------");
            slots.image(slots.getColumn2());
            System.out.println("------row 3------");
            slots.image(slots.getColumn3());
            System.out.println();
            slots.checkWin();
            System.out.println("You now have $" + this.cash);
            System.out.println("Do you want to spin again?(y/n) ");
            x=scanner.nextLine();
        }
        this.cash=slots.getCash();
        System.out.println("Come back soon!");
        end();
    }


    public void RouletteRunner(){ //for the betting on color/even/odd set blank/doesn't want to bet on as ""
        System.out.println("Welcome to Roulette");
        scanner.nextLine();
        System.out.println("Do you wish to bet on this game (y/n)");
        String betgame = scanner.nextLine();
        Roulette roulette = new Roulette(this.cash);
        while(betgame.equals("y")) {
            System.out.println("How much do you want to bet: ");
            int roulettebet=scanner.nextInt();
            scanner.nextLine();
            System.out.print("What color do you wish to bet on (red / black / none): ");
            String colorBet = scanner.nextLine();
            if (!colorBet.equals("red") && !colorBet.equals("black")) { //checks if input is not equal to either of the accepted values
                colorBet="";
            }
            System.out.print("Do you wish to bet on even or odd (even / odd / none): ");
            String evenBet = scanner.nextLine();
            if (!evenBet.equals("odd") && !evenBet.equals("even")) { //checks if input is not equal to either of the accepted values
                evenBet="";
            }
            roulette.normalRoulette(roulettebet, colorBet,evenBet );
            System.out.println("Do you wish to roll again (y/n): ");
            betgame = scanner.nextLine();
        }
        this.cash=roulette.getCash();
        System.out.println("Come back soon!");
        end();
    }
}