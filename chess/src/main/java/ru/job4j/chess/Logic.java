package ru.job4j.chess;

import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    /**
     * All figures on the Chess board.
     */
    private final Figure[] figures = new Figure[32];

    /**
     * Index of the figure in the figures array.
     */
    private int index = 0;

    /**
     * Adds figure into figures array and sets index for the added figure.
     *
     * @param figure figure
     */
    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    /**
     * Moves the figure from source cell to destination cell.
     *
     * @param source source cell
     * @param dest   destination cell
     * @return result of movement
     */
    public boolean move(Cell source, Cell dest) throws FigureNotFoundException,
            ImpossibleMoveException, OccupiedWayException {
        boolean rst = false;
        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException("Figure has not been found in specified cell.");
        } else {
            Cell[] steps = this.figures[index].way(source, dest);
            this.checkWhetherCellOccupied(steps);
            if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        }
        return rst;
    }

    /**
     * Cleans all figures on the chess board.
     */
    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    /**
     * Finds index of the figure in the figures array by cell.
     *
     * @param cell cell
     * @return index
     */
    public int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    /**
     * Checks whether cell occupied by any figure.
     *
     * @param steps steps array
     * @throws OccupiedWayException
     */
    private void checkWhetherCellOccupied(Cell[] steps) throws OccupiedWayException {
        for (Cell cell : steps) {
            if (this.findBy(cell) != -1) {
                throw new OccupiedWayException("There are figures on the specified way.");
            }
        }
    }
}
