package ru.job4j.chess.exceptions;

/**
 * Exception occurs if the there is figures on the figures's way.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 03/03/2019
 */
public class OccupiedWayException extends Throwable {

    public OccupiedWayException(String message) {
        super(message);
    }
}
