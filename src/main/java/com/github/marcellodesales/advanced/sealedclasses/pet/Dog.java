package com.github.marcellodesales.advanced.sealedclasses.pet;

/**
 * Non-sealed classes are open to be extended just as it was before. But it's marked as so
 * because it participates in the sealed class structure of Pet.
 */
public non-sealed class Dog extends Pet {
}

/**
 * As a Dog is non-sealed, a Labrador class can extend the non-sealed class just like java before.
 */
class Labrador extends Dog {}