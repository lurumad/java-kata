package org.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameTest {
    private Game game;

    @BeforeEach
    public void InitializeGame(){
        game = new Game();
    }

    @Test
    void NotAllowPlayerOToPlayFirst() {
        assertThrows(Exception.class, () -> game.Play('O', new Coordinates(0, 0)));
    }

    @Test
    void NotAllowPlayerXToPlayTwiceInARow() {
        assertThrows(Exception.class, () ->{
            game.Play('X', new Coordinates(0, 0));
            game.Play('X', new Coordinates(1, 0));
        });
    }

    @Test
    void NotAllowPlayerToPlayInLastPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.Play('X', new Coordinates(0, 0));
            game.Play('O', new Coordinates(0, 0));
        });
    }

    @Test
    void NotAllowPlayerToPlayInAnyPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.Play('X', new Coordinates(0, 0));
            game.Play('O', new Coordinates(1, 0));
            game.Play('X', new Coordinates(0, 0));
        });
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.Play('X', new Coordinates(0, 0));
        game.Play('O', new Coordinates(1, 0));
        game.Play('X', new Coordinates(0, 1));
        game.Play('O', new Coordinates(1, 1));
        game.Play('X', new Coordinates(0, 2));

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.Play('X', new Coordinates(2, 2));
        game.Play('O', new Coordinates(0, 0));
        game.Play('X', new Coordinates(1, 0));
        game.Play('O', new Coordinates(0, 1));
        game.Play('X', new Coordinates(1, 1));
        game.Play('O', new Coordinates(0, 2));

        char winner = game.Winner();

        assertEquals('O', winner);
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.Play('X', new Coordinates(1, 0));
        game.Play('O', new Coordinates(0, 0));
        game.Play('X', new Coordinates(1, 1));
        game.Play('O', new Coordinates(0, 1));
        game.Play('X', new Coordinates(1, 2));

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.Play('X', new Coordinates(0, 0));
        game.Play('O', new Coordinates(1, 0));
        game.Play('X', new Coordinates(2, 0));
        game.Play('O', new Coordinates(1, 1));
        game.Play('X', new Coordinates(2, 1));
        game.Play('O', new Coordinates(1, 2));

        char winner = game.Winner();

        assertEquals('O', winner);
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.Play('X', new Coordinates(2, 0));
        game.Play('O', new Coordinates(0, 0));
        game.Play('X', new Coordinates(2, 1));
        game.Play('O', new Coordinates(0, 1));
        game.Play('X', new Coordinates(2, 2));

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.Play('X', new Coordinates(0, 0));
        game.Play('O', new Coordinates(2, 0));
        game.Play('X', new Coordinates(1, 0));
        game.Play('O', new Coordinates(2, 1));
        game.Play('X', new Coordinates(1, 1));
        game.Play('O', new Coordinates(2, 2));

        char winner = game.Winner();

        assertEquals('O', winner);
    }
}
