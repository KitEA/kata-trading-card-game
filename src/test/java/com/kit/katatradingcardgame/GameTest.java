package com.kit.katatradingcardgame;

import com.kit.katatradingcardgame.model.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    public void shouldBuildGameDeck() {
        // given
        Game game = new Game();

        // when
        game.buildDeck();

        // then
        assertThat(game.gameDeck).hasSize(20);
    }

    @Test
    public void shouldBuildHandDeck() {
        // given
        Game game = new Game();
        game.buildDeck();
        Player firstPlayer = new Player("Kit", 30, 0);
        Player secondPlayer = new Player("Eldest", 30, 0);

        // when
        game.registerPlayers(firstPlayer, secondPlayer);
        game.pickStartingDeck();

        // then
        assertThat(game.playerDeck.containsKey(secondPlayer)).isEqualTo(true);
        assertThat(game.playerDeck.isEmpty()).isEqualTo(false);
        assertThat(game.playerDeck.get(firstPlayer).size()).isEqualTo(3);

    }
}
