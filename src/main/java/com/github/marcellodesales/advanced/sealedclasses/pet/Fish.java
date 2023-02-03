package com.github.marcellodesales.advanced.sealedclasses.pet;

/**
 *
 */
public sealed class Fish extends Pet permits QuariumFish, OceanFish {
}
