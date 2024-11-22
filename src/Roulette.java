import java.util.Scanner;

public class Roulette {
    private int cash;
    private int white;
    private int red;
    private int black;
    private int green;
    private int blue;
    private boolean end;
    private int round;
    private Scanner scan = new Scanner(System.in);


    public Roulette() {
        cash=200;
        round=0;
    }

    public Roulette(int cash) {
        this.cash=cash;
        round=0;
    }

    public void spin(int white, int red, int black, int green, int blue) {
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

    public boolean end() {
        System.out.println("Do you want to cash out?(y/n");
        String x = scan.nextLine();
        if (cash<=0 && x.equals("y")) {
            System.out.println("Go earn money in Black Jack");
            return end=true;
        }
        if (x.equals("y") && cash>0) {
            System.out.println("are you sure?(99% of gamblers quit before they hit big)");
            x=scan.nextLine();
        } else {
            System.out.println("Let's play another round");
            return end = false;
        }
        if (x.equals("y")) {
            System.out.println("wrong choice, you can't leave and now you're in debt");
            cash=-100;
            System.out.println("You now have $" + cash);
            return end = false;
        } else  {
            System.out.println("That's the right choice");
            return end = false;
        }
    }

    public String normalRoulette() {
        int x=0;
        x=(int)(Math.random()*36+1);
        if (x%2==0) {
            return "even";
        } else {
            return "odd";
        }
    }

    public int normalRouletteSpin () {
        int x=0;
        x=(int)(Math.random()*36+1);
        if (x<=18) {
            return 1;
        } else {
            return 2;
        }
    }

    public void normalRoulette (int cash, String color, String EvenOrOdd) {

    }
}
