package com.github.marcellodesales.advanced.annotations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
/**
 * The repeatable annotation was added after Java 8 based on the scenario below: trying to use multiple values in an array
 */
@Repeatable(CommandsByPass.class)
@interface SuperCommand {
    String value();
    String description() default "My default";
    int order() default 0;
}
/**
 * Beginning of annotations support in Java, the restriction was that an annotation could only be used once.
 * That way, users by-passed the restriction by declaring the values as an array of the original annotation
 * so that they could reuse it. This is before the solution of the @Repeatable annotation added in Java 8.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface CommandsByPass {
    SuperCommand[] value();
}

/**
 * This was before Java 8 when the @Repeatable annotation was introduced to solve this problem.
 * @SuperCommand without the annotation @Repeatable had to be used as an array
 */
@CommandsByPass({
        @SuperCommand(value = "command1", description = "super", order = 3),
        @SuperCommand(value = "super1", description = "dont", order = 32)
})
class NonRepeatableLoginCommand {}

/**
 * After Java 8, with @Repeatable, we can repeat the annotations without specifying
 */
@SuperCommand(value = "Login first", order = 10)
@SuperCommand(value = "Then, create this", order = 3)
public class RepeatableAnnotations {

}