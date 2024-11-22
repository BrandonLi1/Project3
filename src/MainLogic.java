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
            System.out.println(RED + "DISCLAIMER WE DO NOT CONDONE CHILD GAMBLING" + RESET);
            System.out.println("WELCOME TO THE CASINO GLOBE");
            boolean goodresponse = true;
            while (goodresponse == true) {
                System.out.println("What game do you wish to play? 1) BlackJack 2) Roulette 3) Slots 4) Spinner Wheel");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    BlackJackRunner();
                    goodresponse = false;
                } else if (choice == 2) {
                    //methods to be added
                    goodresponse = false;
                } else if (choice == 3) {
                    //methods to be added
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


    public void end() {
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
        int dealerhand = dealer.getHandValue();
        while (hitstay.equals("hit")) {
            blackjack.hit();
            if (blackjack.gameOver() == true) {
                System.out.println("your new total value of your cards is " + blackjack.getHandValue());
                if (blackjack.getHandValue() == 21) {
                    System.out.println("you won congrats");
                    this.cash += blackbet;
                    hitstay = "stay";
                } else {
                    System.out.println("your hand exceeded 21 and you lost your money");
                    this.cash -= blackbet;
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
        end();
    }


    public void SlotsRunner(){
        System.out.print("Welcome to Slots, how much do you want to bet: ");
        int slotbet = scanner.nextInt();
        Slots slots = new Slots(this.cash);
    }
}