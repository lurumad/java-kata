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
        assertThrows(Exception.class, () -> game.Play(new Coordinates(0, 0), Player.O));
    }

    @Test
    void NotAllowPlayerXToPlayTwiceInARow() {
        assertThrows(Exception.class, () ->{
            game.Play(new Coordinates(0, 0), Player.X);
            game.Play(new Coordinates(1, 0), Player.X);
        });
    }

    @Test
    void NotAllowPlayerToPlayInLastPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.Play(new Coordinates(0, 0), Player.X);
            game.Play(new Coordinates(0, 0), Player.O);
        });
    }

    @Test
    void NotAllowPlayerToPlayInAnyPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.Play(new Coordinates(0, 0), Player.X);
            game.Play(new Coordinates(1, 0), Player.O);
            game.Play(new Coordinates(0, 0), Player.X);
        });
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.Play(new Coordinates(0, 0), Player.X);
        game.Play(new Coordinates(1, 0), Player.O);
        game.Play(new Coordinates(0, 1), Player.X);
        game.Play(new Coordinates(1, 1), Player.O);
        game.Play(new Coordinates(0, 2), Player.X);

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.Play(new Coordinates(2, 2), Player.X);
        game.Play(new Coordinates(0, 0), Player.O);
        game.Play(new Coordinates(1, 0), Player.X);
        game.Play(new Coordinates(0, 1), Player.O);
        game.Play(new Coordinates(1, 1), Player.X);
        game.Play(new Coordinates(0, 2), Player.O);

        char winner = game.Winner();

        assertEquals('O', winner);
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.Play(new Coordinates(1, 0), Player.X);
        game.Play(new Coordinates(0, 0), Player.O);
        game.Play(new Coordinates(1, 1), Player.X);
        game.Play(new Coordinates(0, 1), Player.O);
        game.Play(new Coordinates(1, 2), Player.X);

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.Play(new Coordinates(0, 0), Player.X);
        game.Play(new Coordinates(1, 0), Player.O);
        game.Play(new Coordinates(2, 0), Player.X);
        game.Play(new Coordinates(1, 1), Player.O);
        game.Play(new Coordinates(2, 1), Player.X);
        game.Play(new Coordinates(1, 2), Player.O);

        char winner = game.Winner();

        assertEquals('O', winner);
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.Play(new Coordinates(2, 0), Player.X);
        game.Play(new Coordinates(0, 0), Player.O);
        game.Play(new Coordinates(2, 1), Player.X);
        game.Play(new Coordinates(0, 1), Player.O);
        game.Play(new Coordinates(2, 2), Player.X);

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.Play(new Coordinates(0, 0), Player.X);
        game.Play(new Coordinates(2, 0), Player.O);
        game.Play(new Coordinates(1, 0), Player.X);
        game.Play(new Coordinates(2, 1), Player.O);
        game.Play(new Coordinates(1, 1), Player.X);
        game.Play(new Coordinates(2, 2), Player.O);

        char winner = game.Winner();

        assertEquals('O', winner);
    }
}
