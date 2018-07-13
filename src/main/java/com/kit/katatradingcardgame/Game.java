package com.kit.katatradingcardgame;

import com.kit.katatradingcardgame.model.Card;
import com.kit.katatradingcardgame.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Game {

    final Map<Player, List<Card>> playerDeck = new ConcurrentHashMap<>();
    private Player firstPlayer;
    private Player secondPlayer;

    final List<Card> gameDeck = new ArrayList<>();

    void buildDeck() {
        int[] cardValue = {0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 7, 8};

        for (int aCardValue : cardValue) {
            Card card = new Card(aCardValue);
            this.gameDeck.add(card);
        }
    }

    void registerPlayers(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    void pickStartingDeck() {
        List<Card> startingHand = new ArrayList<>();
        playerDeck.put(firstPlayer, formStartingHand(startingHand));
        startingHand.clear();
        playerDeck.put(secondPlayer, formStartingHand(startingHand));
    }

    private List<Card> formStartingHand(List<Card> startingHand) {
        for (int numberOfCardInInitialHand = 0; numberOfCardInInitialHand < 3; numberOfCardInInitialHand++) {
            int randomCardFromDeckIndex = (int) (Math.random() * 20);
            startingHand.add(this.gameDeck.get(randomCardFromDeckIndex));
        }
        return startingHand;
    }
}
