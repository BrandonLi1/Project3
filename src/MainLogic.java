import java.util.Scanner;


public class MainLogic {
    Scanner scanner = new Scanner(System.in);
    private int cash=0;
    private boolean playing = true;


    public MainLogic () {
        System.out.println("How much cash do you have?");
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
                System.out.print("What game do you wish to play? 1) BlackJack 2) Roulette 3) Slots:");
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
                } else {
                    System.out.println("INVALID RESPONSE");
                    goodresponse = true;
                }
                playing = false;
            }
        }
    }


    public void end() {
        scanner.nextLine();
        boolean goodresponse2 = true;
        while(goodresponse2 == true){
            System.out.print("Do you wish to stay at the casino (yes /  no):");
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
                    System.out.println("Comeback to the Casino whenever you have money to spare");
                }
            } else {
                System.out.println("INVALID RESPONSE");
                goodresponse2 = true;
            }
        }
    }


    public void BlackJackRunner(){
        System.out.print("welcome to black jack how much do you want to bet :");
        int blackbet = scanner.nextInt();
        BlackJack blackjack = new BlackJack(cash, blackbet);
        BlackJack dealer = new BlackJack(cash);
        blackjack.BlackJackStart();
        System.out.println("the dealer gives you your cards");
        System.out.println("The total value of your cards right now is " + blackjack.getHandValue());
        System.out.println("Do you wish to hit or stay?: ");
        String hitstay = scanner.nextLine();
        Boolean decisions = true;
        dealer.BlackJackStart();
        while(dealer.getHandValue() < 15) {
            dealer.hit();
        }
        int dealerhand = dealer.getHandValue();
        while (hitstay.equals("hit")) {
            blackjack.hit();
            if (blackjack.gameOver() == true) {
                System.out.println("your new total value of your cards is" + blackjack.getHandValue());
                if (blackjack.getHandValue() == 21) {
                    System.out.println("you won congrats");
                    hitstay = "stay";
                } else {
                    System.out.println("your hand exceeded 21");
                    hitstay = "stay";
                }
            } else {
                System.out.println("your new total value of your cards is" + blackjack.getHandValue());
                System.out.println("Do you wish to hit or stay?: ");
                hitstay = scanner.nextLine();
            }
        }
    }
}