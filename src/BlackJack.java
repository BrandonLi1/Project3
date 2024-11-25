import java.util.ArrayList;

public class BlackJack {
    ArrayList<String> cards = new ArrayList<String>();
    public int cash=0;
    private int currentCard=0;
    private int handValue=0;
    public int bid=0;
    private int x=0;

    public BlackJack(int cash, int bid) {
        this.cash = cash;
        if (bid>=cash) {
            this.bid=bid;
        }
        for (int i = 1; i <= 52; i++) {
            cards.add(String.valueOf(i)); //https://www.w3schools.com/java/java_arraylist.asp
        }
    }

    public BlackJack(int cash) {
        this.cash=cash;
        for (int i = 1; i <= 52; i++) {
            cards.add(String.valueOf(i));
        }
    }

    public int getCash() {
        return cash;
    }

    public int getHandValue() {
        return handValue;
    }

    public void BlackJackStart() {
        for (int i = 0; i < 2; i++) {
            currentCard=(int)(Math.random()*cards.size()+1);//https://ioflood.com/blog/length-of-arraylist-java/#:~:text=The%20length%20of%20an%20ArrayList%20in%20Java%20can%20be%20found,elements%20present%20in%20the%20ArrayList.&text=In%20this%20example%2C%20we%20create,element%20'Hello'%20to%20it.
            x= Integer.parseInt(cards.get(currentCard-1));
            checkHand();
            cards.remove(currentCard);
        }

    }

    public int hit() {
        currentCard=(int)(Math.random()*cards.size()+1);
        x= Integer.parseInt(cards.get(currentCard-1));
        checkHand();
        cards.remove(""+ currentCard);
        return handValue;
    }

    public boolean gameOver() {
        if (handValue==21) {
            return true;
        }
        if (handValue>21) {
            return true;
        } else {
            return false;
        }
    }

    private void checkHand() {
        if (x<=4) {
            handValue+=1;
        } else if (x<=8) {
            handValue+=2;
        }else if (x<=12) {
            handValue+=3;
        }else if (x<=16) {
            handValue+=4;
        }else if (x<=20) {
            handValue+=5;
        }else if (x<=24) {
            handValue+=6;
        }else if (x<=28) {
            handValue+=7;
        }else if (x<=32) {
            handValue+=8;
        }else if (x<=36) {
            handValue+=9;
        }else if (x<=52) {
            handValue+=10;
        }
    }
}

