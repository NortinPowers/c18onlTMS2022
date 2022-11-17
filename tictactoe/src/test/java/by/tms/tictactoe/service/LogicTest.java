package by.tms.tictactoe.service;

import by.tms.tictactoe.model.Figure;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogicTest {

    @Test
    public void whenHasXWinner() {
        Figure[][] table = {
                {new Figure(true, false), new Figure(), new Figure()},
                {new Figure(), new Figure(true, false), new Figure()},
                {new Figure(), new Figure(), new Figure(true, false)},
        };
        Logic logic = new Logic(table);
        assertTrue(logic.isWinnerX());
    }

    @Test
    public void whenNotFill() {
        Figure[][] table = {
                {new Figure(true, false), new Figure(), new Figure()},
                {new Figure(), new Figure(), new Figure()},
                {new Figure(), new Figure(), new Figure()},
        };
        Logic logic = new Logic(table);
        assertFalse(logic.isWinnerX());
        assertFalse(logic.isWinnerO());
    }

    @Test
    public void whenHasXHorizontalWinner() {
        Figure[][] table = {
                {new Figure(), new Figure(), new Figure()},
                {new Figure(true, false), new Figure(true, false), new Figure(true, false)},
                {new Figure(), new Figure(), new Figure()},
        };
        Logic logic = new Logic(table);
        assertTrue(logic.isWinnerX());
    }

    @Test
    public void whenHasXVerticalWinner() {
        Figure[][] table = {
                {new Figure(), new Figure(true, false), new Figure()},
                {new Figure(), new Figure(true, false), new Figure()},
                {new Figure(), new Figure(true, false), new Figure()},
        };
        Logic logic = new Logic(table);
        assertTrue(logic.isWinnerX());
    }

    @Test
    public void whenHasXBackDiagonalWinner() {
        Figure[][] table = {
                {new Figure(), new Figure(), new Figure(true, false)},
                {new Figure(), new Figure(true, false), new Figure()},
                {new Figure(true, false), new Figure(), new Figure()},
        };
        Logic logic = new Logic(table);
        assertTrue(logic.isWinnerX());
    }

    @Test
    public void whenHasOWinner() {
        Figure[][] table = {
                {new Figure(false, true), new Figure(), new Figure()},
                {new Figure(false, true), new Figure(false, false), new Figure()},
                {new Figure(false, true), new Figure(), new Figure(false, false)},
        };
        Logic logic = new Logic(table);
        assertTrue(logic.isWinnerO());
    }

    @Test
    public void whenEmptyCells() {
        Figure[][] table = {
                {new Figure(true, false), new Figure(), new Figure()},
                {new Figure(), new Figure(true, false), new Figure()},
                {new Figure(), new Figure(), new Figure(true, false)},
        };
        Logic logic = new Logic(table);
        assertTrue(logic.checkEmptyCells());
    }
}
