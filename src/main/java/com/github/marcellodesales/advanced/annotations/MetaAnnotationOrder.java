package com.github.marcellodesales.advanced.annotations;

import java.lang.annotation.*;

/**
 * Using @Target to specify what it can be applied for.
 * We can specify an array of them {ElementType.TYPE, ElementType.METHOD, etc}
 */
@Target(ElementType.TYPE)
/**
 * The @Retention annotation is for how long the annotations will be retained
 * RetentionPolicy.RUNTIME: available during the runtime used by reflection to find it
 * RetentionPolicy.SOURCE: the compiler will remove any use of the annotation, and not present at the .class produced. Useful for processing types
 * RetentionPolicy.CLASS: the compiler will keep in the class, but not at runtime. Compiler will not look at it
 */
@Retention(RetentionPolicy.SOURCE)
/**
 * It will be generated in the JavaDocs
 */
@Documented
/**
 * Used for classes only types that can be inherited, subclasses will show to be annotated as well
 */
@Inherited
//@Repeatable //added in Java 8 because the restriction of Annotations could only be used once.
public @interface MetaAnnotationOrder {

}
