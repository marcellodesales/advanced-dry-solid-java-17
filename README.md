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

## Generics

* Generic types: type parameters, prameterized types, type arguments, generic methods
* Bounded type parameters, Generics and inheritance, Raw types, Wildcards with uper/lower bounds, type erasure.
* Generics and arrays
* Parameterized values

## Annotations

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

# Solid Principes

> **CODE EXAMPLES**: https://github.com/dangeabunea/pluralsight-refactoring-solid-java17

* Single Responsibility Principle
* Open-close Principle
* Liskov Substitution Principle
* Interface Segregation Principle
* Dependency Inversion Principle

Easier to understand code and reason

## When not to use

* Code Fragility: when the software breaks in many places.
* Code Rigidity: tendency for software to be difficult to change even in simple ways, with cascading of changes
  * Loosely-coupled systems should have lower rigidity
* High technical debt: the cost of prioritizing fast delivery over code quality for long periods of time
  * Fast Delivery: Easiest Fix/change, Fast, Poorly written code
  * Code Quality: Takes more time, adds more complexity, maintainable code and easier to repair/evolve
  * It will be accumulated over time

## Single Responsibility Principle (SRP)

> "We want to design components that are self-containerd: independent and with a single, well-defined purpose"
> - Andrew Hunt & David Thomas, The pragmatic Programmer

* Every function class or module should have one and only one responsibility
  * Business logic, Persistence, User Interface, Logging/Telemetry, Orchestration, Users,
  * Input/Output, Networking, Error handling
* Classes are less coupled
* If statements, switch statements are candidates
* Code is more difficult to change
  * God classes
  * Methods with too many calls to different concerns
  * Report generation could be repeatable but they would change
* Use events-based alternative for complex orchestration
* Identify Reasons to change -> Refactor 
  * Move other responsibilities
  * Create new classes moving responsibilities
  * Each component (method, class, or package) should have only one reason to change!