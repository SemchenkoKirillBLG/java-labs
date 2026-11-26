import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<String> cards = new ArrayList<>();
    private final List<String> dealt = new ArrayList<>();

    public Deck() {
        String[] suits = {"Черви", "Бубны", "Трефы", "Пики"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9",
                          "10", "Валет", "Дама", "Король", "Туз"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(rank + " " + suit);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public String deal() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Колода пуста");
        }

        String card = cards.remove(cards.size() - 1);
        dealt.add(card);
        return card;
    }

    public boolean returnCard(String card) {
        if (!dealt.remove(card)) {
            return false;
        }

        cards.add(card);
        return true;
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        List<String> hand = new ArrayList<>();
        hand.add(deck.deal());
        hand.add(deck.deal());
        System.out.println("Карты игрока: " + hand);

        String card = hand.remove(0);
        System.out.println("Возврат карты: " + deck.returnCard(card));
        System.out.println("Повторный возврат: " + deck.returnCard(card));
    }
}
