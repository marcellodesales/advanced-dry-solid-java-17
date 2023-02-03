package main.java.com.github.marcellodesales.advanced.records;

import main.java.com.github.marcellodesales.advanced.util.Validator;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Records must be immutable collections must pass an immutable array
 *
 */
public record Order(long id, LocalDateTime when, List<OrderLine> lines) {

    /**
     * Also validates the immutablility.
     *
     * Cananical Constructors access level cannot be more restricive than the one of the record itself
     * It also cannot throw checked exceptions, just runtime exceptions
     *
     * @param id of the order
     * @param when it happened.
     * @param lines all lines of the order
     */
/*    public Order(long id, LocalDateTime when, List<OrderLine> lines) {
        this.id = Validator.checkThatAndReturn(id, id > 0, "ID must be larger than 0");
        this.when = Validator.checkThatAndReturn(when, when != null, "when must be provided!");
        // gets a list of unmodifiableList, all changes throws UnsupportedOperationException
        var unmodifiableLines = List.copyOf(lines);
        this.lines = Validator.checkThatAndReturn(unmodifiableLines, !lines.isEmpty(), "At least 1 item");
    }
 */

    // Write a compact Constructor
    public Order {
        Validator.checkThatAndReturn(id, id > 0, "ID must be larger than 0");
        Validator.checkThatAndReturn(when, when != null, "when must be provided!");
        // gets a list of unmodifiableList, all changes throws UnsupportedOperationException
        //this.lines = List.copyOf(lines); won't compile because the compiler will place the "this.VAR". Just update
        // the argument provided with what's needed and see the notes below (Defensive copy of the argument)
        lines = List.copyOf(lines);

        // the last line the compiler will assign each of the parameters of the constructor, so make sure
        // only the initialize the one we need to make unmodifiable
    }
}
