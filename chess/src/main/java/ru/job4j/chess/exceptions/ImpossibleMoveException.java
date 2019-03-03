package ru.job4j.chess.exceptions;

/**
 * Exception occurs if the figure is not able to move specified way.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 03/03/2019
 */
public class ImpossibleMoveException extends Exception {

    public ImpossibleMoveException(String message) {
        super(message);
    }
}
