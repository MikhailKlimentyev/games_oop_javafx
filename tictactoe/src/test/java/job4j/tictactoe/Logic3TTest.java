package job4j.tictactoe;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Logic3TTest {

    // isWinnerX() tests
    @Test
    public void whenFirstDiagonalFilledByXsThenHasXWinner() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true)},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(true));
    }

    @Test
    public void whenSecondDiagonalFilledByXsThenHasXWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(true)},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T()},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(true));
    }

    @Test
    public void whenFirstRowFilledByXsThenHasXWinner() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(true), new Figure3T(true)},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(true));
    }

    @Test
    public void whenSecondRowFilledByXsThenHasXWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(true), new Figure3T(true)},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(true));
    }

    @Test
    public void whenThirdRowFilledByXsThenHasXWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(true), new Figure3T(true)},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(true));
    }

    @Test
    public void whenFirstColumnFilledByXsThenHasXWinner() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T()},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(true));
    }

    @Test
    public void whenSecondColumnFilledByXsThenHasXWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(true));
    }

    @Test
    public void whenThirdColumnFilledByXsThenHasXWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(true)},
                {new Figure3T(), new Figure3T(), new Figure3T(true)},
                {new Figure3T(), new Figure3T(), new Figure3T(true)},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(true));
    }

    @Test
    public void whenEmptyCellPresentsInRowThenHasNoXWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T(true)},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(false));
    }

    @Test
    public void whenCellFilledByOPresentsInColumnThenHasNoXWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(true)},
                {new Figure3T(), new Figure3T(), new Figure3T(true)},
                {new Figure3T(), new Figure3T(), new Figure3T(false)},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(false));
    }

    // isWinnerO() tests
    @Test
    public void whenFirstDiagonalFilledByOsThenHasOWinner() {
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(false)},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerO(), is(true));
    }

    @Test
    public void whenSecondDiagonalFilledByOsThenHasOWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(false)},
                {new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(false), new Figure3T(), new Figure3T()},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerO(), is(true));
    }

    @Test
    public void whenFirstRowFilledByOsThenHasOWinner() {
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(false), new Figure3T(false)},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerO(), is(true));
    }

    @Test
    public void whenSecondRowFilledByOsThenHasOWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(false), new Figure3T(false), new Figure3T(false)},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerO(), is(true));
    }

    @Test
    public void whenThirdRowFilledByOsThenHasOWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(false), new Figure3T(false), new Figure3T(false)},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerO(), is(true));
    }

    @Test
    public void whenFirstColumnFilledByOsThenHasOWinner() {
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(), new Figure3T()},
                {new Figure3T(false), new Figure3T(), new Figure3T()},
                {new Figure3T(false), new Figure3T(), new Figure3T()},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerO(), is(true));
    }

    @Test
    public void whenSecondColumnFilledByOsThenHasOWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(), new Figure3T(false), new Figure3T()},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerO(), is(true));
    }

    @Test
    public void whenThirdColumnFilledByOsThenHasOWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(false)},
                {new Figure3T(), new Figure3T(), new Figure3T(false)},
                {new Figure3T(), new Figure3T(), new Figure3T(false)},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerO(), is(true));
    }

    @Test
    public void whenEmptyCellPresentsInFirstDiagonalThenHasNoOWinner() {
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(false)},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(false));
    }

    @Test
    public void whenCellFilledByXPresentsInSecondDiagonalThenHasNoOWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(false)},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(false), new Figure3T(), new Figure3T()},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(false));
    }

    // hasGap() tests
    @Test
    public void whenOnlyFirstDiagonalFilledByOsThenHasGap() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.hasGap(), is(true));
    }

    @Test
    public void whenOnlySecondDiagonalFilledByXsThenHasGap() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(false)},
                {new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(false), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.hasGap(), is(true));
    }

    @Test
    public void whenFirstColumnFilledByXsThenHasGap() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.hasGap(), is(true));
    }

    @Test
    public void whenSecondRowFilledByXsThenHasGap() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(false), new Figure3T(false), new Figure3T(false)},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.hasGap(), is(true));
    }

    @Test
    public void whenOneCellEmptyThenHasGap() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(false), new Figure3T()},
                {new Figure3T(false), new Figure3T(true), new Figure3T(true)},
                {new Figure3T(false), new Figure3T(true), new Figure3T(false)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.hasGap(), is(true));
    }

    @Test
    public void whenAllCellsFilledThenHasNoGap() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(false), new Figure3T(true)},
                {new Figure3T(false), new Figure3T(true), new Figure3T(true)},
                {new Figure3T(false), new Figure3T(true), new Figure3T(false)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.hasGap(), is(false));
    }
}
