package ru.job4j;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.hamcrest.Matchers.is;

/**
 * Logic tests.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 03/03/2019
 */
public class LogicTest {

    @Test
    public void whenFigureMovesThenItExistsOntoDestinatedCell() {
        Logic logic = new Logic();
        try {
            logic.add(new BishopBlack(Cell.E3));
            logic.move(Cell.E3, Cell.A7);
        } catch (FigureNotFoundException fnfe) {
            System.err.println(fnfe);
        } catch (ImpossibleMoveException ime) {
            System.err.println(ime);
        } catch (OccupiedWayException owe) {
            System.err.println(owe);
        }
        Assert.assertThat("Figure's index is not correct on the specified place",
                logic.findBy(Cell.A7), is(0));
    }

    @Test
    public void whenFigureMovesCorrectWayThenExceptionsNotThrown() {
        boolean thrown = false;
        try {
            Logic logic = new Logic();
            logic.add(new BishopBlack(Cell.C1));
            logic.move(Cell.C1, Cell.H6);
        } catch (FigureNotFoundException fnfe) {
            thrown = true;
        } catch (ImpossibleMoveException ime) {
            thrown = true;
        } catch (OccupiedWayException owe) {
            thrown = true;
        }
        Assert.assertFalse("Exception has not been thrown", thrown);
    }

    @Test
    public void whenThereIsNoFigureInSpecifiedCellThenException() {
        boolean thrown = false;
        try {
            Logic logic = new Logic();
            logic.add(new BishopBlack(Cell.F4));
            logic.move(Cell.C5, Cell.E3);
        } catch (FigureNotFoundException fnfe) {
            thrown = true;
        } catch (ImpossibleMoveException ime) {
            thrown = false;
        } catch (OccupiedWayException owe) {
            thrown = false;
        }
        Assert.assertTrue("FigureNotFoundException has not been thrown", thrown);
    }

    @Test
    public void whenFigureMovesOnTheWrongWayThenException() {
        boolean thrown = false;
        try {
            BishopBlack bishopBlack = new BishopBlack(Cell.C8);
            bishopBlack.way(Cell.C8, Cell.C5);
        } catch (ImpossibleMoveException ime) {
            thrown = true;
        }
        Assert.assertTrue("ImpossibleMoveException has not been thrown", thrown);
    }

    @Test
    public void whenThereIsFigureOnTheWayThenExceptionThrows() {
        boolean thrown = false;
        try {
            Logic logic = new Logic();
            logic.add(new PawnBlack(Cell.E7));
            logic.add(new BishopBlack(Cell.F8));
            logic.move(Cell.F8, Cell.C5);
        } catch (OccupiedWayException owe) {
            thrown = true;
        } catch (FigureNotFoundException fnfe) {
            thrown = false;
        } catch (ImpossibleMoveException ime) {
            thrown = false;
        }
        Assert.assertTrue("OccupiedWayException", thrown);
    }
}