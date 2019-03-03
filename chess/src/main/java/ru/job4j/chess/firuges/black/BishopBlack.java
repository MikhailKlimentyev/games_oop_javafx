package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.exceptions.ImpossibleMoveException;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    /**
     * Current BishopBlack's position on the Chess board.
     */
    private final Cell position;

    /**
     * Constructor.
     *
     * @param position сurrent BishopBlack's position on the Chess board.
     */
    public BishopBlack(final Cell position) {
        this.position = position;
    }

    /**
     * Returns сurrent BishopBlack's position on the Chess board.
     *
     * @return cell
     */
    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * Defines array of cells to reach destination cell from source cell
     * if there is diagonal between them.
     *
     * @param source source sell
     * @param dest   destination sell
     * @return steps to reach destination cell from source cell
     * @throws ImpossibleMoveException
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("A Bishop is not able to move such way.");
        }
        int lengthOfWay = Math.abs(dest.y - source.y);
        Cell[] steps = new Cell[lengthOfWay];
        int deltaX = source.x < dest.x ? 1 : -1;
        int deltaY = source.y < dest.y ? 1 : -1;
        System.out.println(String.format("Source cell: %s; Source cell index: %s; Source cell [x: %s, y: %s]",
                source, source.ordinal(), source.x, source.y));
        System.out.println(String.format("Destination cell: %s; Destination cell index: %s; " +
                        "Destination cell [x: %s, y: %s]",
                dest, dest.ordinal(), dest.x, dest.y));
        for (int index = 0; index < steps.length; index++) {
            steps[index] = Cell.values()[(source.x + deltaX * (index + 1)) * 8 + (source.y + deltaY * (index + 1))];
            System.out.println(String.format("Index: %s; Current cell: %s; Current cell index: %s;" +
                            " Current cell [x: %s, y: %s]",
                    index,
                    Cell.values()[(source.x + deltaX * (index + 1)) * 8 + (source.y + deltaY * (index + 1))],
                    Cell.values()[(source.x + deltaX * (index + 1)) * 8 + (source.y + deltaY * (index + 1))].ordinal(),
                    Cell.values()[(source.x + deltaX * (index + 1)) * 8 + (source.y + deltaY * (index + 1))].x,
                    Cell.values()[(source.x + deltaX * (index + 1)) * 8 + (source.y + deltaY * (index + 1))].y));
        }
        return steps;
    }

    /**
     * Creates BishopBlack's instance onto destination cell.
     *
     * @param dest destination cell
     * @return BishopBlack's instance
     */
    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    /**
     * Сhecks whether there is diagonal between source cell and destination cell.
     *
     * @param source source cell
     * @param dest   destination cell
     * @return result of checking
     */
    private boolean isDiagonal(Cell source, Cell dest) {
        boolean rst = false;
        if ((source.x - source.y) == (dest.x - dest.y) || (source.x + source.y) == (dest.x + dest.y)) {
            rst = true;
        }
        return rst;
    }
}
