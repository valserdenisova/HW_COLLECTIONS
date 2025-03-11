package ru.netology.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player player1 = new Player(1, "Player1", 10);
    Player player2 = new Player(2, "Player2", 20);
    Player player3 = new Player(3, "Player3", 30);
    Player player4 = new Player(4, "Player4", 1);
    Player player5 = new Player(5, "Player5", 30);

    Game game = new Game();

    @Test
    public void player1() {
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Player2", "Player1");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void player2() {
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Player1", "Player2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void bothPlayers() {
        game.register(player3);
        game.register(player5);

        int expected = 0;
        int actual = game.round("Player3", "Player5");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playerNotRegistered() {
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player1", "Player3");
        });
    }

    @Test
    public void playerNotRegistered2() {
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player2", "Player4");
        });
    }

    @Test
    public void bothPlayersNotRegistered() {
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player3", "Player2");
        });
    }
}