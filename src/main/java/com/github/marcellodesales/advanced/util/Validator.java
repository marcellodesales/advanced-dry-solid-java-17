package main.java.com.github.marcellodesales.advanced.util;

public final class Validator<T> {

    private Validator() {}

    /**
     * Checks the value of T with the boolean expression, showing the error message
     * @param value is any value being evaluated
     * @param expression is the boolean expression being evaluated
     * @param errorMessage is the error Message to be displayed as the Illegal Argument Exception
     * @param <T> Is of any type.
     * @return The provided value returned after the validation.
     */
    public static <T> T checkThatAndReturn(T value, boolean expression, String errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(errorMessage);
        }
        return value;
    }
}
