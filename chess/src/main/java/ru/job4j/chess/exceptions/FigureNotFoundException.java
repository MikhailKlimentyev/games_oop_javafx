package ru.job4j.chess.exceptions;

/**
 * Exception occurs if there is no any figures in the specified cell.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 03/03/2019
 */
public class FigureNotFoundException extends Exception {

    public FigureNotFoundException(String message) {
        super(message);
    }
}
