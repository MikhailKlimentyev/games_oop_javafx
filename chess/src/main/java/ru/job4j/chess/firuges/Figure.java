package ru.job4j.chess.firuges;

import ru.job4j.chess.exceptions.ImpossibleMoveException;

public interface Figure {
    /**
     * Returns current figure's position on the сhess board.
     *
     * @return the current cell
     */
    Cell position();

    /**
     * Check whether the figure moves this way and if so
     * Defines array of cells to reach destination cell from source cell.
     *
     * @param source source sell
     * @param dest   destination sell
     * @return the way to come to the destination sell from the source sell
     */
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    /**
     * Creates the new figure in the destination cell.
     *
     * @param dest destination cell
     * @return new figure
     */
    Figure copy(Cell dest);
}
