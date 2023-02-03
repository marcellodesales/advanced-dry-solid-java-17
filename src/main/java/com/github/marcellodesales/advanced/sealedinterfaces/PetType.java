package com.github.marcellodesales.advanced.sealedinterfaces;

/**
 * Records cannot extend sealed classes
 * Records cannot be sealed
 * Records can implement sealed interfaces (This is useful for Algebraic Data Types)
 *
 * Sealed classes or interfaces should be open for extension
 * Example of extension: Can be used to model the grammar of a language or protocol.
 *
 * Sealed interface for a particular messages protocol and each class for a particular kind of message. This
 * can model the restricted types of messages.
 *
 * Another example of an interface for immutable collections such as the Eclipse collections, where there's a
 * guarantee of the collections that no other class will extend them.
 *
 * Enum defines a type with a fixed set of alternative values, whereas sealed interfaces and records you can define a
 * fixed set of alternative types
 */
public sealed interface PetType extends AnimalType permits DogType, CatType {
}
