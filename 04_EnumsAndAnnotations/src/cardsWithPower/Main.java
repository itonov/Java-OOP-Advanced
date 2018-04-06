package cardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstPlayerName = reader.readLine();
        String secondPlayerName = reader.readLine();

        List<Card> cardList = new ArrayList<>();
        Player firstPlayer = new Player(firstPlayerName);
        Player secondPlayer = new Player(secondPlayerName);

        fillCardsFromInput(firstPlayer, reader, cardList);
        fillCardsFromInput(secondPlayer, reader, cardList);

        firstPlayer.getCards().sort(Comparator.comparingInt(Card::getPower).reversed());
        secondPlayer.getCards().sort(Comparator.comparingInt(Card::getPower).reversed());

        Card winningCard;
        if (firstPlayer.getCards().get(0).compareTo(secondPlayer.getCards().get(0)) > 0) {
            winningCard = firstPlayer.getCards().get(0);
            System.out.println(firstPlayer.getName() + " wins with " + winningCard.toString() + ".");
        } else {
            winningCard = secondPlayer.getCards().get(0);
            System.out.println(secondPlayer.getName() + " wins with " + winningCard.toString() + ".");
        }
    }

    private static void fillCardsFromInput(Player player, BufferedReader reader, List<Card> cards) throws IOException {

        for (int i = 0; i < 5; i++) {
            String[] tokens = reader.readLine().split(" ");
            if (tokens[0].equals(tokens[0].toUpperCase())
                    && tokens[1].equals(tokens[1].toLowerCase())
                    && tokens[2].equals(tokens[2].toUpperCase())) {
                boolean hasBeenGiven = false;
                for (Card givenCard : cards) {
                    if (givenCard.getRankName().equalsIgnoreCase(tokens[0])
                            && givenCard.getSuitName().equalsIgnoreCase(tokens[2])) {
                        hasBeenGiven = true;
                    }
                }
                if (!hasBeenGiven) {
                    Card newCard = new Card(RankPower.valueOf(tokens[0]), SuitPower.valueOf(tokens[2]));
                    player.addCard(newCard);
                    cards.add(newCard);
                } else {
                    System.out.println("Card is not in the deck.");
                }
            } else {
                System.out.println("No such card exists.");
                i--;
            }
        }
    }
}
