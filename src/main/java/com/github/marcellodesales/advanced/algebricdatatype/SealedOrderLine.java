package com.github.marcellodesales.advanced.algebricdatatype;

/**
 * The Algebric Data Type of SealedOrderLine limits the number of order lines to be implemented to the ones
 * that are permitted in by the interface. This is very specific and doesn't allow this implementation to be extended.
 */
public sealed interface SealedOrderLine permits SaleOrderLine, DiscountOrderLine {
}
