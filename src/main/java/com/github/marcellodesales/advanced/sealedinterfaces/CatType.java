package com.github.marcellodesales.advanced.sealedinterfaces;

public sealed interface CatType extends PetType permits MainCoon, Siamese {
}
