package com.github.marcellodesales.advanced.annotations;

/**
 * Allowed element values:
 * - primitive type, string, enum type, java.class.class, annotation type
 * - an array or one of the above
 * - default values cannot be null, cannot be generic nor geenerics, cannot
 * - Spring Component and Service is a pseudo-inheritance
 */
public @interface OrderCommand {

    String value();

    String description() default "";

    int order() default 0;
}

@OrderCommand(value = "super", description = "This is used", order = 3)
class Ordering {

}