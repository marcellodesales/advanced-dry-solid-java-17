package com.github.marcellodesales.advanced.sealedclasses.pet;

//import com.github.marcellodesales.advanced.sealedclasses.pet.Animal;
//import com.github.marcellodesales.advanced.sealedclasses.pet.Dog;
//import com.github.marcellodesales.advanced.sealedclasses.pet.Fish;
//import com.github.marcellodesales.advanced.sealedclasses.pet.Cat;
// Sealed classes must be in the same package to be restricted, they can't be moved to another package!

/**
 * Before it was just declaring class final or private constructor
 * Subclasses in the same package only
 * Interfaces could be implemented or extending without any limit
 */
public sealed class Pet extends Animal permits Dog, Fish, Cat {

}


