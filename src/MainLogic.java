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
        while (playing == true) {
            System.out.print(RED + "DISCLAIMER WE DO NOT CONDONE CHILD GAMBLING" + RESET + "\n");
            System.out.println("WELCOME TO THE MILLIONAIRE ISLAND!!!");
            boolean goodresponse = true;
            while (goodresponse == true) {
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
                playing = false;
            }
        }
    }


    private void end() {
        System.out.println();
        boolean goodresponse2 = true;
        while(goodresponse2 == true){
            System.out.print("Do you wish to stay at the casino (yes /  no): ");
            String Stay = scanner.nextLine();
            if(Stay.equals("yes")) {
                playing =true;
                goodresponse2 = false;
                start();
            } else if(Stay.equals("no")){
                int addiction = (int)((Math.random()* 10) + 1);
                if (addiction == 1 || addiction == 2 || addiction == 3) {
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
        while (blackbet<=0) {
            System.out.print("Invalid bet. bet again: ");
            blackbet=scanner.nextInt();
        }
        BlackJack blackjack = new BlackJack(cash, blackbet);
        BlackJack dealer = new BlackJack(cash);
        blackjack.BlackJackStart();
    
        System.out.println("The dealer gives you your cards");
        System.out.println("The total value of your cards right now is " + blackjack.getHandValue());
        dealer.BlackJackStart();
        int dealerhand = dealer.getHandValue();
        System.out.println("The dealer's current hand value is within the range of " + (dealer.getHandValue()-(int)(Math.random()*4+1)) + " to " + (dealer.getHandValue()+((int)(Math.random()*4)+1)));
        System.out.print("Do you wish to hit or stay? ");
        scanner.nextLine();
        String hitstay = scanner.nextLine();
        Boolean decisions = true;
        while (hitstay.equals("hit")) {
            blackjack.hit();
            if (blackjack.gameOver() == true) {
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
        while(dealer.getHandValue() < 15 && blackjack.getHandValue()<21) {
            dealer.hit();
        }
        System.out.println("Your hand value right now is " + blackjack.getHandValue());
        System.out.println("The dealers hand is " + dealer.getHandValue());
        if (dealer.getHandValue() > 0 && dealer.getHandValue() <= 21) {
            if(dealer.getHandValue() > blackjack.getHandValue() || blackjack.getHandValue()>21){
                System.out.println("you lose");
                this.cash -= blackbet;
            } else if(dealer.getHandValue() < blackjack.getHandValue()){
                System.out.println("you win");
                this.cash += blackbet;
            } else {
                System.out.println("It is a tie");
            }
        } else {
            if(dealer.getHandValue() > 21 && blackjack.getHandValue() > 21 ){
                System.out.println("The dealer also exceeded 21 but since you did first you lost");
                this.cash -= blackbet;
            } else {
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
        while (white<0) {
            System.out.print("Invalid bet. bet again: ");
            blackbet=scanner.nextInt();
        }
        System.out.print("How much money do you want to bet on red(4x)? ");
        red=scanner.nextInt();
        while (red<0) {
            System.out.print("Invalid bet. bet again: ");
            blackbet=scanner.nextInt();
        }
        System.out.print("How much money do you want to bet on black(6x)? ");
        black=scanner.nextInt();
        while (black<0) {
            System.out.print("Invalid bet. bet again: ");
            blackbet=scanner.nextInt();
        }
        System.out.print("How much money do you want to bet on green(8x)? ");
        green=scanner.nextInt();
        while (green<0) {
            System.out.print("Invalid bet. bet again: ");
            blackbet=scanner.nextInt();
        }
        System.out.print("How much money do you want to bet on blue(21x)? ");
        blue=scanner.nextInt();
        while (blue<0) {
            System.out.print("Invalid bet. bet again: ");
            blackbet=scanner.nextInt();
        }
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
                    while (white<0) {
                        System.out.print("Invalid bet. bet again: ");
                        blackbet=scanner.nextInt();
                    }
                    System.out.print("How much money do you want to bet on red(4x)? ");
                    red=scanner.nextInt();
                    while (red<0) {
                        System.out.print("Invalid bet. bet again: ");
                        blackbet=scanner.nextInt();
                    }
                    System.out.print("How much money do you want to bet on black(6x)? ");
                    black=scanner.nextInt();
                    while (black<0) {
                        System.out.print("Invalid bet. bet again: ");
                        blackbet=scanner.nextInt();
                    }
                    System.out.print("How much money do you want to bet on green(8x)? ");
                    green=scanner.nextInt();
                    while (green<0) {
                        System.out.print("Invalid bet. bet again: ");
                        blackbet=scanner.nextInt();
                    }
                    System.out.print("How much money do you want to bet on blue(21x)? ");
                    blue=scanner.nextInt();
                    while (blue<0) {
                        System.out.print("Invalid bet. bet again: ");
                        blackbet=scanner.nextInt();
                    }
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
            while (roulettebet<0) {
                System.out.print("Invalid bet. bet again: ");
                blackbet=scanner.nextInt();
            }
            scanner.nextLine();
            System.out.print("What color do you wish to bet on (red / black / none): ");
            String colorBet = scanner.nextLine();
            if (!colorBet.equals("red") && !colorBet.equals("black")) {
                colorBet="";
            }
            System.out.print("Do you wish to bet on even or odd (even / odd / none): ");
            String evenBet = scanner.nextLine();
            if (!evenBet.equals("odd") && !evenBet.equals("even")) {
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
