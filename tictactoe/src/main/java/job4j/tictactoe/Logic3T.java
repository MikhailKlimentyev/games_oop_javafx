package job4j.tictactoe;

import java.util.function.Predicate;

/**
 * The type Logic 3 t.
 */
public class Logic3T {

    private final Figure3T[][] table;

    /**
     * Instantiates a new Logic 3 t.
     *
     * @param table the table
     */
    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Проверяет заполнены ли указанные пути X-и
     *
     * @return результат заполнения X-и указанных путей (true если хотя бы один путь заполнен)
     */
    public boolean isWinnerX() {
        Predicate<Figure3T> predicate = figure3T -> figure3T.hasMarkX();
        return isWinner(predicate);
    }

    /**
     * Проверяет заполнены ли указанные пути O-и
     *
     * @return результат заполнения O-и указанных путей (true если хотя бы один путь заполнен)
     */
    public boolean isWinnerO() {
        Predicate<Figure3T> predicate = figure3T -> figure3T.hasMarkO();
        return isWinner(predicate);
    }

    /**
     * Проверяет что каждое поле таблицы заполнено либо X-и, либо O-и
     * если таблица заполнена, то возвращается true
     * если таблица не заполнена, то возвращается false
     *
     * @return the boolean
     */
    public boolean hasGap() {
        int count = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (this.table[i][j].hasMarkX() || this.table[i][j].hasMarkO()) {
                    count++;
                }
            }
        }
        return count != table.length * table.length;
    }

    /**
     * Проверяет заполнен ли указанный путь.
     * Если ячейка заполнена, то она равна true,
     * метод последовательно проходит все ячейки,
     * начиная со стартовой (startX, startY),
     * двигаясь по пути согласно deltaX и deltaY,
     * проверяет заполнена ли каждая ячейка на пути (равна она true или false),
     * если ячейка не заполнена (равна false),
     * то следующая за ней ячейка не проверяется, осуществляется выход из метода,
     * метод возвращает false;
     *
     * @param predicate предикат
     * @param startX    X координата начальной точки
     * @param startY    Y координата начальной точки
     * @param deltaX    перемещение по оси X
     * @param deltaY    перемещение по оси Y
     * @return результат заполнения указанного пути
     */
    private boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean isWinner(Predicate<Figure3T> predicate) {
        return this.fillBy(predicate, 0, 0, 1, 0)
                || this.fillBy(predicate, 0, 0, 0, 1)
                || this.fillBy(predicate, 0, 0, 1, 1)
                || this.fillBy(predicate, this.table.length - 1, 0, -1, 1)
                || this.fillBy(predicate, 0, 2, 1, 0)
                || this.fillBy(predicate, 0, 1, 1, 0)
                || this.fillBy(predicate, 1, 0, 0, 1)
                || this.fillBy(predicate, 2, 0, 0, 1);
    }
}
