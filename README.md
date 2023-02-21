# Advanced Java 17

Advanced topics in Java 17

* Records: Immutable data objects
* Sealed Classes and Interfaces: Control class hierarchies
* Advanced Classes and interfaces: Nested and iner types, Algebric Data types, etc
* Generics: Generic and parameterized types
* Lambda Expressions and method references: anonymous methods and functional interfaces
* Annotations: Metadata for classes to be processed
* Optional: Safe alternative to null
* Try-with-Resources: resources and exception handlers

# Generics

* Generic types: type parameters, prameterized types, type arguments, generic methods
* Bounded type parameters, Generics and inheritance, Raw types, Wildcards with uper/lower bounds, type erasure.
* Generics and arrays
* Parameterized values

# Annotations

* Metadata to javacode
* Use cases: 
  * Provide additional information to compiler
  * @override, @Deprecated, @SupressWarning, @SafeVarargs, @FunctionalInterface
* Processor at compile time, generate code
  * Lombok: generate boilerplate code: projectlombok.org
  * Immutables: immutable value classes: immutables.github.io
  * MapStruct: transform data structures: mapstruct.org, POJO + DTO https://github.com/mapstruct/mapstruct-examples
* Runtime processing of data
  * Spring Framework: spring.io
  * Jackson FasterXML: json/xml
  * JavaEE/JakartaEE
  * JUnit, Checkerframework.org
