import java.util.Scanner;

public class Roulette {
    private int cash;
    private int white;
    private int red;
    private int black;
    private int green;
    private int blue;
    private int round;
    private Scanner scan = new Scanner(System.in);


    public Roulette() { //spinner
        cash=200;
        round=0;
    }

    public int getCash() {
        return cash;
    }

    public Roulette(int cash) { //spinner
        this.cash=cash;
        round=0;
    }

    public void spin(int white, int red, int black, int green, int blue) { //spinner
        int x=0;
        round++;
        cash-=white+red+black+green+blue;
        x= (int) (Math.random()*24);
        if (x<=11) {
            System.out.println("You have rolled on white");
            cash=cash+(white*2);
            System.out.println("You have doubled $" + white + " You now have $" + cash);
        } else if (x<=17) {
            System.out.println("You have rolled on red");
            cash=cash+(red*4);
            System.out.println("You have quadrupled$ " + red + " You now have $" + cash);
        } else if (x<=20) {
            System.out.println("You have rolled on blue");
            cash=cash+(black*6);
            System.out.println("You have sextupled $" + black + " You now have $" + cash);
        } else if (x<=22) {
            System.out.println("You have rolled on green");
            cash=cash+(green*8);
            System.out.println("You have octupled $" + green + " You now have $" + cash);
        } else if (round%5==0 && x==23) {
            System.out.println("You have rolled on blue");
            cash=cash+(blue*21);
            System.out.println("Big Win! You have 21 $" + blue + " You now have $" + cash);
        } else {
            System.out.println("You have rolled on white");
            cash=cash+(white*2);
            System.out.println("You have doubled $ " + white + " You now have $" + cash);
        }
    }

    public void normalRoulette (int bet, String color, String EvenOrOdd) {
        String num = normalRoulette();
        String col="";
        this.cash-=bet;
        if (normalRoulette(0)==2) {
            col="red";
        } else {
            col="black";
        }
        System.out.println("It has rolled " + num + " and " + col);
        
        if (color.equals("") || EvenOrOdd.equals("")) {
            if (color.equals(col)) {
                bet*=2;
                this.cash+=bet;
                System.out.println("You have won! You now have $" + this.cash );
                return;
            }
            if (EvenOrOdd.equals(num)) {
                bet*=2;
                this.cash+=bet;
                System.out.println("You have won! You now have $" + this.cash );
                return;
            }
        } else if (color.equals(col) && EvenOrOdd.equals(num)) {
            bet*=4;
            this.cash+=cash;
            System.out.println("You have won big! You now have $" + this.cash );
            return;
        } 
        System.out.println("You have lost $" + bet + " You now have $" + this.cash);
    }   
    
    private String normalRoulette() {
        int x=0;
        x=(int)(Math.random()*36+1);
        if (x%2==0) {
            return "even";
        } else {
            return "odd";
        }
    }

    private int normalRoulette (int x) {
        x=(int)(Math.random()*36+1);
        if (x<=18) {
            return 1;
        } else {
            return 2;
        }
    }
}
